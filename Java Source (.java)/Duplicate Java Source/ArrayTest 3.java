public class ArrayTest {

	public static void main (String[] args)
	{
		final int SIZE = 8;
		int [] sample = new int [SIZE];

		for (int i = 0; i < SIZE; i++)
			System.out.println(sample[i] = i);



		System.out.println();
		for (int i = 0; i < SIZE; i++)
			if (i % 2 != 0)
				System.out.println(sample[i]);
	}
}