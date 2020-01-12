package iotparking;

public class Vehicle {
	private String carType;
	private String carColor;
	private int carNumber;
	private int slot;
	
	public Vehicle(String carType, int carNumber, String carColor)	{
		this.carType = carType;
		this.carColor = carColor;
		this.carNumber = carNumber;
	}
	
	// getter funs of car properties
	public String getCarType() {
		return carType;
	}
	public String getCarColor() {
		return carColor;
	}
	public int getCarNumber() {
		return carNumber;
	}

	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	

}
