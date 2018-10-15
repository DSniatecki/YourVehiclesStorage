package com.DSniatecki.vehiclesAndTheirWarehuses;

import java.util.ArrayList;
import java.util.Scanner;

import com.DSniatecki.tools.*;

public final class VehiclesStorageOffice{

	private ArrayList<VehicleStorage> myStorage = new ArrayList<VehicleStorage>(2);
		
	public void execute(Scanner input) {

		String userChoice;
				
		do {
			MyView.clearScreen(input);
	
			showMenu();
			userChoice = input.nextLine();
			
			MyView.clearScreen(input);
			
			switch(userChoice) {
				case "s" :
					showAllStorages();
					MyView.waitUntil(input);
					break;
				case "c" :
					myStorage.add(new VehicleStorage());
					myStorage.get( myStorage.size() - 1 ).setInfo(input);
					MyView.waitUntil(input);
					break;
				case "o" :
					if( myStorage.size() > 0) {
						int choice=0;
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
					removeStorage(input);
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
	
	private void removeStorage(Scanner input) {
		
		if( myStorage.size() > 0) {
			int choice=0;
		
			System.out.println("====================================================");
			choice = MyScan.scanInt(input, "Give the storage number you want to delete : ");
			System.out.println("====================================================");
		
		
			if(( choice > 0 ) && ( choice <= myStorage.size() )) {
				myStorage.remove(choice-1);
				System.out.println();
				System.out.println("[ Storage " + choice + ". was successfully removed ]");			
			}
			else{
				System.out.println();
				System.out.println(" >> No storage with the given number was found << ");				
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
		System.out.println("[ Welcome in main menu . Press :   ]");
		System.out.println();
		System.out.println(" \"s\" - to display all Storages ");
		System.out.println(" \"c\" - to create a new Storage ");
		System.out.println(" \"o\" - to open selected storage menu");
		System.out.println(" \"t\" - to show current time");
		System.out.println(" \"r\" - to remove selected storage");
		System.out.println(" \"Q\" - to exit program");
		System.out.println();
		System.out.print(">> Your choice : ");
	}	
	
	private void showAllStorages() {
		System.out.println();
		if( myStorage.size() > 0) {
			for(int i=0; i < myStorage.size(); i++) {
				myStorage.get(i).showInfo(i+1);
			}	
		}
		else {
			System.out.println("------------------------------------------------");
			System.out.println("-------  You do not have any warehouse  --------");
			System.out.println("------------------------------------------------");
		}
	
	}
}
