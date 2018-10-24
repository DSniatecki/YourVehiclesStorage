package com.DSniatecki.VehiclesAndFacilities.Facilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.DSniatecki.tools.*;


public final class WarehousesOffice{
	
	private ArrayList<VehicleWarehouse> myStorage = new ArrayList<VehicleWarehouse>(2);
	
	public  void saveToFile(String fileLocation) {
		try{
		   FileOutputStream myFileOutputStream = new FileOutputStream(fileLocation);
		   ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myFileOutputStream);
		   myObjectOutputStream.writeObject(myStorage);
		   myObjectOutputStream.close();
		}
		catch (Exception e){
		   e.printStackTrace(); 
		}
	}
	@SuppressWarnings("unchecked")
	public  void loadTheStateFromFile(String fileLocation) {
		
		try{
		    FileInputStream myFileInputStream = new FileInputStream(fileLocation);
		    ObjectInputStream myObjectInputStream = new ObjectInputStream(myFileInputStream);
		    myStorage = (ArrayList<VehicleWarehouse>) myObjectInputStream.readObject(); 
		    myObjectInputStream.close();
		}
		catch(FileNotFoundException e){
		}
		catch (Exception e){
			e.printStackTrace(); 
		}
		
    }
	public  void execute(Scanner input) {
		String userChoice;		
		do {
			MyView.clearScreen(input);
			showMenu();
			userChoice = input.nextLine();
			MyView.clearScreen(input);
			
			switch(userChoice) {
				case "s" :
					showAllWarehouses();
					MyView.waitUntil(input);
					break;
				case "c" :
					myStorage.add(new VehicleWarehouse());
					myStorage.get( myStorage.size() - 1 ).setInfo(input);
					MyView.waitUntil(input);
					break;
				case "o" :
					if( myStorage.size() > 0) {
						int choice=0;
						System.out.println();
						System.out.println("=========================================================");
						choice = MyScan.scanInt(input, "Give the number of the storage you want to access : ");     
						System.out.println("=========================================================");
						
						if(( choice > 0 ) && ( choice <= myStorage.size() )) {
							input.nextLine();
							myStorage.get(choice-1).execute(input, choice);
						} else {
							System.out.println();
							System.out.println(" >> No storage with the given number was found << ");		
							input.nextLine();
							MyView.waitUntil(input);		
						}
					} else {
						System.out.println();
						System.out.println("------------------------------------------------");
						System.out.println("-------  You do not have any warehouse  --------");
						System.out.println("------------------------------------------------");
						MyView.waitUntil(input);
					}	
					break;
				case "S" :
				    showStatistics();
				    MyView.waitUntil(input);
				    break;
				case "t" :
					MyTime.showCurrentTime();
					MyView.waitUntil(input);
					break;
				case "r" :
					removeWarehouse(input);
					break;
				case "e" :
					editWarehouse(input);
					break;
				case "Q" :
					break;
				
				default:
					System.out.println();
					System.out.println("[ Please select one of the main menu options !!! ]");
					MyView.waitUntil(input);
					break;
			}
			
		}while(!userChoice.equals("Q"));		
	}
	private void removeWarehouse(Scanner input) {
		
		if( myStorage.size() > 0) {
			int choice=0;
			System.out.println();
			System.out.println("====================================================");
			choice = MyScan.scanInt(input, "Give the warehouse number you want to delete : ");
			System.out.println("====================================================");
		
		
			if(( choice > 0 ) && ( choice <= myStorage.size() )) {
				myStorage.remove(choice-1);
				System.out.println();
				System.out.println("[ Warehouse " + choice + ". was successfully removed ]");			
			}
			else{
				System.out.println();
				System.out.println(" >> No warehouse with the given number was found << ");				
			}
			input.nextLine();
			MyView.waitUntil(input);	
		}
		else {
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println("-------  You do not have any warehouse  --------");
			System.out.println("------------------------------------------------");
			MyView.waitUntil(input);
		}	
	}
	private void showMenu() {
		System.out.println();
		System.out.println("[ Welcome in main menu.][ You have : " + myStorage.size() + " storage(s) ]");
		System.out.println();
		System.out.println("Press :");
		System.out.println();
		System.out.println(" \"s\" - to display all warehouses ");
		System.out.println(" \"c\" - to create a new warehouse ");
		System.out.println(" \"o\" - to open selected warehouse menu");
		System.out.println(" \"r\" - to remove selected warehouse");
		System.out.println(" \"e\" - to edit selected warehouse");
		System.out.println(" \"S\" - to display statistics");
		System.out.println(" \"t\" - to show current time");
		System.out.println(" \"Q\" - to exit program");
		System.out.println();
		System.out.print(">> Your choice : ");
	}	
	private void showAllWarehouses() {
		if( myStorage.size() > 0) {
			for(int i=0; i < myStorage.size(); i++) {
				myStorage.get(i).showInfo(i+1);
			}	
		}
		else {
			System.out.println("");
			System.out.println("------------------------------------------------");
			System.out.println("-------  You do not have any warehouse  --------");
			System.out.println("------------------------------------------------");
		}
	
	}
	private void showStatistics() {
		long totalVehiclesPower = getTotalPower();
		if(totalVehiclesPower == 0) {
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("-- There is no vehicle in any of the warehouses --");
			System.out.println("--------------------------------------------------");
			
		} else {
		System.out.println();
		System.out.println("====================================================");
		System.out.println("               Vehicles statistics :                 ");
		System.out.println("----------------------------------------------------");
		System.out.println("");
		System.out.println(" - total power    : " + totalVehiclesPower + " hp");
		System.out.println("");
		System.out.println(" - total mileage  : " + getTotalMileage() + " km");
		System.out.println("");
		System.out.println(" - total weight   : " + getTotalWeight() + " kg");
		System.out.println("");
		System.out.println("====================================================");	
		}
	}
	
	private void editWarehouse(Scanner input) {
		if( myStorage.size() > 0) {	
			System.out.println();
			System.out.println("====================================================");
			int choice = MyScan.scanInt(input, "Give the warehouse number you want to edit : ");
			System.out.println("====================================================");
		
			if(( choice > 0 ) && ( choice <= myStorage.size() )) {
				MyView.clearScreen(input);
				input.nextLine();
				myStorage.get(choice-1).editInfo(input);
			}
			else{
				input.nextLine();
				System.out.println();
				System.out.println(" >> No warehouse with the given number was found << ");			
			}
			MyView.waitUntil(input);	
		}
		else {
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println("-------- You do not have any warehouse ---------");
			System.out.println("------------------------------------------------");
			MyView.waitUntil(input);
		}
	}
	
	private long getTotalPower() {
		long totalPower=0;
		for(VehicleWarehouse x : myStorage) {
			totalPower += x.getTotalPower();
		}
		return totalPower;
	}	
	private long getTotalMileage() {
		long totalMileage=0;
		for(VehicleWarehouse x : myStorage) {
			totalMileage += x.getTotalMileage();
		}
		return totalMileage;
	}	
	private long getTotalWeight(){
		long totalWeight=0;
		for(VehicleWarehouse x : myStorage) {
			totalWeight += x.getTotalWeight();
		}
		return totalWeight;
	}
	
	
}
