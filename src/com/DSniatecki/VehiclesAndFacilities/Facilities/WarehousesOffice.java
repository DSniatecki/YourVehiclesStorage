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
	
	public void saveToFile(String fileLocation) {
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
	public void loadTheStateFromFile(String fileLocation) {
		
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
	
	public void  execute(Scanner input) {
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
				case "t" :
					MyTime.showCurrentTime();
					MyView.waitUntil(input);
					break;
				case "r" :
					removeWarehouse(input);
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
		System.out.println("[ Welcome in main menu . Press :   ]");
		System.out.println();
		System.out.println(" \"s\" - to display all warehouses ");
		System.out.println(" \"c\" - to create a new warehouse ");
		System.out.println(" \"o\" - to open selected warehouse menu");
		System.out.println(" \"t\" - to show current time");
		System.out.println(" \"r\" - to remove selected warehouse");
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

}
