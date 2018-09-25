// Assignment 1

// Question 3

public class DnaUtilities
{
 public static void main(String[] args)
 {
  System.out.println(isValidBase('A'));
  System.out.println(isValidBase('C'));
  System.out.println(isValidBase('G'));
  System.out.println(isValidBase('T'));
  System.out.println(isValidBase('x'));
  System.out.println(isValidBase('y'));
  System.out.println(isValidBase('a'));
  System.out.println(isValidBase('t'));
  System.out.println(isValidBase('0'));
  System.out.println(isValidBase('#'));
  
  System.out.println(watsonCrickComplement('A'));
  System.out.println(watsonCrickComplement('C'));
  System.out.println(watsonCrickComplement('G'));
  System.out.println(watsonCrickComplement('T'));
  System.out.println(watsonCrickComplement('x'));
  System.out.println(watsonCrickComplement('y'));
  System.out.println(watsonCrickComplement('a'));
  System.out.println(watsonCrickComplement('t'));
  System.out.println(watsonCrickComplement('0'));
  System.out.println(watsonCrickComplement('#'));
  
  System.out.println(watsonCrickTripletComplement("ACA"));
  System.out.println(watsonCrickTripletComplement("CGA"));
  System.out.println(watsonCrickTripletComplement("AGT"));
  System.out.println(watsonCrickTripletComplement("TTT"));
  System.out.println(watsonCrickTripletComplement("Ad4"));
  System.out.println(watsonCrickTripletComplement("g#2"));
  System.out.println(watsonCrickTripletComplement("LOL"));
  System.out.println(watsonCrickTripletComplement("ACTG"));
  System.out.println(watsonCrickTripletComplement("G"));
  System.out.println(watsonCrickTripletComplement("Ag"));
 }
 
 public static boolean isValidBase(char x)
 {
  boolean answerTrue = true;
  boolean answerFalse = false;
  
  if(x == 'A' || x == 'C' || x == 'G' || x == 'T')
  {
   return answerTrue;
  }
  else
  {
   return answerFalse;
  }
 }
 
 public static char watsonCrickComplement(char x)
 {
  
  if(isValidBase(x) == true)
  {
   if(x == 'A')
   {
    return 'T';
   }
   else if(x == 'C')
   {
    return 'G';
   }
   else if(x == 'G')
   {
    return 'C';
   }
   else
   {
    return ('A');
   }
  }
  else
  {
   return x;
  }
 }
 
 public static String watsonCrickTripletComplement(String dnaSequence)
 {
  
  if(dnaSequence.length() == 3)
  {
   char firstLetter = dnaSequence.charAt(0);
   char secondLetter = dnaSequence.charAt(1);
   char thirdLetter = dnaSequence.charAt(2);
   
   if(isValidBase(firstLetter) == true && isValidBase(secondLetter) == true && isValidBase(thirdLetter) == true)
   {
    char firstChar = watsonCrickComplement(firstLetter);
    char secondChar = watsonCrickComplement(secondLetter);
    char thirdChar = watsonCrickComplement(thirdLetter);
    
    String newStrand = "" + firstChar + secondChar + thirdChar;
    return newStrand;
   }
   else
   {
    String empty = "";
    return empty;
   }
  }
  else
  {
   String empty = "";
   return empty;
  }
 }
}