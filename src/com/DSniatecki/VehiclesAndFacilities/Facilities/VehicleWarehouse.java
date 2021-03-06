package com.DSniatecki.VehiclesAndFacilities.Facilities;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
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
		System.out.println(" - type                : " + this.typeOfStorage );
	    System.out.println(" - adress              : " + this.adress);
		System.out.println(" - cars inside         : " + this.calculateCarsNumber() );
		System.out.println(" - motorcycles inside  : " + this.calculateMotorcyclesNumber() );
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
				case "s" :			showAllVehicles(input);						break;
				case "sm" :			showAllMotorcycles(input);					break;
				case "sc" :			showAllCars(input);							break;
				case "f" :          sendTheVehicleToTheFile(input); 	   		break; 
				case "c" :			addCar(input);								break;
				case "m" :			addMotorcycle(input);						break;
				case "r" :			removeVehicle(input);						break;
				case "e" :			editVehicle(input);							break;
				case "SV":          sortVehicles(input);                        break;
				case "b" :														break;
				
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
	
	public  void showAllCars(Scanner input) {
		
		boolean isThereAnyCar = false;
		
		if(myVehicle.size() != 0) {
			for(int i=0; i < myVehicle.size(); i++)
				if( myVehicle.get(i) instanceof Car) {
					myVehicle.get(i).showInfo(i+1);
					isThereAnyCar = true;
				}
		}
		if(myVehicle.size() == 0 || !isThereAnyCar){
			System.out.println("");
			System.out.println("----------------------------------------------------");
			System.out.println("-------- There is no car in this warehouse  --------");
			System.out.println("----------------------------------------------------");
		}
		
		MyView.waitUntil(input);
	}
	
	public  void showAllMotorcycles(Scanner input) {
		
		boolean isThereAnyMotorcycle = false;
		
		if(myVehicle.size() != 0) {
			for(int i=0; i < myVehicle.size(); i++)
				if( myVehicle.get(i) instanceof Motorcycle)	{
						myVehicle.get(i).showInfo(i+1);
						isThereAnyMotorcycle = true;
				}
		}
		if(myVehicle.size() == 0 || !isThereAnyMotorcycle){
			System.out.println("");
			System.out.println("----------------------------------------------------");
			System.out.println("----- There is no motorcycle in this warehouse -----");
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
				System.out.println("[ vehicle " + choice + ". was successfully removed ]");
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
		System.out.println(" \"s\"  - to display all vehicles in this warehouse");
		System.out.println(" \"sc\" - to display all cars in this warehouse");
		System.out.println(" \"sm\" - to display all motorcycles in this warehouse");
		System.out.println(" \"c\"  - to add a new car to this warehouse ");
		System.out.println(" \"m\"  - to add a new motorcycle to this warehouse");
		System.out.println(" \"r\"  - to remove selected vehicle from this warehouse ");
		System.out.println(" \"e\"  - to edit selected vehicle in this warehouse");
		System.out.println(" \"f\"  - to prepare the file with selected vehicle");
		System.out.println(" \"SV\" - to sort vehicles by selected parametr  ");
		System.out.println(" \"b\"  - to go back");
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
	
	private void sendTheVehicleToTheFile(Scanner input){
		if( myVehicle.size() > 0) {	
			System.out.println();
			System.out.println("==============================================================");
			int choice = MyScan.scanInt(input, "Give the vehicle number you want to send to the file : ");
			System.out.println("==============================================================");
		
			if(( choice > 0 ) && ( choice <= myVehicle.size() )) {
				try {
					myVehicle.get(choice-1).sendToTheFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
	
	
	private void sortVehicles(Scanner input) {
		if( myVehicle.size() > 0) {	
			String userChoice;                      boolean showComunicate = true;
			System.out.println();
			System.out.println("==============================================================");
			System.out.println("           Select the parametr to sort vehicles :");
			System.out.println("--------------------------------------------------------------");
			System.out.println("         - \"brand\"         -\"production year\" ");       
			System.out.println("         - \"power\"         -\"mileage\" ");      
			System.out.println("         - \"weight\"        -\"engine capacity\" ");      
			System.out.println("--------------------------------------------------------------");
			System.out.print("Your choice : ");
			userChoice = MyScan.scanString(input);
			System.out.println("--------------------------------------------------------------");
			System.out.println();
			
			switch(userChoice) {
				case "brand" :             this.sortVehiclesByBrand();	  			break;
				case "production year" :   this.sortVehiclesByProductionYear(); 	break;
				case "power" :  		   this.sortVehiclesByPower();				break;
				case "mileage" :           this.sortVehiclesByMileage();            break;
				case "weight" :            this.sortVehiclesByWeight();             break;
				case "engine capacity" :   this.sortVehiclesByEngineCapacity();     break;
				default:  
					showComunicate = false;
					System.out.println("[ vehicles can not be sorted according to the given parameter  ]");
			}	
			if(showComunicate) System.out.println("[ vehicle has been properly sorted by : " + userChoice + " ]");
			MyView.waitUntil(input);
		} else {
			System.out.println();
			System.out.println("---------------------------------------------------");
			System.out.println("-- You do not have any Vehicle in this warehouse --");
			System.out.println("---------------------------------------------------");
			MyView.waitUntil(input);
		}
		
	}
	
	private void sortVehiclesByBrand(){
		Comparator<Vehicle> myVehicleComparator;
		
		myVehicleComparator = new Comparator<Vehicle>() {
			public int compare(Vehicle V1, Vehicle V2) {
				return V1.getBrand().compareTo(V2.getBrand());
			}
		};
		
		myVehicle.sort(myVehicleComparator);
	}
	
	private void sortVehiclesByProductionYear(){
		Comparator<Vehicle> myVehicleComparator;
		
		myVehicleComparator = new Comparator<Vehicle>() {
			public int compare(Vehicle V1, Vehicle V2) {
				if(V1.getProductionYear() > V2.getProductionYear()) 			 return 1;
				else if(V1.getProductionYear() < V2.getProductionYear()) 		 return -1;
				else															 return 0;
			}
		}.reversed();
		
		myVehicle.sort(myVehicleComparator);
	}
	
	private void sortVehiclesByPower(){
		Comparator<Vehicle> myVehicleComparator;
		
		myVehicleComparator = new Comparator<Vehicle>(){
			public int compare(Vehicle V1, Vehicle V2) {
				if(V1.getPower() > V2.getPower()) 			 return 1;
				else if(V1.getPower() < V2.getPower()) 		 return -1;
				else										 return 0;
			}
		}.reversed();
		
		myVehicle.sort(myVehicleComparator);
	}
	
	private void sortVehiclesByMileage(){
		Comparator<Vehicle> myVehicleComparator;
		
		myVehicleComparator = new Comparator<Vehicle>() {
			public int compare(Vehicle V1, Vehicle V2) {
				if(V1.getMileage() > V2.getMileage()) 			 return 1;
				else if(V1.getMileage() < V2.getMileage()) 		 return -1;
				else										 return 0;
			}
		};
		
		myVehicle.sort(myVehicleComparator);
	}
	
	private void sortVehiclesByEngineCapacity(){
		Comparator<Vehicle> myVehicleComparator;
		
		myVehicleComparator = new Comparator<Vehicle>() {
			public int compare(Vehicle V1, Vehicle V2) {
				if(V1.getEngineCapacity() > V2.getEngineCapacity()) 			 return 1;
				else if(V1.getEngineCapacity() < V2.getEngineCapacity()) 		 return -1;
				else															 return 0;
			}
		}.reversed();
		
		myVehicle.sort(myVehicleComparator);
	}
	
	private void sortVehiclesByWeight(){
		Comparator<Vehicle> myVehicleComparator;
		
		myVehicleComparator = new Comparator<Vehicle>() {
			public int compare(Vehicle V1, Vehicle V2) {
				if(V1.getWeight() > V2.getWeight()) 			 return 1;
				else if(V1.getWeight() < V2.getWeight()) 		 return -1;
				else									     	 return 0;
			}
		};
		
		myVehicle.sort(myVehicleComparator);
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
	
	public int calculateCarsNumber() {
		int carsNumber = 0;
		
		for(int i=0; i < myVehicle.size(); i++) {
			if( myVehicle.get(i) instanceof Car) carsNumber++;
		}
		
		return carsNumber;
	}
	
	public int calculateMotorcyclesNumber() {
		
		int motorcyclesNumber=0;
		for(int i=0; i < myVehicle.size(); i++) {
			if( myVehicle.get(i) instanceof Motorcycle) motorcyclesNumber++;
		}
		return motorcyclesNumber;
	}
	
	
	static {
		ID2=0;
	}
		
}


