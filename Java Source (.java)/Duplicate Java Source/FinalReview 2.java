import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class FinalReview {
  
  public static void main(String[]args){
    
    // recursive method example
    mirrorString("String");
    System.out.println();
    
    System.out.println("\n-----------------------------------------\n");
    // file i/o example
    readFile();
    
    System.out.println("\n-----------------------------------------\n");
    // multidimensional array example
    int [][] arr2d = { {2,1,5,7,1,8}, {4,3,9,2,4,9}, {2,6,7,9,1,7} };// new int[2][2];
    display2dArray(arr2d);
    sort2dArray(arr2d);
    display2dArray(arr2d);
    
    System.out.println("\n-----------------------------------------\n");
    // Arrays class methods example
    int [] arr = {1,2,3,2,3,4,5,3,34,23,4,32,43,56};
    
    // sort method
    // defaults to natural order, in this case ascending
    // does not return a value, instead sorts the original array
    System.out.print("Before sorting: ");
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
    System.out.print("After sorting: ");
    System.out.println(Arrays.toString(arr));
    
    // binarySearch method
    System.out.printf("Searching for 32...\nFound at index: %d\n", Arrays.binarySearch(arr, 32));
    
  }
  
  /**
   * "String"
   * "StringgnirtS"
   */
  public static void mirrorString(String str){
    
    //base case
    if(str.length() == 1){
      System.out.print(str.charAt(0));
      System.out.print(str.charAt(0));
    } 
    //recursive case
    else {
      System.out.print(str.charAt(0));
      mirrorString(str.substring(1));
      System.out.print(str.charAt(0));
    }
  }
  
  public static void sort2dArray(int [][] arr){
    for (int i = 0; i < arr.length; i++){
      Arrays.sort(arr[i]);
    }
  }
  public static void display2dArray(int [][] arr){
    
    // using the Arrays class
    for (int i = 0; i < arr.length; i++){  
      System.out.println(Arrays.toString(arr[i]));
    }
    
    // the iterative approach
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr[i].length; j++){
        System.out.print(arr[i][j]+ " ");
      }
      System.out.println();
    }
    System.out.println();
  }
  
  public static void readFile() {
    
    File f = new File("finalReview.txt");
    try {
      Scanner fileScanner = new Scanner(f);
      
      while(fileScanner.hasNextLine()){
        String line = fileScanner.nextLine();
        mirrorString(line);
        System.out.println();
      }
    } catch (FileNotFoundException fnfe){
      System.out.println("Sorry, couldn't find that file!");
    }
  }
}
