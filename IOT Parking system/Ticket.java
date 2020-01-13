package iotparking; 

import java.text.SimpleDateFormat;
import java.util.Date; 

public class Ticket {
	private SimpleDateFormat sdf;
	private Date date;
	private String chechInTime;
	private int slot;
	private Vehicle vehicle;
	
	public Ticket(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.date = new Date();
		this.chechInTime = this.sdf.format(this.date);
		this.slot = vehicle.getSlot();
	}
	
	public String getCarType() {
		return vehicle.getCarType();
	}
	
	public String getCarColor() {
		return vehicle.getCarColor();
	}
	
	public int getCarNumber() {
		return vehicle.getCarNumber();
	}

	public int getSlot() {
		return slot;
	}
	public String getChechInTime() {
		return chechInTime;
	}
	
}
