import java.util.Arrays;
class Longer {
  public static void main (String[] args) {
    String[] a1 = {"star","pie","jelly bean","car"};
    String[] a2 = {"cookie","fig","banana","soda"};
    System.out.println(Arrays.toString(longer(a1,a2)));
    
    a1 = new String[]{"Splinter","Leo","April","Don"};
    a2 = new String[]{"Krang","Shredder","Bebop"};
    System.out.println(Arrays.toString(longer(a1,a2)));
  }
  
  public static String[] longer (String[] a1, String[] a2) {
    int length = a2.length;
    if (a1.length >= a2.length) length = a1.length;
    
    int stop = a2.length;
    if (a1.length < a2.length) stop = a1.length;
    
    // create the new array to store longer strings
    String[] a3 = new String[length];
    
    for (int i = 0; i < a3.length; i++) {
      if (i < stop) {
        
        // compare lengths of the strings at this index
        if (a1[i].length() >= a2[i].length()) { 
          a3[i] = a1[i];
        }
        else {
          a3[i] = a2[i];
        }
      }
      
      // if we've passed the length of the shorter array, this
      // index must be 'oops'
      else {
        a3[i] = "oops";
      }
    }
    return a3;
  }
}