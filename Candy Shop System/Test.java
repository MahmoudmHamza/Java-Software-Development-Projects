package DessertStaff;

public class Test 
{
	public static void main(String[] args) 
	{
		Checkout checkout = new Checkout();
	    
	    checkout.EnterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
	    checkout.EnterItem(new IceCream("Vanilla Ice Cream",105));
	    checkout.EnterItem(new Sundae("Choc. Chip Ice Cream",145, "Hot Fudge", 50));
	    checkout.EnterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
	    
	    System.out.println("\nNumber of items: " + checkout.NumberOfItems() + "\n");
	    System.out.println("\nTotal cost: " + checkout.TotalCost() + "\n");
	    System.out.println("\nTotal tax: " + checkout.TotalTax() + "\n");
	    System.out.println("\nCost + Tax: " + (checkout.TotalCost() + checkout.TotalTax()) + "\n");
	    System.out.println(checkout);
	    
	    checkout.Clear();
	    
	    checkout.EnterItem(new IceCream("Strawberry Ice Cream",145));
	    checkout.EnterItem(new Sundae("Vanilla Ice Cream",105, "Caramel", 50));
	    checkout.EnterItem(new Candy("Gummy Worms", 1.33, 89));
	    checkout.EnterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
	    checkout.EnterItem(new Candy("Salt Water Taffy", 1.5, 209));
	    checkout.EnterItem(new Candy("Candy Corn",3.0, 109));
	    
	    System.out.println("\nNumber of items: " + checkout.NumberOfItems() + "\n");
	    System.out.println("\nTotal cost: " + checkout.TotalCost() + "\n");
	    System.out.println("\nTotal tax: " + checkout.TotalTax() + "\n");
	    System.out.println("\nCost + Tax: " + (checkout.TotalCost() + checkout.TotalTax()) + "\n");
	    System.out.println(checkout);
	}
}