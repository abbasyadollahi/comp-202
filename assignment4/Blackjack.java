// Abbas Yadollahi
// COMP 202 - POMERANTZ
// Assignment 4_________________________


// Question 3_________________________


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Blackjack
{
 public static void main(String[] args)
 {
  int chips = Integer.parseInt(args[0]);
  CardPile gameDeck = CardPile.makeFullDeck(4);
  
  
  // Replays the game until the player either decides to leave or has no chips left, or until the deck has less than 10 cards 
  while(gameDeck.getNumCards() >= 10 && chips > 0)
  {
   System.out.println("--------------------------------------" + "\n" + "~~~$     Welcome to BlackJack     $~~~" + "\n" + "--------------------------------------" + "\n");
   System.out.println("~~~~~ How much would you like to bet? ~~~~~");
   System.out.println("~~~~~ Type a negative number to leave ~~~~~");
   System.out.println("~~~~~* You currently have " + chips + " chips. *~~~~~");
   
   Scanner read = new Scanner(System.in);
   int wager = read.nextInt();
   
   
   // There are different results depending on the input of the player 
   if(wager < 0)
   {
     return;
   }
   else if(wager > chips)
   {
    System.out.println("\n" + "Oops! Looks like you're too broke to bet that many chips... Remember you only have " + chips + " chips left." + "\n");
    try{Thread.sleep(4000);}
    catch(InterruptedException e){Thread.currentThread().interrupt();}
   }
   else
   {
    Enum game = playRound(gameDeck);
    
    if(game == Results.PLAYER_WINS)
    {chips += wager;}
    if(game == Results.BLACKJACK)
    {chips += (3*wager)/2;}
    if(game == Results.DEALER_WINS)
    {chips -= wager;}
    
    System.out.println("\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n");
    try{Thread.sleep(4000);}
    catch(InterruptedException e){Thread.currentThread().interrupt();}
   }
  }
 }
 
 
// ________________________________________
 
 
 // Takes as input a single card and returns the value of the card
 public static int getScore(Card c)
 {
  ArrayList<Value> cardValue = new ArrayList<Value>();
  
  for(Value v : Value.values())
  {
   cardValue.add(v);
  }
  
  int score = cardValue.indexOf(c.getValue());
  
  if(score == 12)
  {
   return 11;
  }
  
  else if(score > 8)
  {
   return 10;
  }

  return score + 2;
 }
 
 
// ________________________________________
 
 
 // Takes a pile of cards and returns the closest score to 21 possible with that hand 
 public static int countValues(CardPile pile)
 {
  int totalScore = 0;
  int aceCount = 0;
  
  for(int i = 0; i < pile.getNumCards(); i++)
  {
   int cardScore = getScore(pile.getCards().get(i));
   
   if(cardScore == 11)
   {
    aceCount++;
   }
   
   if((totalScore + cardScore) > 21 && aceCount != 0)
   {
    totalScore -= 10;
    aceCount --;
   }
   
   totalScore += cardScore;
  }
  
  return totalScore;
 }
 
 
// ________________________________________
 
 
 // This method is used for all the actions that occur during a round of blackjack
 public static Enum playRound(CardPile pile)
 {
  CardPile playerHand = new CardPile();
  CardPile dealerHand = new CardPile();
  
  
  // Deals the first 2 cards to both the player and the dealer and prints them
  for(int i = 0; i < 2; i++)
  {
   playerHand.addToBottom(pile.remove(0));
   dealerHand.addToBottom(pile.remove(0));
  }
  
  System.out.println("\n" + "Dealer's hand : [?] [" + dealerHand.getCards().get(1) + "]");
  System.out.println("Your own hand : [" + playerHand.getCards().get(0) + "] [" + playerHand.getCards().get(1) + "]");
  System.out.println("You currently have a hand worth " + countValues(playerHand) + " points.");
  
  
  // Checks if either the player or the dealer have a blackjack hand
  if(countValues(playerHand) == 21 && countValues(dealerHand) == 21)
  {
   System.out.println("What a coincidence, you both have a blackjack hand! This round ended in a tie.");
   System.out.println("Dealer's hand : [" + dealerHand.getCards().get(0) + "] [" + dealerHand.getCards().get(1) + "]");
   System.out.println("Your own hand : [" + playerHand.getCards().get(0) + "] [" + playerHand.getCards().get(1) + "]");
   return Results.TIE;
  }
   
  else if(countValues(playerHand) == 21)
  {
   System.out.println("\n" + "Congratulations, you win! You have a blackjack hand.");
   System.out.println("Your round winning hand : [" + playerHand.getCards().get(0) + "] [" + playerHand.getCards().get(1) + "]");
   return Results.BLACKJACK;
  }
  
  
  // Allows the player to either hit or stay after receiving his 2 initial cards
  System.out.println("\n" + "----- Your turn -----");
  
  for(int i = 0; countValues(playerHand) < 21; i++)
  {
   System.out.println("\n" + "Would you like to hit (h) or stay (s)?");
   Scanner input = new Scanner(System.in);
   char actionHS = input.next().charAt(0);
   
   if(actionHS == 'h' || actionHS == 'H')
   {
    playerHand.addToBottom(pile.remove(0));
   }
   
   if(actionHS == 's' || actionHS == 'S')
   {
    System.out.print("Your final hand :");
    for(int j = 0; j < playerHand.getNumCards(); j++)
    {
     System.out.print(" [" + playerHand.getCards().get(j) + "]");
    }
    System.out.println("\n" + "Your final hand is worth " + countValues(playerHand) + " points.");
    break;
   }
   
   System.out.print("Your new hand :");
   for(int j = 0; j < playerHand.getNumCards(); j++)
   {
    System.out.print(" [" + playerHand.getCards().get(j) + "]");
   }
   System.out.println("\n" + "Your hand is now worth " + countValues(playerHand) + " points.");
  }
  
  
  // If the player's hand is worth more than 21, he will bust and lose the round
  if(countValues(playerHand) > 21)
  {
   System.out.println("\n" + "You shouldn't have hit! The dealer wins since you busted with a hand of " + countValues(playerHand) + ".");
   return Results.DEALER_WINS;
  }
  
  
  // The dealer has to hit until he has a hand worth 18 or more
  System.out.println("\n" + "----- Dealer's turn -----");
  
  for(int i = 0; countValues(dealerHand) < 18; i++)
  {
   dealerHand.addToBottom(pile.remove(0));
  }
  
  System.out.print("\n" + "The dealer's final hand : [?]");
  for(int j = 1; j < dealerHand.getNumCards(); j++)
  {
   System.out.print(" [" + dealerHand.getCards().get(j) + "]");
  }
  System.out.println();
  
  
  // If the dealer's hand is worth more than 21, he will bust and lose the round
  if(countValues(dealerHand) > 21)
  {
   System.out.println("\n" + "The dealer hit too many times. You win since he busted with a hand of " + countValues(dealerHand) + ".");
   return Results.PLAYER_WINS;
  }
  
  
  // Prints the final hands of both the player and the dealer
  System.out.println("\n" + "----- Result -----");
  
  System.out.println("\n" + "The dealer's final hand is worth " + countValues(dealerHand) + " points.");
  System.out.print("Dealer's hand :");
  for(int i = 0; i < dealerHand.getNumCards(); i++)
  {
   System.out.print(" [" + dealerHand.getCards().get(i) + "]");
  }
  
  System.out.print("\n" + "Your own hand :");
  for(int i = 0; i < playerHand.getNumCards(); i++)
  {
   System.out.print(" [" + playerHand.getCards().get(i) + "]");
  }
  System.out.println("\n" + "Your final hand is worth " + countValues(playerHand) + " points.");
  
  
  // If neither the player or the dealer got blackjack or busted, we have to determine who's hand is closer to 21
  int playerScore = countValues(playerHand);
  int dealerScore = countValues(dealerHand);
  
  if(playerScore > dealerScore)
  {
   System.out.println("\n" + "Congratulations! You win with a hand of " + playerScore + " points.");
   return Results.PLAYER_WINS;
  }
  
  else if(playerScore < dealerScore)
  {
   System.out.println("\n" + "You lost... The dealer wins since he has a hand of " + dealerScore + " points.");
   return Results.DEALER_WINS;
  }
  
  else
  {
   System.out.println("\n" + "Nobody won this time! It's a tie since both your hands are worth " + playerScore + " points.");
   return Results.TIE;
  }
 }
 
 
 
 // Question 5_________________________
 
 
 public enum Results
 {
  DEALER_WINS, PLAYER_WINS, TIE, BLACKJACK
 }
}
 






