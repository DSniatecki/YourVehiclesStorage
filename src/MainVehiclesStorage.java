import java.util.ArrayList;
import java.util.Scanner;

import com.DSniatecki.vehicles.*;
import com.DSniatecki.tools.*;

public class MainVehiclesStorage {

	public static long programStartTime;
	public static ArrayList<VehicleStorage> myStorage = new ArrayList<VehicleStorage>(2);
	public static Scanner input = new Scanner(System.in);	
	
	public static void main(String[] args) {

		String userChoice;
		startTheProgram();		
				
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
						
						System.out.println("====================================================");
						choice = MyScan.scanInt(input, "Podaj numer magazynu do ktorego chcesz przejsc : ");     
						System.out.println("====================================================");
						
						if(( choice > 0 ) && ( choice <= myStorage.size() )) 
						{
							input.nextLine();
							myStorage.get(choice-1).execute(input);
						}
						else
						{
							System.out.println();
							System.out.println(" >> Nie znaleziono magazynu o takim numerze << ");		
							input.nextLine();
							MyView.waitUntil(input);		
						}
					}
					else {
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
					removeStorage();
					break;
				case "Q" :
					break;
				
				default:
					System.out.println();
					System.out.println("[ Prosze wybrac jedna z pozycji z glownego menu !!! ]");
					MyView.waitUntil(input);
					break;
			}
			
		}while(!userChoice.equals("Q"));
		
		
		endTheProgram();

	}
	
	public static void removeStorage() {
		
		if( myStorage.size() > 0) {
			int choice=0;
		
			System.out.println("====================================================");
			choice = MyScan.scanInt(input, "Podaj numer magazynu ktory chcesz usunac : ");
			System.out.println("====================================================");
		
		
			if(( choice > 0 ) && ( choice <= myStorage.size() )) {
				myStorage.remove(choice-1);
				System.out.println();
				System.out.println("[ Storage " + choice + ". was successfully removed ]");			
			}
			else{
				System.out.println();
				System.out.println(" >> Nie znaleziono magazynu o takim numerze << ");				
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

	public static void showMenu() {
		System.out.println("[ Welcome in Main menu . Press :   ]");
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
	
	public static void showAllStorages() {
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
	
	public static void startTheProgram(){
		MyView.clearScreen(input);
		System.out.println("[ !!! Welcome in the program  !!! ]");
		programStartTime = System.currentTimeMillis();
		MyTime.showCurrentTime();
		MyView.waitUntil(input);
	}
	
	public static void endTheProgram(){

		long programExecutionTime = System.currentTimeMillis() - programStartTime;
		System.out.println();
		System.out.println("[ The Program has been closed ] ");
		System.out.println("[ Execution time : " + ( double ) ( programExecutionTime / 1000.0 ) + " seconds ]" ); 
	
	}

}
