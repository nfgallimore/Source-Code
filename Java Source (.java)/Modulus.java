import java.util.Random;
import java.lang.Math;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Modulus {
	public static void main(String[] args) {
		int a = 13;
		int e = 27;
		int m = 55;
		int x = 1;
		// find out what x in 2^x is bigger than e
		while (Math.pow(2, x) < e) { 
			x++;
		}
		x--;
		LinkedList<Integer> xs = new LinkedList<Integer>();
		xs.add(x);
		while (x > 0) {
			if (Math.pow(2, x - 1) < e) {
				e -= Math.pow(2, x - 1);
				xs.add(x - 1);
			}
			x--;

		}
		int res = 0;
		LinkedList<Integer> pows = new LinkedList<Integer>();
		for (int i = 0; i < xs.get(0); i++) {
			a = (int)Math.pow(a, 2) % m;
			pows.add(a);
		}
		System.out.println(pows.toString());
		System.out.println(xs.toString());
	}
}