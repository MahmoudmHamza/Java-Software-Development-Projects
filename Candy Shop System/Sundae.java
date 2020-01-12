package DessertStaff;

public class Sundae extends IceCream {
	
	private String toppingName;
	private int toppingCost;
	
	public Sundae(String name, int cost, String toppingName, int toppingCost) {
		
		super(name, cost);
		this.toppingName = toppingName;
		this.toppingCost = toppingCost;
	}
	
	public String gettoppingNmae() {
		
		return toppingName;
	}
	
	public int getCost() {
		
		return super.getCost() + toppingCost;
	}
}
