package iotparking;

import java.util.ArrayList;
import java.util.HashMap;

public class Parking 
{
	private int totalSlots = 16;
	private int compactSlots = 8;
	private int regularSlots = 8;
	
	private HashMap<Integer, Vehicle> parkedCars;
	private ArrayList<Ticket> tickets;
	
	public Parking() 
	{
		this.parkedCars = new HashMap<Integer,Vehicle>();
		this.tickets = new ArrayList<Ticket>(16);
	}
	
	// parks a new car
	public void ParkNewCar(Vehicle vehicle) 
	{
		if(this.totalSlots == 0) 
		{
		    System.out.println("Parking is full!");
		    return;
		}
		else 
		{
            		if(vehicle.getCarType() == "compact" && this.compactSlots > 0) 
			{
			    this.RegisterVehicle(vehicle, 0, false);
			}
			else if(this.regularSlots > 0) 
			{
			    this.RegisterVehicle(vehicle, 8, true);
			}
		}
	}
	
	// Registers new vehicle into the parking
	private void RegisterVehicle(Vehicle vehicle, int counterStart, bool isRegular)
	{
	    	for(int i = counterStart; i < 16; i++) 
		{
			if(this.parkedCars.containsKey(i+1)) 
		    	{
				continue;
		    	}
		    	else 
		    	{
			    	vehicle.SetSlot(i+1);
                		this.CreateNewTicket(vehicle);
				this.parkedCars.put(i+1, vehicle);
				
				if(isRegular)
				{
				    System.out.println("Regular car is parking...");
				    --this.regularSlots;
				}
				else
				{
				    System.out.println("Compact car is parking...");
				    --this.compactSlots;
				}
				
				--this.totalSlots;
				i = 16;
			}	
		}
	}
	
	// Creates new ticket for the coming vehicle
	private void CreateNewTicket(Vehicle vehicle)
	{
	    	Ticket newTicket = new Ticket(vehicle);
		this.tickets.add(newTicket);
		this.PrintTicket(newTicket);
	}
	
	// Releases a slot by the given ticket
	public void ReleaseSlotByTicket(int slot) 
	{
		int flag = 0;
		
		if(tickets.isEmpty()) 
		{
			System.out.println("The parking is empty");
		}
		else 
		{
			for(int i=0; i < this.tickets.size(); i++) 
			{
				if(this.tickets.get(i).getSlot() != slot) 
				{
					continue;
				}
				else 
				{
					tickets.remove(i);
					flag = 1;
					i = 16;
					
					System.out.println("Car released");
				}
			}
			
			if(flag == 0) 
			{
				System.out.println("There is no car in this slot!\nMaybe you checked out before...");
			}
		}
	}
	
	// check if the parking is full
	public boolean IsFull() 
	{
	    return this.totalSlots < 0;
	}
	
	// Print ticket info
	public void PrintTicket(Ticket ticket) 
	{
		System.out.println("Car type: " + ticket.GetCarType());
		System.out.println("Car color: " + ticket.GetCarColor());
		System.out.println("Car Number: " + ticket.GetCarNumber());
		System.out.println("Checkin time: " + ticket.GetCheckInTime());
		System.out.println("Car slot: " + ticket.GetSlot());
		System.out.println("\n\n\n\n");
		
	}
	
	// Parking slots getter
	public int GetSlots() 
	{
		return this.totalSlots;
	}
	
	// Compact slots getter
	public int GetCompact() 
	{
		return this.compactSlots;
	}
	
	// Regular slots getter
	public int GetRegular() 
	{
		return this.regularSlots;
	}
}
