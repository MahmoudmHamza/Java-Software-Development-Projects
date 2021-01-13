package iotparking; 

import java.text.SimpleDateFormat;
import java.util.Date; 

// This class contains ticket's properties and functionalities
public class Ticket 
{
    // Ticket's date format
	private SimpleDateFormat dateFormat;
	
	// Current ticket's date
	private Date date;
	
	// Ticket's check in time
	private String checkInTime;
	
	// Ticket's slot
	private int slot;
	
	// Registered ticket's vehicle
	private Vehicle vehicle;
	
	public Ticket(Vehicle vehicle) 
	{
		this.vehicle = vehicle;
		this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.date = new Date();
		this.checkInTime = this.dateFormat.format(this.date);
		this.slot = vehicle.GetSlot();
	}
	
	// Getter functions of ticket properties
	public String GetCarType() 
	{
		return vehicle.GetCarType();
	}
	
	public String GetCarColor() 
	{
		return vehicle.GetCarColor();
	}
	
	public int GetCarNumber() 
	{
		return vehicle.GetCarNumber();
	}

	public int GetSlot() 
	{
		return this.slot;
	}
	
	public String GetCheckInTime() 
	{
		return this.checkInTime;
	}
}