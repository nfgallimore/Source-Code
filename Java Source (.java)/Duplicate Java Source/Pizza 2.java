class Pizza
{
	private int slices;
	private String name;
	private double price;
	private double radius;

	public Pizza (String n, double r , double p, int s)
	{		
		slices = s;
		name = n;
		price = p;
		radius = r;
	}

	// private methods
	private double area()
	{
		return radius * radius * Math.PI;
	}
	
	// public methods 
	public double areaPerSlice()
	{
		return area() / slices;
	}
	public String getName()
	{
		return name;
	}
	public double costPerSlice()
	{
		return  price / slices ;
	}
	public double costPerSquareInch()
	{
		return price / area();
	}
}