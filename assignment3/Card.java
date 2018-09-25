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
  String myCard = getValue() + " of " + getSuit();
  return myCard;
 }
}
