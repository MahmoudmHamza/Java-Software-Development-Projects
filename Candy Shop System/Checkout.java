package DessertStaff;

import java.util.ArrayList;

public class Checkout 
{	
	private ArrayList<DessertItem> dessertList; 
	
	public Checkout() 
	{
		this.dessertList = new ArrayList<DessertItem>();
	}
	
	public void Clear() 
	{
		this.dessertList.clear();
	}
	
	public void EnterItem(DessertItem dessertItem) 
	{
		this.dessertList.add(dessertItem);
	}
	
	public int NumberOfItems() 
	{
		return this.dessertList.size();
	}
	
	public int TotalCost() 
	{
		int i = 0;
		int totalCost = 0;
		
		for(i = 0; i < this.dessertList.size(); i++) 
		{
			totalCost += this.dessertList.get(i).GetCost();
		}
		
		return totalCost;
	}
	
	public int TotalTax() 
	{
		return (int)(Math.round(this.TotalCost() * (DessertShoppe.TAX_RATE / 100)));
	}
	
	public String ToString(){
		
		String s = String.format("\n     %s\n     --------------------\n\n", DessertShoppe.STORE_NAME);
		String temp = "";
		int i = 0;
		
		for(i = 0; i < this.dessertList.size(); i++)
		{
			if(this.dessertList.get(i) instanceof Sundae)
			{
				temp = String.format("%s sundae with\n%-30s%s\n", ((Sundae)this.dessertList.get(i)).GetToppingName(), 
						this.dessertList.get(i).GetName(), DessertShoppe.cents2dollarsAndCents(dessertList.get(i).GetCost()));
			}
			else if(this.dessertList.get(i) instanceof Cookie)
			{
				temp = String.format("%d @ %s /dz.\n%-30s%s\n", ((Cookie)this.dessertList.get(i)).GetNumber(), 
						DessertShoppe.cents2dollarsAndCents(((Cookie)this.dessertList.get(i)).GetPercentage()), 
						this.dessertList.get(i).GetName(),
						DessertShoppe.cents2dollarsAndCents(this.dessertList.get(i).GetCost()));
			}
			else if(this.dessertList.get(i) instanceof Candy)
			{
				temp = String.format("%.2f lbs. @ %s /lb.\n%-30s%s\n", ((Candy)this.dessertList.get(i)).GetWeight(), 
						DessertShoppe.cents2dollarsAndCents(((Candy)this.dessertList.get(i)).GetPercentage()), 
						this.dessertList.get(i).GetName(),
						DessertShoppe.cents2dollarsAndCents(dessertList.get(i).GetCost()));
			}
			else 
			{
				temp = String.format("%-30s%s\n", this.dessertList.get(i).GetName(),
						DessertShoppe.cents2dollarsAndCents(this.dessertList.get(i).GetCost()));
			}
			
			s += temp;
		}
		
		s += "\n\n" + "Tax" + String.format("%31s", DessertShoppe.cents2dollarsAndCents(this.TotalTax()));
		s += "\nTotal Cost" + String.format("%24s", DessertShoppe.cents2dollarsAndCents(this.TotalCost() + this.TotalTax()));
		
		return s;
	}
}