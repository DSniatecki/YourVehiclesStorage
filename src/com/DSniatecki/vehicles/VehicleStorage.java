package com.DSniatecki.vehicles;

import java.util.ArrayList;
import java.util.Scanner;

import com.DSniatecki.tools.MyScan;
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
	
	
	
	public void showInfo(int storageNumber) {
		System.out.println("====================================================");
		System.out.println("                  Storage : " + storageNumber);
		System.out.println("----------------------------------------------------");
		System.out.println(" [ "+ ID + " ] " + this.typeOfStorage + " : " + this.adress);
		System.out.println("====================================================");	
	}
	
	public void setInfo(Scanner input) {
		System.out.println();
		System.out.println("====================================================");
		System.out.println(" Podaj ponizsze dane dotyczace tego magazynu : ");
		System.out.print(" - typ magazynu        : ");
		typeOfStorage = input.nextLine();
		System.out.print(" - adress magazynu     : ");
		adress = input.nextLine();
		System.out.println("====================================================");
	}
	
	
	
	private void addCar(Scanner input){
		myVehicle.add(new Car());
		myVehicle.get(myVehicle.size()-1).setInfo(input);
	}
	
	private void addMotorcycle(Scanner input) {
		
		myVehicle.add(new Motorcycle());
		myVehicle.get(myVehicle.size()-1).setInfo(input);
	}
	
	public  void removeVehicle(Scanner input) {
		System.out.println();
		System.out.println("====================================================");
		int choice = MyScan.scanInt(input, "Podaj numer pojazdu ktory chcesz usunac : ");
		System.out.println("====================================================");
		
		if(( choice > 0 ) && ( choice <= myVehicle.size() )) {
			myVehicle.remove(choice-1);
		}
		else{
			System.out.println();
			System.out.println(" >> Nie znaleziono pojazdu o takim numerze << ");
			input = new Scanner(System.in);
			MyView.waitUntil(input);
		}
			
	}
	
	
	public void showMenu() {
		System.out.println("[ Welcome in Garage menu. Press :   ]");
		System.out.println();
		System.out.println(" \"s\" - to display all vehicles in this garage ");
		System.out.println(" \"c\" - to add a new car to this garage ");
		System.out.println(" \"m\" - to add a new motorcycle to this garage");
		System.out.println(" \"r\" - to remove selected vehicle from this garage ");
		System.out.println(" \"b\" - to go back");
		System.out.println();
		System.out.print(">> Your choice : ");
	}
	
	public void execute(Scanner input) {
		input = new Scanner(System.in);
		
		String userChoice;
		do {
			MyView.clearScreen();
			
			showMenu();
			userChoice = input.nextLine();
			
			MyView.clearScreen();
			
			switch(userChoice) {
				case "s" :
					showAllVehicles();
					MyView.waitUntil(input);
					break;
				case "c" :
					addCar(input);
					break;
				case "m" :
					addMotorcycle(input);
					break;
				case "r" :
					removeVehicle(input);
					input = new Scanner(System.in);
					break;
				case "b" :
					break;
				default  :
					System.out.println();
					System.out.println("[ Prosze wybrac jedna z pozycji z menu magazynu !!! ]");
					MyView.waitUntil(input);
					break;
			
			
			}
		
		
		}while(!userChoice.equals("b"));
	}
	
	
	public void showAllVehicles() {
		System.out.println("");
		if(myVehicle.size() != 0) {
			for(int i=0; i < myVehicle.size(); i++) {
				myVehicle.get(i).showInfo(i+1);
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


