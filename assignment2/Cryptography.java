// Abbas Yadollahi
// COMP 202 - POMERANTZ
// Assignment 2_________________________


import java.util.Random;

public class Cryptography
{
 public static void main(String[] args)
 {
  System.out.println(caesarEncrypt("Rvzf!",1));
  System.out.println(caesarEncrypt("Rvzf!",27));
  System.out.println(caesarEncrypt("Allah Huakbar!",1));
  System.out.println(caesarEncrypt("Zkkzg Gtzjazq!",1));
  System.out.println(caesarEncrypt("KnKnKkNkNk",53));
  System.out.println(caesarEncrypt("zabcdefghijklmnopqrstuvwxy",1));
  System.out.println(caesarEncrypt("~!@#$%^&*()_+",10));
  System.out.println(caesarEncrypt("   ",1));
  
  System.out.println(caesarDecrypt("~!@#$%^&*()_+",10));
  System.out.println(caesarDecrypt("bcdefghijqlmnopqrstuvwxyza",1));
  System.out.println(caesarDecrypt("Bmmbi Ivblcbs!",1));
  System.out.println(caesarDecrypt("J Mpwf Cbe Cjudift",1));
  System.out.println(caesarDecrypt("#GCHN",27));
  System.out.println(caesarDecrypt("Bccbt Jt Bnbajoh",105));
  System.out.println(caesarDecrypt("Do You Even Lift?",26));
  System.out.println(caesarDecrypt(caesarEncrypt("This Should Be The Same",2),2));
  System.out.println(caesarDecrypt("   ",1));
  
  System.out.println(crackCipher("Uibol zpv!",20));
  System.out.println(crackCipher("@Xlmw #qiwweki $wlsyph %fi ^xli &fiwx *wirx,?.!irgi (tswwmfpi )alir _mx +mw =wlmjxih -fc 4 pixxivw.",4));
  System.out.println(crackCipher("Pdeo iaoowca odkqhz xa pda xaop oajpajya lkooexha sdaj ep eo odebpaz xu 4 happano.",100));
  System.out.println(crackCipher("V'z svanyyl serr sebz nyy zl rknzf :) <3",69));
  System.out.println(crackCipher("H knud annsx",26));
  System.out.println(crackCipher("    ",27));
  
  // char[] element = {' ',' ',' ',' ',' ',' ',' '};
  // char[] element = {'A','B','C','D','E','F','G','H','I','J'};
  // char[] element = {'A','A','A','A','A','A','A','A','A','A','A','A','A','A','A'};
  // char[] element = {'a','h','y','j'};
  // char[] element = {'A','S','S','2','1','0','0'};
  // char[] element = {'A','B','C','D','E','F','G','H','I','J','K','L','M','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  // char[] element = {'A','b','C','d','E','f','G','h','I','j','K','l','M','n','O','p','Q','r','S','t','U','v','W','x','Y','z'};
  // shuffle(element);
  
  System.out.println(generatePermutation());
  
  System.out.println(permuteEncrypt("     "));
  System.out.println(permuteEncrypt("How Do You Do?"));
  System.out.println(permuteEncrypt("#420BlazeIt"));
  System.out.println(permuteEncrypt("I finally finished this COMP 202 assignment after spending over 202 hours on it"));
  System.out.println(permuteEncrypt("I better get 100% on this assignment or I'll find you."));
  System.out.println(permuteEncrypt("Make A Upside Down Kick"));
  System.out.println(permuteEncrypt("These Hoes Ain't Loyal"));
  System.out.println(permuteEncrypt("~`!@#$%^&*()-_=+|]}[{'\";:/?.>,<"));
 }
 
 
 
// Question 1_________________________
 
 public static String caesarEncrypt(String originalMessage,int shift)
 {
  shift = shift % 26;
  int length = originalMessage.length();
  int x = 0;
  String encryptedMessage = "";
  
  while(x < length)
  {
   char oM = originalMessage.charAt(x);
   char letter = (char)(oM + shift);
   
   if(oM >= 'A' && oM <= 'Z' && letter >= '[')
   {
    letter = (char)(letter - 26);
   }
   
   else if(oM >= 'a' && oM <= 'z' && letter >= '{')
   {
    letter = (char)(letter - 26);
   }
   
   else if(oM <= '@' || (oM >= '[' && oM <= '`') || oM >= '{')
   {
    letter = (char)(letter - shift);
   }
   
   encryptedMessage = encryptedMessage + letter;
   
   x++;
  }
  
  return encryptedMessage;
 }
 
 
 
// Question 2_________________________
 
 public static String caesarDecrypt(String encoded,int shift)
 {
  int length = encoded.length();
  shift = shift % 26;
  int x = 0;
  String decryptedMessage = "";
  
  while(x < length)
  {
   char eM = encoded.charAt(x);
   char letter = (char)(eM - shift);
   
   if(eM >= 'A' && eM <= 'Z' && letter <= '@')
   {
    letter = (char)(letter + 26);
   }
   
   else if(eM >= 'a' && eM <= 'z' && letter <= '`')
   {
    letter = (char)(letter + 26);
   }
   
   else if(eM <= '@' || (eM >= '[' && eM <= '`') || eM >= '{')
   {
    letter = (char)(letter + shift);
   }
   
   decryptedMessage = decryptedMessage + letter;
   
   x++;
  }
  
  return decryptedMessage;
 }
 
 
 
// Question 3_________________________
 
 public static String crackCipher(String encoded,int numberLetters)
 {
  int maxWords = 0;
  String bestSentence = "";
  
  for(int shift = 0; shift <= numberLetters; shift++)
  {
   String cracked = caesarDecrypt(encoded,shift);
   int totalWords = SentenceChecker.countEnglishWords(cracked);
   
   if(totalWords > maxWords)
   {
    maxWords = totalWords;
    bestSentence = cracked;
   }
  }
  return bestSentence;
 }
 
 
 
// Question 4_________________________
 
 public static void shuffle(char[] element)
 {
  Random generator = new Random(12345);
  int n = element.length;
  int n4 = (int)Math.pow(n,4);
  
  for(int i = 0; i <= n4; i++)
  {
   int idx1 = generator.nextInt(n);
   int idx2 = generator.nextInt(n);
   
   // System.out.println(idx1 + "," + idx2);
   
   char swap = element[idx1];
   element[idx1] = element [idx2];
   element[idx2] = swap;
  }
  
  // System.out.println(element);
 }
 
 
 
// Question 5_________________________
 
 public static char[] generatePermutation()
 {
  char[] caps = new char[26];
  
  for(int i = 0; i <= 25; i++)
  {
   caps[i] = (char)(i + 'A');
  }
  
  shuffle(caps);
  return caps;
 }
 
 
 
// Question 6_________________________
 
 public static String permuteEncrypt(String input)
 {
  char[] encrypt = new char[input.length()];
  char[] mixedCaps = generatePermutation();
  
  for(int i = 0; i < input.length(); i++)
  {
   char letter = input.charAt(i);
   
   if(letter >= 'A' && letter <= 'Z')
   {
    int idxMC = letter - 'A';
    encrypt[i] = mixedCaps[idxMC];
   }
   
   else if(letter >= 'a' && letter <= 'z')
   {
    int idxMC = letter - 'a';
    encrypt[i] = mixedCaps[idxMC];
   }
   
   else
   {
    encrypt[i] = letter;
   }
  }
  
  String encryptedInput = new String(encrypt);
  return encryptedInput;
 }
}
  

    
    
        
        
        
        
        
        
        
        
        