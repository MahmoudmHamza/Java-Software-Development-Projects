package iotparking;

import java.util.ArrayList;
import java.util.HashMap;

public class Parcking {
	private int slots = 16;
	private int compact = 8;
	private int regular = 8;
	private HashMap<Integer,Vehicle> parckedCars;
	private ArrayList<Ticket> tickets;
	
	public Parcking() {
		parckedCars = new HashMap<Integer,Vehicle>(); // take car slot and type
		tickets = new ArrayList<Ticket>(16); // take every new ticket
	}
	// park a new car
	public void newCar(Vehicle vehicle) {
		if(slots != 0) {
			if(vehicle.getCarType() == "compact" && compact > 0) {
				for(int i=0;i<16;i++) {
					if(parckedCars.containsKey(i+1) == false) {
						vehicle.setSlot(i+1);
						Ticket newTicket = new Ticket(vehicle); // create a new ticket
						printTicket(newTicket);
						tickets.add(newTicket);
						parckedCars.put(i+1, vehicle);
						--compact;
						--slots;
						i=16;
					}
					else {
						continue;
					}
				}
			}
			else if(regular > 0) {
				for(int i=8;i<16;i++) {
					if(parckedCars.containsKey(i+1) == false) {
						System.out.println("regular car");
						vehicle.setSlot(i+1);
						Ticket newTicket = new Ticket(vehicle); // create a new ticket
						printTicket(newTicket);
						tickets.add(newTicket);
						parckedCars.put(i+1, vehicle);
						--regular;
						--slots;
						i=16;
					}
					else {
						continue;
					}
				}
			}
			
		}
		else {
			System.out.println("The parking is full!");
		}
	}
	
	public void releaseSlotByTicket(int slot) {
		int flag = 0; // to know if there is a car in this slot or not
		if(tickets.isEmpty()) {
			System.out.println("The parking is empty");
		}
		else {
			for(int i=0;i<tickets.size();i++) {
				if(tickets.get(i).getSlot() == slot) {
					tickets.remove(i);
					flag = 1;
					i = 16; // to end checking
					System.out.println("Car released");
				}
				else {
					continue;
				}
			}
			if(flag == 0) {
				System.out.println("There is no car in this slot\nMaybe you checked out befor");
			}
		}
	}
	
	// check if the parking is full
	public boolean isFull() {
		if(slots>0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void printTicket(Ticket ticket) {
		System.out.println("Car type: " + ticket.getCarType());
		System.out.println("Car color: " + ticket.getCarColor());
		System.out.println("Car Number: " + ticket.getCarNumber());
		System.out.println("Checkin time: " + ticket.getChechInTime());
		System.out.println("Car slot: " + ticket.getSlot());
		System.out.println("\n\n\n\n");
		
	}
	
	public int getSlots() {
		return slots;
	}
	public int getCompact() {
		return compact;
	}
	public int getRegular() {
		return regular;
	}
}
