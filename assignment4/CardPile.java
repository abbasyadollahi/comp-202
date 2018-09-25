// Abbas Yadollahi
// COMP 202 - POMERANTZ
// Assignment 4_________________________


// Question 1_________________________


import java.util.ArrayList;
import java.util.Collections;

public class CardPile
{
 private ArrayList<Card> cards;
 private int numCards;
 
 // Creates the properties of a card pile
 public CardPile()
 {
  cards = new ArrayList<Card>();
  numCards = 0;
 }
 
 // Adds the input card to the first null position in the deck
 public void addToBottom(Card c)
 {
  cards.add(c);
  
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
 
 // Removes the card at the input position from the deck and returns it and shifts all cards down by one index
 public Card remove(int i)
 {
  numCards--;
  
  return cards.remove(i);
 }
 
 // Finds the position of the specific card with the same input suit/value in the deck and returns it
 public int find(Suit s, Value v)
 {
  for(int i = 0; i < numCards; i++)
  {
   if(cards.get(i).getSuit() == s && cards.get(i).getValue() == v)
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
   String theCard = "[" + cards.get(i).toString() + "] ";
   
   listOfCards = listOfCards + theCard;
  }
  
  return listOfCards;
 }
 
 // Creates a full deck including 52 cards, one of each suit and value, shuffles it then returns
 public static CardPile makeFullDeck()
 {
  CardPile deck = new CardPile();
  
  for(Suit s : Suit.values())
  {
   for(Value v : Value.values())
   {
    deck.cards.add(new Card(s,v));
    
    deck.numCards++;
   }
  }
  
  Collections.shuffle(deck.cards);
  return deck;
 }
 
 
 
 // Question 2_________________________
 
 
 // Creates a pile of cards with n doubles of each card, shuffles it then returns it
 public static CardPile makeFullDeck(int n)
 {
  CardPile multiDeck = new CardPile();
  
  for(int i = 1; i <= n; i++)
  {
   for(Suit s : Suit.values())
   {
    for(Value v : Value.values())
    {
     multiDeck.cards.add(new Card(s,v));
     
     multiDeck.numCards++;
    }
   }
  }
  
  Collections.shuffle(multiDeck.cards);
  return multiDeck;
 }
 
 // Returns the number of cards in CardPile (numCards)
 public int getNumCards()
 {
  return numCards;
 }
 
 // Returns the array list of cards in CardPile (cards)
 public ArrayList<Card> getCards()
 {
  return cards;
 }
}




