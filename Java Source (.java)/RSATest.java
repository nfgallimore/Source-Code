import java.util.Random;
import java.lang.Math;
import java.util.*;
import java.lang.*;
import java.io.*;

// Test is not working properly. -33 - 31 is returning -98.?!? 
public class RSATest {

	// max + max = maxLong = 2^63 - 1
	public final static long MAX = (long)Math.pow(2, 31) - 1;
	public final static long MIN = 0;
	public final static long BASE = 10;

	public final static Long range = (MAX - MIN) + 1;

	public static void main(String[] args) throws IOException {

		// If true do not print calculations
		Boolean quiet = true;

		Random rand = new Random();

		rand.nextLong();
		// Random Test
		System.out.println("\nBeginning tests with random longs.\n\n");
		for (int i = 0; i < 1000 && !error; i++) {
			addTest(quiet, randLong(), randLong());
			subTest(quiet, randLong(), randLong());
		}
		System.out.println("Random long test was a success.\n\n");

		// Fixed Test
		System.out.println("Beginning tests with fixed 4 and 3 bit longs covering all cases with the variables: length (9 or 10 digits), sign (positive or negative), values (9, 1, or 0), and top/bottom (augend/addend and minuend or subtrahend).\n\n");
		int[] intArr = {-33, 31, 9999,9999,1111,1111,-9999,-9999,-1111,-1111,-9999,9999,-1111,1111,9999,-9999,1111,-1111,9999,1111,-9999,-1111,9999,-1111,-9999,1111,1111,9999,-1111,-9999,-1111,9999,1111,-9999,9999,0000,-9999,0000,0000,9999,0000,-9999,0000,0000,-0000,-0000,-0000,0000,0000,-0000,999,9999,111,1111,-999,-9999,-111,-1111,-999,9999,-111,1111,999,-9999,111,-1111,999,1111,-999,-1111,999,-1111,-999,1111,111,9999,-111,-9999,-111,9999,111,-9999,999,0000,-999,0000,000,9999,000,-9999,000,0000,-000,-0000,-000,0000,000,-0000,9999,999,1111,111,-9999,-999,-1111,-111,-9999,999,-1111,111,9999,-999,1111,-111,9999,111,-9999,-111,9999,-111,-9999,111,1111,999,-1111,-999,-1111,999,1111,-999,9999,000,-9999,000,0000,999,0000,-999,0000,000,-0000,-000,-0000,000,0000,-000};
		System.out.println(intArr[intArr.length - 3]);
		LinkedList<Integer> intList = new LinkedList<Integer>();
		for (int i = 0; i < intArr.length - 1; i++) {
			intList.add(intArr[i]);
		}
		if (intList.size() % 2 == 0) {
			while (intList.iterator().hasNext()) {
				int i = intList.iterator().next();
				int j = intList.iterator().next();
				addTest(quiet, (long)i, (long)j);
				subTest(quiet, (long)i, (long)j);
			}
		}

		System.out.println("Fixed long test was a success.\nTurning off quiet mode to print a random calculation for each operation to screen.\n\n");
		quiet = false;
		addTest(quiet, randLong(), randLong());
		subTest(quiet, randLong(), randLong());

		BigInt randoBigInt1 = randBigInt(2);
		BigInt randoBigInt2 = randBigInt(2);

		System.out.println(randoBigInt1.getStr() + " + " + randoBigInt2.getStr() + " = " + randoBigInt1.add(randoBigInt2).getStr());

		BigInt test1 = new BigInt("33");
		test1.positive = false;
		BigInt test2 = new BigInt("31");
		test2.positive = true;

		System.out.println(test1.getStr() + " - " + test2.getStr() + " = " + test1.subtract(test2).getStr());

		System.out.println("\nTest completed successfully! Exiting now!\n\n");

	}
	public static Long randLong() {
		return (nextLong(new Random(), range) + MIN);
	}
	public static BigInt randBigInt(int size) throws IOException {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += nextLong(new Random(), 9);
		}
		BigInt b = new BigInt(str);
		if (randBit() == 1) {
			b.positive = false;
		}
		else {
			b.positive = true;
		}
		return b;
	}
	public static void addTest(Boolean quiet, Long augendLong, Long addendLong) throws IOException {

	    long sumLong = augendLong + addendLong;
	    if (!quiet) {
		    System.out.println("ADDITION TEST\n\n" + augendLong);
		    System.out.println(addendLong);
		    System.out.println("-------------------\n" + sumLong + "\n");
		}
		String augendStr = Long.toString(augendLong);
		String addendStr = String.valueOf(addendLong);

		BigInt augendBigInt = new BigInt(augendStr);
		BigInt addendBigInt = new BigInt(addendStr);
		BigInt sumBigInt = new BigInt("");

		sumBigInt = augendBigInt.add(addendBigInt);

		if (!Objects.equals(Long.toString(augendLong + addendLong), sumBigInt.getStr())) {
			System.out.println("Program calculated: " + augendLong + " - " + addendLong + " = " + sumBigInt.getStr() + "\n When it should be " + (augendLong + addendLong));
			err();
		}
		if (!quiet) {
			System.out.println(augendBigInt.ls.toString() + "\n" + addendBigInt.ls.toString() + "\n" + "-----------------------------------");
				System.out.println(sumBigInt.getStr() + "\n");
		}
	}
	public static void subTest(Boolean quiet, Long minuendLong, Long subtrahendLong) throws IOException {

	    long diffLong = minuendLong - subtrahendLong;
	    if (!quiet) {
		    System.out.println("\nSUBTRACTION TEST\n\n" + minuendLong);
		    System.out.println(subtrahendLong);
		    System.out.println("-------------------\n" + diffLong + "\n");
		}
		String minuendStr = Long.toString(minuendLong);
		String subtrahendStr = String.valueOf(subtrahendLong);

		BigInt minuendBigInt = new BigInt(minuendStr);
		BigInt subtrahendBigInt = new BigInt(subtrahendStr);
		BigInt diffBigInt = new BigInt("");

		diffBigInt = minuendBigInt.subtract(subtrahendBigInt);

		if (!Objects.equals(Long.toString(minuendLong - subtrahendLong), diffBigInt.getStr())) {
			System.out.println("Program calculated: " + minuendLong + " - " + subtrahendLong + " = " + diffBigInt.getStr() + "\nWhen it should have computed " + (minuendLong - subtrahendLong));
			err();
		}
		if (!quiet) {
			System.out.println(minuendBigInt.ls.toString() + "\n" + subtrahendBigInt.ls.toString() + "\n" + "-----------------------------------");
			System.out.println(diffBigInt.getStr() + "\n");
		}
	}
	public static int randBit() {
		return (int)nextLong(new Random(), 2);
	}
	public static Boolean error = false;
	public static void err() {
		System.out.println("Error! Values are not correct.\n");
		error = true;
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