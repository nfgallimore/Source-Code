// uses an array 
class Exercise6
{
	private int[] internalArray;

	public IntegerList()
	{
		this(DEFAULT_SIZE);
	}			

	public IntegerList(int size)
	{
		this.internalArray = new int[size];       
	}

	public IntegerList(IntegerList a, IntegerList b)
	{
		this.internalArray = new int[a.getSize() + b.getSize()];
	}
	int i;
	for (i = 0; i < a.getSize(); i++)
	{
		this.internalArray[i] = a.getHead();
		a = a.getTail();
	}

	for ( ; i < b.getSize(); i++)
	{
		this.internalArray[i] = b.getHead();
			b = b.getTail();
			
	}
	public boolean isEmpty()
	{

	}

	public int getSize()
	{

	}

	public void addToBack(int x)
	{

	}
	public int getHead()
	{

	}
}