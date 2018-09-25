// Abbas Yadollahi
// COMP 202 - POMERANTZ
// Assignment 3_________________________


// Question 1_________________________


// import java.util.Arrays;

public class Sudoku
{
 public static void main(String[] args)
 {
  int[] array = {2,4,1,5,8,7,3,9,6};
  
  //int[][] puzzle = {{1,2,3},{4,5,6},{7,8,9}};
  //int[][] puzzle = {{1,4,7},{2,5,8},{3,7,9}};
  //int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
  int[][] puzzle = {{4,3,1,6,7,9,5,2,8},{9,6,7,2,5,8,3,4,1},{5,8,2,1,4,3,9,6,7},{6,5,9,8,1,7,2,3,4},{3,2,8,5,6,4,1,7,9},{7,1,4,9,3,2,8,5,6},{8,7,3,4,2,1,6,9,5},{1,4,5,3,9,6,7,8,2},{2,9,6,7,8,5,4,1,3}};
  System.out.println(isSudoku(puzzle));
  
/*if(isSudoku(puzzle))
  {
  System.out.println(uniqueEntries(array));
  
  System.out.println(Arrays.toString(sort(array)));
  
  System.out.println(Arrays.toString(getColumn(puzzle,0)));
  
  System.out.println(Arrays.toString(flatten(puzzle)));
  
  System.out.println(Arrays.deepToString(subGrid(puzzle,1,1,6)));
  
  System.out.println(minValue(array));
  
  System.out.println(maxValue(array));
  }
*/
 }
 
 
 // Checks all the the conditions needed to verify if a puzzle is a valid solution or not and returns the validity
 public static boolean isSudoku(int[][] puzzle)
 {
  // Check if size is 9x9_______________
  if(puzzle.length != 9)
  {
   return false;
  }
  for(int i = 0; i < puzzle.length; i++)
  {
   if(puzzle[i].length != 9)
   {
    return false;
   }
  }
  
  // Check if rows/columns contains doubles_______________
  for(int i = 0; i < puzzle.length; i++)
  {
   if(!uniqueEntries(puzzle[i]) || !uniqueEntries(getColumn(puzzle,i)))
   {
    return false;
   }
  }
  
  // Check if each row/column contains 1-9_______________
  for(int i = 0; i < puzzle.length; i++)
  {
   if(minValue(puzzle[i]) != 1 || maxValue(puzzle[i]) != 9 || minValue(getColumn(puzzle,i)) != 1 || maxValue(getColumn(puzzle,i)) != 9)
   {
    return false;
   }
  }
  
  // Check if each 3x3 grid contains 1-9 or doubles_______________
  for(int i = 0; i <= puzzle.length - 3; i += 3)
  {
   for(int j = 0; j <= puzzle[0].length - 3; j += 3)
   {
    if(!uniqueEntries(flatten(subGrid(puzzle,i,j,3))) || minValue(flatten(subGrid(puzzle,i,j,3))) != 1 || maxValue(flatten(subGrid(puzzle,i,j,3))) != 9)
    {
     return false;
    }
   }
  }
  
  // If nothing is false, the puzzle is a valid solution_______________
  return true;
 }
 
 
 // Sorts the input array in increasing order and then returns it 
 public static int[] sort(int[] array)
 {
  for(int i = 0; i < array.length; i++)
  {
   for(int j = i; j < array.length; j++)
   {
    if(array[j] <= array[i])
    {
     int temp = array[j];
     array[j] = array[i];
     array[i] = temp;
    }
   }
  }
  return array;
 }
 
 
 // Checks if there's any doubles in the input array and returns true if it's unique
 public static boolean uniqueEntries(int[] array)
 {
  for(int i = 0; i < array.length; i++)
  {
   for(int j = 0; j < array.length; j++)
   {
    if(i != j && array[i] == array[j])
    {
     return false;
    }
   }
  }
  return true;
 }
 
 
 // Gets the column j in the 2D input array and returns it
 public static int[] getColumn(int[][] puzzle,int j)
 {
  int[] column = new int[puzzle[0].length];
  
  for(int i = 0; i < puzzle[0].length; i++)
  {
   column[i] = puzzle[i][j];
  }
  return column;
 }
 
 
 // Takes a 2D array and flattens the entire content into one array and returns it
 public static int[] flatten(int[][] puzzle)
 {
  int[] flat = new int[puzzle.length*puzzle[0].length];
  int idx = 0;
  
  for(int i = 0; i < puzzle.length; i++)
  {
   for(int j = 0; j < puzzle[0].length; j++)
   {
    flat[idx] = puzzle[i][j];
    idx++;
   }
  }
  return flat;
 }
 
 
 // Returns a square subgrid of size m from the original 2D array, beginning from the index (i,j)
 public static int[][] subGrid(int[][] puzzle,int i,int j,int m)
 {
  int maxRowIdx = i + m - 1;
  int maxColumnIdx = j + m - 1;
  int[][] section = new int[m][m];
  int x = i, y = j;
  
  for(int idx1 = 0; x <= maxRowIdx; idx1++)
  {
   for(int idx2 = 0; y <= maxColumnIdx; idx2++)
   {
    section[idx1][idx2] = puzzle[x][y];
    y++;
   }
   x++;
   y = j;
  }
  return section;
 }
 
 
 // Finds and returns the minimum value in the input array
 public static int minValue(int[] array)
 {
  int min = array[0];
  
  for(int i = 0; i < array.length; i++)
  {
   if(array[i] < min)
   {
    min = array[i];
   }
  }
  return min;
 }
 
 // Finds and returns the maximum value in the input array
 public static int maxValue(int[] array)
 {
  int max = array[0];
  
  for(int i = 0; i < array.length; i++)
  {
   if(array[i] > max)
   {
    max = array[i];
   }
  }
  return max;
 }
}
 
 
 
 
 
 
 
 
 
 