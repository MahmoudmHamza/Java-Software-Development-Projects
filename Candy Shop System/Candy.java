package DessertStaff;

public class Candy extends DessertItem {
	
	private double weight;
	private double ppp;
	
	public Candy(String name, double weight,double ppp) {
		
		super(name);
		this.weight = weight;
		this.ppp = ppp;
	}
	
	public double getWeight() {
		
		return weight;
	}
	
	public int getPpp() {
		
		return (int)Math.round(ppp);
	}
	
	public int getCost() {
		
		double price = weight * ppp ;
		
		return (int)Math.round(price);
	}

}
