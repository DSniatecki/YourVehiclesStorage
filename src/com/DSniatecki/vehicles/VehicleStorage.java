package com.DSniatecki.vehicles;

import java.util.ArrayList;
import java.util.Scanner;
import com.DSniatecki.tools.MyView;

public class VehicleStorage {

	private static int ID2;
	
	
	private String ID;
	private String adress;
	private String typeOfStorage;
	
	private ArrayList<Vehicle> myVehicle = new ArrayList<Vehicle>(2);
	
	public VehicleStorage() {
		this("no name");
	} 

	public VehicleStorage(String adress){
		ID2++;
		ID = "VS." + ID2;
		this.adress = adress;
	}
	
	
	
	public void showInfo() {
		System.out.println("------------------------------------------------");
		System.out.println(" [ "+ ID + " ] " + this.typeOfStorage + " : " + this.adress);
		System.out.println("------------------------------------------------");		
	}
	
	public void setInfo(Scanner input) {
		System.out.println();
		System.out.println("================================================");
		System.out.println(" Podaj ponizsze dane dotyczace tego magazynu : ");
		System.out.print(" - typ magazynu               : ");
		typeOfStorage = input.nextLine();
		System.out.print(" - adress magazynu            : ");
		adress = input.nextLine();
		System.out.println("================================================");
	}
	
	
	
	private void addCar(Scanner input){
		myVehicle.add(new Car());
		myVehicle.get(myVehicle.size()-1).setInfo(input);
	}
	
	private void addMotorcycle(Scanner input) {
		
		myVehicle.add(new Motorcycle());
		myVehicle.get(myVehicle.size()-1).setInfo(input);
	}
	
	
	public void showMenu() {
		System.out.println("[ Welcome in Garage menu. Press :   ]");
		System.out.println();
		System.out.println(" \"s\" - to display all vehicles in this garage ");
		System.out.println(" \"c\" - to add a new car to this garage ");
		System.out.println(" \"m\" - to add a new motorcycle to this garage");
		System.out.println(" \"r\" - to return");
		System.out.println();
		System.out.print(">> Your choice : ");
	}
	
	public void execute(Scanner input) {
		String userChoice;
		do {
			MyView.clearScreen();
			
			this.showMenu();
			userChoice = input.nextLine();
			
			MyView.clearScreen();
			
			switch(userChoice) {
				case "s" :
					this.showAllVehicles();
					MyView.waitUntil(input);
					break;
				case "c" :
					this.addCar(input);
					break;
				case "m" :
					this.addMotorcycle(input);
					break;
				case "r" :
					break;
				default  :
					System.out.println();
					System.out.println("[ Prosze wybrac jedna z pozycji z menu magazynu !!! ]");
					MyView.waitUntil(input);
					break;
			
			
			}
		
		
		}while(!userChoice.equals("r"));
	}
	
	
	public void showAllVehicles() {
		System.out.println();
		if(myVehicle.size() != 0) {
			for(Vehicle x : this.myVehicle) {
				x.showInfo();
			}	
		}
		else {
			System.out.println("------------------------------------------------");
			System.out.println("-----  There is no vehicle in this garage  -----");
			System.out.println("------------------------------------------------");
		}
	
	}
	
	static {
		ID2=0;
	}
		
}


