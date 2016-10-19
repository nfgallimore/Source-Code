// Given an array of String values, write a method that removes
//  all instances of a particular String value from the list

import java.util.*;

class ArrayListDemo
{
    public static void main (String [] args)
    {
        String [] data1 = {"a", "b", "c", "a", "b", "c", "a", "b", "c"};
        test (data1, "a");     	// returns {"b", "c", "b", "c", "b", "c"}
        test (data1, "b");      // returns {"a", "c", "a", "c", "a", "c"}
        test (data1, "c");      // returns {"a", "b", "a", "b", "a", "b"}

        String [] data2 = {"a", "a", "a", "a", "a"};
        test (data2, "a");    	// returns {}
        test (data2, "b");    	// returns {"a", "a", "a", "a", "a"}

        String [] data3 = {}; 
        test (data3, "a");	 	// returns {}
    }

    public static void test (String [] data, String target)
    {
       ArrayList<String> list = new ArrayList<String>();
       for (String word : data) list.add(word);
       System.out.println("Testing " + list);
       System.out.println("   removing " + target);
       removeAll (list, target);
       System.out.println("   result = " + list);
       System.out.println();
    }

    public static void removeAll (ArrayList<String> list, String target)
    {
	 for ( int i = list.size()-1; i >= 0;  i--)
	 {
	     if (list.get(i).equals(target)) list.remove(i);
	 }
    }

}
