package iotparking;

import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram
{
    int choice = 0;
    int vehicleCounter = 0; 
    int carNumber; 
    int carSlot;
	String carColor;
	String carType;
		
	public static void main(String[] args) 
	{
		Parking newParking = new Parking();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle newCar;
		
		System.out.println("WELCOME TO THE PARKING SYSTEM...");
		while(true) 
		{
			this.DisplayChoices();
			
			this.choice = input.nextInt();
			System.out.println("\n");
			
			if(this.choice > 2 || this.choice < 1) 
			{
				System.out.println("Invalid choice");
			}
			else 
			{
				if(this.choice == 1) 
				{
                    this.HandleUserInput(input);
					
					newCar = new Vehicle(this.carType, this.carNumber, this.carColor);
					vehicles.add(newCar);
					newParking.ParkNewCar(vehicles.get(vehicleCounter++));
				}
				else 
				{
					System.out.print("Please enter the slot of your car: ");
					carSlot = input.nextInt();
					System.out.print("\n\n\n");
					
					newParking.ReleaseSlotByTicket(carSlot);
				}
			}
		}
	}
	
	// Display choices for the user to choose from when the program starts
	public static void DisplayChoices() 
	{
		System.out.println("1- Park your car");
		System.out.println("2- Release your car");
		System.out.print("Enter the number of your choice: ");
	}
	
	// Handles user input for parking registeration
	private void HandleUserInput(Scanner input)
	{
	    System.out.print("Please enter the type of your car(compact or regular): ");
		this.carType = input.next();
		System.out.print("\n");
					
		System.out.print("Please enter the color of your car: ");
		this.carColor = input.next();
		System.out.print("\n");
					
		System.out.print("Please enter the number of your car: ");
		this.carNumber = input.nextInt();
		System.out.print("\n\n\n");
	}
}