package iotparking;

// This class contains vehicle's properties and functionalities
public class Vehicle 
{
    // Car's type
	private String carType;
	
	// Car's color
	private String carColor;
	
	// Car's number
	private int carNumber;
	
	// Car's parking slot
	private int slot;
	
	public Vehicle(String carType, int carNumber, String carColor)
	{
		this.carType = carType;
		this.carColor = carColor;
		this.carNumber = carNumber;
	}
	
	// Getter and setter functions of car properties
	public String GetCarType() 
	{
		return this.carType;
	}
	
	public String GetCarColor() 
	{
		return this.carColor;
	}
	
	public int GetCarNumber() 
	{
		return this.carNumber;
	}

	public int GetSlot() 
	{
		return this.slot;
	}
	
	public void SetSlot(int slot) 
	{
		this.slot = slot;
	}
}