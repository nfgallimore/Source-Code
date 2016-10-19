/** StringTest.java
 *  Demonstrates a few String operations, particularly == vs equals()
 *  Note that == generally does NOT do what you might expect!
 *
 *  @author:     Dr. Henry H. Leitner
 *  @version:    Last Modified, July 1, 2013
 */

public class StringTest
{
  public static void main(String[] args) 
  {
     String str1 = "aBcD", str2 = "abcd", str3;

     System.out.println("str1 = " + str1 + " and str2 = " + str2);
     System.out.println("str1.equals(str2) = " + str1.equals(str2));
     System.out.println("str1.length() = " + str1.length());
     System.out.println("str1.charAt(1) = " + str1.charAt(1));
     System.out.println("str1.compareTo(\"aBcE\") = " + str1.compareTo("aBcE"));
     System.out.println("str1.compareTo(\"aBcC\") = " + str1.compareTo("aBcC"));
     System.out.println("str1.compareTo(\"aBcD\") = " + str1.compareTo("aBcD"));
     System.out.println("str1.indexOf('D') = " + str1.indexOf('D'));
     System.out.println("str1.indexOf(\"Bc\") = " + str1.indexOf("Bc"));
     System.out.println("str1.indexOf(\"zz\") = " + str1.indexOf("zz"));
     System.out.println("str1.concat(\"efg\") = " + str1.concat("efg"));
     str2 += "abcd";
     System.out.println("str2 += \"abcd\" so str2 = " + str2);
     System.out.println("str2.lastIndexOf(\"c\") = " + str2.lastIndexOf("c"));
     str3 = str1.toLowerCase();
     System.out.println("After str3 = str1.toLowerCase(), str3 = " + str3);
     str3 = str1.toUpperCase();
     System.out.println("After str3 = str1.toUpperCase(), str3 = " + str3);
     System.out.println("str1 = " + str1);
     str3 = String.valueOf(123);
     System.out.println("After str3 = String.valueOf(123); ... ");
     System.out.println("Test if str3.equals(\"123\"): " + str3.equals("123"));
     if (str3 == "123") System.out.println("TRUE -- str3 == \"123\"");
     else System.out.println("FALSE -- str3 != \"123\"");
  }
}
