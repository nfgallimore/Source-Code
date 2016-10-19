import java.util.Random;
import java.lang.Math;
import java.util.*;
import java.lang.*;
import java.io.*;

public class RSA {
	
	public static void main(String[] args) throws IOException {
		addTest();
	}

	public static void addTest() throws IOException {

		Random rand = new Random();

		rand.nextLong();
		
		// max + max = maxLong = 2^63 - 1
		final long MAX = (long)Math.pow(2, 31) - 1;
		final long MIN = 0;
		final long BASE = 10;

		long range = (MAX - MIN) + 1;

		String augendStr = "";
		String addendStr = "";

		for (int i = 0; i < 10000; i++) {
			augendStr += Long.toString(nextLong(rand, range) + MIN);
			addendStr += Long.toString(nextLong(rand, range) + MIN);
		}

		BigInt augendBigInt = new BigInt(augendStr);
		BigInt addendBigInt = new BigInt(addendStr);
		BigInt sumBigInt = new BigInt("");

		sumBigInt.ls = augendBigInt.add(addendBigInt).ls;

		System.out.println(
			augendBigInt.getStr() + "\n" 
			+ addendBigInt.getStr() + "\n"
			+ "-----------------------------------\n" 
			+ sumBigInt.getStr()
		);
	}

	public static long nextLong(Random rng, long n) {
	    long bits, val;
	    do {
	    	bits = (rng.nextLong() << 1) >>> 1;
	    	val = bits % n;
	    }
	    while (bits - val + (n - 1) < 0L);
	   	return val;
	}

}