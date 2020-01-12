import java.util.ArrayList;

public class arrList {
	
	private ArrayList<Integer> myArrList = new ArrayList<Integer>();
	
	public arrList()
	{
		
	}
	
	public void addItem(int element)
	{
		myArrList.add(element);
	}
	
	public int getItem(int index)
	{
		return myArrList.get(index);
	}

}