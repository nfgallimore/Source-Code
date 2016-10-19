import java.util.*;
public class TestStretch
{
	public static void main(String[] args)
	{
		int [] list = { 18, 7, 4, 14, 11 };
		int [] list2 = stretch(list);
		System.out.println( Arrays.toString(list) );
		System.out.println( Arrays.toString(list2) );
	}
	public static int [] stretch(int [] arr)
	{
		int [] arrayNew = new int [arr.length * 2];
		for (int i = 0; i < arrayNew.length; i+=2)
		{
			int value = arr [i/2];
			arrayNew [i+1] = arr [i/2] / 2;
			arrayNew [i] = arr [i/2] - arr [i/2] / 2;
		}
		return arrayNew;
	}
}