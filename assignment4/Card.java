// Abbas Yadollahi
// COMP 202 - POMERANTZ
// Assignment 3_________________________


// Question 2_________________________


public class Card
{
 private Suit suit;
 private Value value;
 
 
 // Constructs a card object with the suit and value properties
 public Card(Suit theSuit, Value theValue)
 {
  suit = theSuit;
  value = theValue;
 }
 
 
 // Gets the suit of the card and returns it
 public Suit getSuit()
 {
  return suit;
 }
 
 
 // Gets the value of the card and returns it
 public Value getValue()
 {
  return value;
 }
 
 
 // Creates a string representing the card's value and suit and returns it
 public String toString()
 {
  String myCard = "";
  
  if(getValue().ordinal() >= 0 && getValue().ordinal() <= 8)
  {
   myCard = "" + (getValue().ordinal() + 2) + getSuit().toString().charAt(0);
  }
  
  else if(getValue().ordinal() == 9)
  {
   myCard = "J" + getSuit().toString().charAt(0);
  }
  
  else if(getValue().ordinal() == 10)
  {
   myCard = "Q" + getSuit().toString().charAt(0);
  }
  
  else if(getValue().ordinal() == 11)
  {
   myCard = "K" + getSuit().toString().charAt(0);
  }
  
  else if(getValue().ordinal() == 12)
  {
   myCard = "A" + getSuit().toString().charAt(0);
  }
  
  return myCard;
 }
}
