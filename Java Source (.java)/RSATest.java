import java.util.Random;
import java.lang.Math;
import java.util.*;
import java.lang.*;
import java.io.*;

public class RSATest {
	
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
	    long augendLong = nextLong(rand, range) + MIN;
	    long addendLong = nextLong(rand, range) + MIN;
	    long sumLong = augendLong - addendLong;

	    System.out.println(augendLong);
	    System.out.println(addendLong);
	    System.out.println("-------------------\n" + sumLong);

		String augendStr = Long.toString(augendLong);
		String addendStr = String.valueOf(addendLong);

		BigInt augendBigInt = new BigInt(augendStr);
		BigInt addendBigInt = new BigInt(addendStr);
		BigInt sumBigInt = new BigInt("");

		if (augendLong < addendLong) {
			long numDigitsBigger = (long)Math.nextUp(
				Math.log((double)addendLong) / Math.log((double)BASE) - 
				Math.log((double)augendLong) / Math.log((double)BASE)
			);
			for (long i = 0; i < numDigitsBigger; i++) {
				augendBigInt.ls.add(0, (long)0);
			}
		}
		else if (addendLong < augendLong) {
			long numDigitsBigger = (long)Math.nextUp(
				Math.log((double)augendLong) / Math.log((double)BASE) -
				Math.log((double)addendLong) / Math.log((double)BASE)
			);
			for (long i = 0; i < numDigitsBigger; i++) {
				addendBigInt.ls.add(0, (long)0);
			}
		}
		sumBigInt.ls = augendBigInt.subtract(addendBigInt).ls;

		// converts sum list into string
	    Iterator sumIter = sumBigInt.ls.iterator();
	    String str = "";
	    while(sumIter.hasNext()){
	        str += sumIter.next();
	    }

		if (!str.equals(Long.toString(augendLong - addendLong))) {
			err();
		}
		System.out.println(
			augendBigInt.ls.toString() + "\n" 
			+ addendBigInt.ls.toString() + "\n"
			+ "-----------------------------------");
			if (sumBigInt.positive) {
				System.out.print("(neg) ");
			}
			System.out.println(sumBigInt.ls.toString()
		);
	}

	public static void err() {
		System.out.println("Error! Values do not add correctly.");
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
	public static LinkedList listReverse(LinkedList list) {
		Iterator iter = list.iterator();
		LinkedList revList = new LinkedList<Long>();
		while (iter.hasNext()) {
			revList.add(0, iter.next());
		}
		testListReverse(list, revList);
		return revList;
	}
	public static void testListReverse(LinkedList list, LinkedList revList) {
		System.out.println(list.toString() + " in reverse is " + revList.toString());
	}
}