package com.DSniatecki.VehiclesAndFacilities.Facilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.DSniatecki.VehiclesAndFacilities.Vehicles.Car;
import com.DSniatecki.VehiclesAndFacilities.Vehicles.Motorcycle;
import com.DSniatecki.VehiclesAndFacilities.Vehicles.Vehicle;
import com.DSniatecki.tools.MyScan;
import com.DSniatecki.tools.MyView;


public final class VehicleWarehouse implements Serializable, VehicleWarehousable{

	private static final long serialVersionUID = 111L;

	private static int ID2;
	
	private String ID;
	private String adress;
	private String typeOfStorage;
	
	private ArrayList<Vehicle> myVehicle = new ArrayList<Vehicle>(2);
	
	public VehicleWarehouse() {
		this("no name");
	} 
	public VehicleWarehouse(String adress){
		ID2++;
		ID = "VS." + ID2;
		this.adress = adress;
	}

	
	public  void showInfo(int storageNumber) {
		System.out.println();
		System.out.println("==============================================================");
		System.out.println(" [ "+ ID + " ]               Warehouse : " + storageNumber);
		System.out.println("--------------------------------------------------------------");
		System.out.println(" - type             : "+ this.typeOfStorage );
	    System.out.println(" - adress           : " + this.adress);
		System.out.println(" - vehicles inside  : " + this.myVehicle.size() );
	    System.out.println("==============================================================");	
	}
	public  void setInfo(Scanner input) {
		System.out.println();
		System.out.println("==============================================================");
		System.out.println(" Give the data below regarding this warehouse : ");
		System.out.print(" - type of warehouse     : ");
		typeOfStorage = MyScan.scanString(input);
		System.out.print(" - address               : ");
		adress        = MyScan.scanString(input);
		System.out.println("==============================================================");
	}
	public  void execute(Scanner input,int storageNumber) {
		
		String userChoice;
		do {
			MyView.clearScreen(input);
			showGarageMenu(storageNumber);
			userChoice = input.nextLine();	
			MyView.clearScreen(input);
			
			switch(userChoice) {
				case "s" :			showAllVehicles(input);			break;
				case "c" :			addCar(input);					break;
				case "m" :			addMotorcycle(input);			break;
				case "r" :			removeVehicle(input);			break;
				case "e" :			editVehicle(input);				break;
				case "b" :											break;
				
				default  :
					System.out.println();
					System.out.println("[ Please select one of the warehouse menu options !!! ]");
					MyView.waitUntil(input);
					break;
			}
		}while(!userChoice.equals("b"));
	}
	public  void showAllVehicles(Scanner input) {
		if(myVehicle.size() != 0) {
			for(int i=0; i < myVehicle.size(); i++)
				myVehicle.get(i).showInfo(i+1);
		}
		else {
			System.out.println("");
			System.out.println("----------------------------------------------------");
			System.out.println("------ There is no vehicle in this warehouse  ------");
			System.out.println("----------------------------------------------------");
		}
		
		MyView.waitUntil(input);
	}
	public  void editInfo(Scanner input) {
		String userChoice;
		
		System.out.println();
		System.out.println("==============================================================");
		System.out.println("      Give the warehouse parameter you want to edit :");
		System.out.println("--------------------------------------------------------------");
		System.out.println("         - \"adress\"         -\"type of warehouse\" ");       
		System.out.println("--------------------------------------------------------------");
		System.out.print("Your choice : ");
		userChoice = MyScan.scanString(input);
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		editInfoInside(userChoice, input);
		}
	
	private void addCar(Scanner input){
		myVehicle.add(new Car());
		myVehicle.get(myVehicle.size()-1).setInfo(input);
		input.nextLine();
	}
	private void addMotorcycle(Scanner input) {
		
		myVehicle.add(new Motorcycle());
		myVehicle.get(myVehicle.size()-1).setInfo(input);
		input.nextLine();
	}	
	private void removeVehicle(Scanner input) {
		if( myVehicle.size() > 0) {	
			System.out.println();
			System.out.println("====================================================");
			int choice = MyScan.scanInt(input, "Give the vehicle number  you want to delete : ");
			System.out.println("====================================================");
		
			if(( choice > 0 ) && ( choice <= myVehicle.size() )) {
				myVehicle.remove(choice-1);
				System.out.println();
				System.out.println("[ Warehouse " + choice + ". was successfully removed ]");
			}
			else{
				System.out.println();
				System.out.println(" >> No vehicle with the given number was found << ");			
			}
			input.nextLine();
			MyView.waitUntil(input);	
		}
		else {
			System.out.println();
			System.out.println("---------------------------------------------------");
			System.out.println("-- You do not have any Vehicle in this warehouse --");
			System.out.println("---------------------------------------------------");
			MyView.waitUntil(input);
		}
	}
	private void showGarageMenu(int storageNumber) {
		System.out.println();
		System.out.println("[ Welcome in " + storageNumber + ". warehouse menu. Vehicles located here : " + myVehicle.size() +  " ]");
		System.out.println("");
		System.out.println("Press : " );
		System.out.println("");
		System.out.println(" \"s\" - to display all vehicles in this warehouse");
		System.out.println(" \"c\" - to add a new car to this warehouse ");
		System.out.println(" \"m\" - to add a new motorcycle to this warehouse");
		System.out.println(" \"r\" - to remove selected vehicle from this warehouse ");
		System.out.println(" \"e\" - to edit selected vehicle in this warehouse");
		System.out.println(" \"b\" - to go back");
		System.out.println();
		System.out.print(">> Your choice : ");
	}	
	private void editVehicle(Scanner input){
		if( myVehicle.size() > 0) {	
			System.out.println();
			System.out.println("====================================================");
			int choice = MyScan.scanInt(input, "Give the vehicle number you want to edit : ");
			System.out.println("====================================================");
		
			if(( choice > 0 ) && ( choice <= myVehicle.size() )) {
				MyView.clearScreen(input);
				input.nextLine();
				myVehicle.get(choice-1).editInfo(input);
			}
			else{
				input.nextLine();
				System.out.println();
				System.out.println(" >> No vehicle with the given number was found << ");			
			}
			MyView.waitUntil(input);	
		}
		else {
			System.out.println();
			System.out.println("---------------------------------------------------");
			System.out.println("-- You do not have any Vehicle in this warehouse --");
			System.out.println("---------------------------------------------------");
			MyView.waitUntil(input);
		}
	}
	private void editInfoInside(String userChoice, Scanner input) {
		switch(userChoice) {
		case "adress" : 
			System.out.print(" - address             : ");
			adress        = MyScan.scanString(input);
			break;
		case "type of warehouse" :
			System.out.print(" - type of warehouse   : ");
			typeOfStorage = MyScan.scanString(input);
			break;
		default:
			System.out.println("[ This warehouse is not described by this parametr ]");
		}		
	}	
	
	public  long getTotalPower() {
		long totalPower=0;
		for(Vehicle x : myVehicle) {
			totalPower += x.getPower();
		}
		return totalPower;
	}
	public  long getTotalMileage() {
		long totalMileage=0;
		for(Vehicle x : myVehicle) {
			totalMileage +=Math.round( x.getMileage());
		}
		return totalMileage;
	}
	public  long getTotalWeight() {
		long totalWeight=0;
		for(Vehicle x : myVehicle) {
			totalWeight += Math.round( x.getWeight() );
		}
		return totalWeight;
	}
	public   int getMyVehicleSize() {
		return myVehicle.size();
	}
	static {
		ID2=0;
	}
		
}


