// Abbas Yadollahi
// COMP 202 - POMERANTZ
// Assignment 3_________________________


// Question 4_________________________


public class CardGame
{
 public static void main(String[] args)
 {
  int players = Integer.parseInt(args[0]);
  
  // Creates one full game deck and the empty deck's of the players
  CardPile gameDeck = CardPile.makeFullDeck();
  CardPile[] playerDeck = new CardPile[players];
  
  for(int i = 0; i < players; i++)
  {
   playerDeck[i] = new CardPile();
  }
  
  // Distributes a card to every player until there's no cards left in the game deck
  for(int i = 0; !gameDeck.isEmpty(); i++)
  {
   if(i == players)
   {
    i = 0;
   }
   playerDeck[i].addToBottom(gameDeck.remove(0));
  }
  
//  for(int i = 0; i < players; i++)
//  {System.out.println("Player " + (i + 1) + ": " + playerDeck[i].toString());}
  
  // Finds the player who has the Ace of Spades in his deck and prints that he's the winner
  int winner = 0;
  
  for(int i = 0; i < players; i++)
  {
   if(playerDeck[i].find(Suit.SPADES,Value.ACE) != -1)
   {
    winner = i + 1;
    break;
   }
  }
  
  System.out.println("The winner of this boring game is: Player " + winner);
  System.out.println("Congratulations, you win absolutely nothing. Now go start assignment 4.");
 }
}