import java.util.*;

public class recursiveCaesar
{
	public static void main(String[] args)
	{
		// todo
		System.out.println(encipher("HELLO", 1));
	}
	public static boolean isAlpha(char c)
	{
		return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
	}
	public static boolean isUpper(char c)
	{
		return (c >= 'A' && c <= 'Z');
	}
	public static char shiftChar(char c, int key)
	{
		if ( !isAlpha(c) ) return c;
		char a = 'A';
		c -= a; 
		c += key; 
		c %= 26; 
		c += a;
		return (char)c;
	}
	public static String encipher(String s, int key)
	{
		
		if (s.length() == 0) return "";
		return encipher(s.charAt(s.length()) + encipher(s.substring(s.length()-1, 0).length(), key));
		/*
		String code = "\n";
		for (int i = 0; i < s.length(); i++) {
            if (isAlpha(s.charAt(i)) && isUpper(s.charAt(i))) 
            	code += shiftChar(s.charAt(i), key);
            else code += s.charAt(i);
        }
        return code; */
	}

}