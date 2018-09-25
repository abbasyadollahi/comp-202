// Abbas Yadollahi
// COMP 202 - POMERANTZ
// Assignment 3_________________________


// Question 3_________________________


public class CardPile
{
 private Card[] cards;
 private int numCards;
 
 // Creates the properties of a card pile
 public CardPile()
 {
  cards = new Card[52];
  numCards = 0;
 }
 
 // Adds the input card to the first null position in the deck
 public void addToBottom(Card c)
 {
  cards[numCards] = c;
  
  numCards++;
 }
 
 // Checks if the deck is empty and returns true if it is
 public boolean isEmpty()
 {
  if(numCards == 0)
  {
   return true;
  }
  
  return false;
 }
 
 // Gets the card in the input position in the deck and returns it
 public Card get(int i)
 {
  return cards[i];
 }
 
 // Removes the card at the input position from the deck and returns it and shifts all cards down by one index
 public Card remove(int i)
 {
  Card temporary = cards[i];
  
  while(i < cards.length - 1)
  {
   this.cards[i] = cards[i+1];
   
   i++;
  }
  
  cards[cards.length - 1] = null;
  numCards--;
  return temporary;
 }
 
 // Finds the position of the specific card with the same input suit/value in the deck and return it
 public int find(Suit s, Value v)
 {
  for(int i = 0; i < numCards; i++)
  {
   if(cards[i].getSuit() == s && cards[i].getValue() == v)
   {
    return i;
   }
  }
  
  return -1;
 }
 
 // Creates a string of all the cards inside the player's deck and returns it
 public String toString()
 {
  String listOfCards = "";
  
  for(int i = 0; i < numCards; i++)
  {
   String theCard = (i + 1) + "." + cards[i].toString() + " ";
   
   listOfCards = listOfCards + theCard;
  }
  
  return listOfCards;
 }
 
 // Creates a full deck including 52 cards, one of each suit and value, shuffles it then returns
 public static CardPile makeFullDeck()
 {
  CardPile deck = new CardPile();
  int idx = 0;
  
  for(Suit s : Suit.values())
  {
   for(Value v : Value.values())
   {
    deck.cards[idx] = new Card(s,v);
    
    deck.numCards++;
    idx++;
   }
  }
  
  UtilityCode.shuffle(deck.cards, deck.numCards);
  return deck;
 }
}