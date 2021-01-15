package DessertStaff;

// base class for dessert items
public abstract class DessertItem 
{
	protected String name;
	
	public DessertItem() 
	{
		this("");
	}

	public DessertItem(String name) 
	{
	    this.name = name.length() <= DessertShoppe.MAX_ITEM_NAME_SIZE?
	    name : name.substring(0, DessertShoppe.MAX_ITEM_NAME_SIZE);
	}
	
	public final String GetName() 
	{
		return this.name;
	}
	
	public abstract int GetCost();
}