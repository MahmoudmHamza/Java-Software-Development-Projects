package DessertStaff;

// This class handles Cookie's properties
public class Cookie extends DessertItem 
{
	private int number;
	private int percentage;
	
	public Cookie(String name, int number, int percentage) 
	{
		super(name);
		this.number = number;
		this.percentage = percentage;
	}
	
	public int GetNumber() 
	{
		return this.number;
	}
	
	public int GetPercentage() 
	{
		return this.percentage;
	}
	
	public int GetCost() 
	{
		double price = this.percentage * ((double)this.number / 12);
		return (int)Math.round(price);
	}
}