// Assignment 1

// Question 2

public class LeapYearCalculator
{
 public static void main(String[] args)
 {
  printIsLeapYear(2000);
  printIsLeapYear(1999);
  printIsLeapYear(1900);
  printIsLeapYear(1896);
  printIsLeapYear(233);
  printIsLeapYear(36);
  printIsLeapYear(4);
  printIsLeapYear(1);
  printIsLeapYear(subsequentLeapYear(1891));
  printIsLeapYear(subsequentLeapYear(1892));
  printIsLeapYear(subsequentLeapYear(1893));
  printIsLeapYear(subsequentLeapYear(1894));
  printIsLeapYear(subsequentLeapYear(1895));
  printIsLeapYear(subsequentLeapYear(1896));
  printIsLeapYear(subsequentLeapYear(1897));
  printIsLeapYear(subsequentLeapYear(1898));
  printIsLeapYear(subsequentLeapYear(1899));
  printIsLeapYear(subsequentLeapYear(1900));
  printIsLeapYear(subsequentLeapYear(2000));
 }
  
 public static void printIsLeapYear(int year)
 {
  if(isLeapYear(year) == true)
  {
   System.out.println("The year " + year + " is a leap year.");
   return;
  }
  else 
  {
   System.out.println("The year " + year + " is not a leap year.");
   return;
  }
 }
  
 public static boolean isLeapYear(int year)
 {
  boolean answerFalse = false;
  boolean answerTrue = true;
  
  if(year % 400 == 0)
  {
   return answerTrue;
  }
  else if(year % 100 == 0)
  {
   return answerFalse;
  }
  else if(year % 4 == 0)
  {
   return answerTrue;
  }
  else
  {
   return answerFalse;
  }
 }
  
 public static int subsequentLeapYear(int year)
 {
  if(isLeapYear(year) == false)
  {
   if(isLeapYear(year + 1) == true)
   {
    return (year + 1);
   }
   else if(isLeapYear(year + 2) == true)
   {
    return (year + 2);
   }
   else if(isLeapYear(year + 3) == true)
   {
    return (year + 3);
   }
   else if(isLeapYear(year + 4) == true)
   {
    return (year + 4);
   }
   else if(isLeapYear(year + 5) == true)
   {  
    return (year + 5);
   }
   else if(isLeapYear(year + 6) == true)
   {  
    return (year + 6);
   }
   else
   {
    return (year + 7);
   }
  }
  else
  {
   if(isLeapYear(year + 4) == true)
   {
    return (year + 4);
   }
   else 
   {  
    return (year + 8);
   }
  }
 }
}