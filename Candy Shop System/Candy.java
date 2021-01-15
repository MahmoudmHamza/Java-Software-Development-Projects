package DessertStaff;

// This class holds Candy's properties
public class Candy extends DessertItem 
{
	private double weight;
	private double percentage;
	
	public Candy(String name, double weight, double percentage) 
	{
		super(name);
		this.weight = weight;
		this.percentage = percentage;
	}
	
	public double GetWeight() 
	{
		return this.weight;
	}
	
	public int GetPercentage() 
	{
		return (int)Math.round(this.percentage);
	}
	
	public int GetCost()
	{
		double price = this.weight * this.percentage;
		return (int)Math.round(price);
	}
}