import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SentenceChecker {
    final static int NUMBER_WORDS = 234936;
    
    public static String[] wordList = initializeList();

    public static int countEnglishWords(String input) {
 String[] allWords = input.split(" ");
 int totalWords = 0;
 for (int i=0; i < allWords.length; i++) {
     String transformed = allWords[i].toLowerCase();
     transformed = transformed.replaceAll("[^A-Za-z]", "");
     if (findWord(transformed)) {
  totalWords++;
     }
 }

 return totalWords;
    }

    private static boolean findWord(String input) {
 int left = 0;
 int right = wordList.length - 1;
 while (left <= right) {
     int center = (left + right ) / 2;
     if (wordList[center].equals(input)) {
  return true;
     }

     if (wordList[center].compareTo(input) < 0) {
  left = center + 1;
     }
     else {
  right = center - 1;
     }
 }

 return false;
    }

    private static String[] initializeList() {
 try {
     Scanner scanner = new Scanner(new File("web2.txt"));
     String[] words = new String[NUMBER_WORDS];
     int i=0;
     
     while (scanner.hasNextLine()) {
  words[i] = scanner.nextLine().toLowerCase();
  i++;
     }
     return words;
 }
 catch (FileNotFoundException e) {
     System.out.println("WARNING: The file web2.txt was not found. Is it in the same directory as your other java files?");
     return null;
 }
    }
}
