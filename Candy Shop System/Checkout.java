package DessertStaff;

import java.util.ArrayList;

public class Checkout {	
	
	private ArrayList<DessertItem> dessertList; 
	
	public Checkout() {
		
		dessertList = new ArrayList<DessertItem>();
	}
	
	public void clear() {
		
		dessertList.clear();
	}
	
	public void enterItem(DessertItem dessertItem) {
		
		dessertList.add(dessertItem);
	}
	
	public int numberOfItems() {
		
		return dessertList.size();
	}
	
	public int totalCost() {
		
		int i = 0;
		int totalCost = 0;
		
		for(i = 0; i < dessertList.size(); i++) {
			
			totalCost += dessertList.get(i).getCost();
		}
		
		return totalCost;
	}
	
	public int totalTax() {
		
		return (int)(Math.round(totalCost() * (DessertShoppe.TAX_RATE / 100)));
	}
	
	public String toString(){
		
		String s = String.format("\n     %s\n     --------------------\n\n", DessertShoppe.STORE_NAME);
		String temp = "";
		int i = 0;
		
		for(i = 0; i < dessertList.size(); i++)
		{
			if(dessertList.get(i) instanceof Sundae)
			{
				temp = String.format("%s sundae with\n%-30s%s\n", ((Sundae)dessertList.get(i)).gettoppingNmae(), 
						dessertList.get(i).getName(), DessertShoppe.cents2dollarsAndCents(dessertList.get(i).getCost()));
			}
			else if(dessertList.get(i) instanceof Cookie)
			{
				temp = String.format("%d @ %s /dz.\n%-30s%s\n", ((Cookie)dessertList.get(i)).getNumber(), 
						DessertShoppe.cents2dollarsAndCents(((Cookie)dessertList.get(i)).getPpd()), dessertList.get(i).getName(),
						DessertShoppe.cents2dollarsAndCents(dessertList.get(i).getCost()));
			}
			else if(dessertList.get(i) instanceof Candy)
			{
				temp = String.format("%.2f lbs. @ %s /lb.\n%-30s%s\n", ((Candy)dessertList.get(i)).getWeight(), 
						DessertShoppe.cents2dollarsAndCents(((Candy)dessertList.get(i)).getPpp()), dessertList.get(i).getName(),
						DessertShoppe.cents2dollarsAndCents(dessertList.get(i).getCost()));
			}
			else {
				
				temp = String.format("%-30s%s\n", dessertList.get(i).getName(),
						DessertShoppe.cents2dollarsAndCents(dessertList.get(i).getCost()));
			}
			
			s += temp;
		}
		
		s += "\n\n" + "Tax" + String.format("%31s", DessertShoppe.cents2dollarsAndCents(totalTax()));
		s += "\nTotal Cost" + String.format("%24s", DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()));
		
		return s;
	}
}
