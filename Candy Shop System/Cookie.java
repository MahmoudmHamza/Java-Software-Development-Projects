package DessertStaff;

public class Cookie extends DessertItem {
	
	private int number;
	private int ppd;
	
	public Cookie(String name, int number, int ppd) {
		
		super(name);
		this.number = number;
		this.ppd = ppd;
	}
	
	public int getNumber() {
		
		return number;
	}
	
	public int getPpd() {
		
		return ppd;
	}
	
	public int getCost() {
		
		double price = ppd * ((double)number / 12);
		
		return (int)Math.round(price);
	}

}
