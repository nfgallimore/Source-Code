class ThisOldMan
{
	public static void main(String[] args)
	{
		String[] item = new String[11];
		item[1] = "on my drum";
		item[2] = "on my shoe";
		item[3] = "on my tree";
		item[4] = "on my door";
		item[5] = "on my hive";
		item[6] = "on my sticks";
		item[7] = "up in heaven";
		item[8] = "on my gate";
		item[9] = "on my spine";
		item[10] = "on my hen";
        
		for (int verse = 1; verse <= 10; ++verse)
		{
			song(verse, item[verse]);
			System.out.println("With a nick-nack paddy-whack, give the dog a bone,");
			System.out.println("This old man came running home.\n");
		}
	}
	public static void song(int verse, String item)
	{
		System.out.println("This old man, he played " + verse + ".");
		System.out.println("He played nick-nack " + item + ";");
	}
}