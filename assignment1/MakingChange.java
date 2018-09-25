// Assignment 1

// Question 1

  public class MakingChange
  {
    public static void main (String[] args)
    {
     int money = Integer.parseInt(args[0]);
     // int money = 437
     int amount = money;
     
     int toonie = 200;
     int loonie = 100;
     int quarter = 25;
     int dime = 10;
     int nickel = 5;
     int penny = 1;
     
     int numToonie = money / toonie;
     money = money % toonie;
     int numLoonie = money / loonie;
     money = money % loonie;
     int numQuarter = money / quarter;
     money = money % quarter;
     int numDime = money / dime;
     money = money % dime;
     int numNickel = money / nickel;
     money = money % nickel;
     int numPenny = money / penny;
     money = money % penny;
     
     System.out.println ("For " + amount + " cents, you will need...");
     System.out.println ("Toonies: " + numToonie);
     System.out.println ("Loonies: " + numLoonie);
     System.out.println ("Quarters: " + numQuarter);
     System.out.println ("Dimes: " + numDime);
     System.out.println ("Nickels: " + numNickel);
     System.out.println ("Pennies: " + numPenny);
    }
  }