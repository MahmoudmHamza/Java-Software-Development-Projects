package iotparking;

import java.util.ArrayList;
import java.util.Scanner;

public class mainProgram {

	public static void main(String[] args) {
		
		Parcking newParking = new Parcking();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle newCar;
		int choice, vehicleCounter = 0, carNumber, carSlot;
		String carColor,carType;
		
		System.out.println("WELLCOM TO IOT PARKING");
		while(true) {
			print();
			choice = input.nextInt();
			System.out.println("\n");
			if(choice > 2 || choice < 1) {
				System.out.println("Invalid choice");
			}
			else {
				if(choice == 1) {
					System.out.print("Please enter the type of your car(compact or regular): ");
					carType = input.next();
					System.out.print("\n");
					System.out.print("Please enter the color of your car: ");
					carColor = input.next();
					System.out.print("\n");
					System.out.print("Please enter the number of your car: ");
					carNumber = input.nextInt();
					System.out.print("\n\n\n");
					newCar = new Vehicle(carType,carNumber,carColor);
					vehicles.add(newCar);
					newParking.newCar(vehicles.get(vehicleCounter++));
				}
				else {
					System.out.print("Please enter the slot of your car: ");
					carSlot = input.nextInt();
					System.out.print("\n\n\n");
					newParking.releaseSlotByTicket(carSlot);
				}
				
			}
			
			
		}
		
	}
	
	public static void print() {
		System.out.println("1- Park your car");
		System.out.println("2- Release your car");
		System.out.print("Enter the number of your choice: ");
	}

}
