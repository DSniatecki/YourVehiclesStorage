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
		
		MyView.waitUntil(input);
				
		do {
			
			MyView.clearScreen();
			
			showMenu();
			
			userChoice = input.nextLine();
			
			MyView.clearScreen();
			
			
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
				case "l" :
					if( myStorage.size() > 0) {
						myStorage.get(myStorage.size()-1).execute(input);
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
				case "Q" :
					break;
				default  :
					System.out.println();
					System.out.println("[ Prosze wybrac jedna z pozycji z glownego menu !!! ]");
					MyView.waitUntil(input);
					break;
			}
			
		}while(!userChoice.equals("Q"));
		
		
		endTheProgram();

	}
	
	public static void showMenu() {
		System.out.println("[ Welcome in Main menu . Press :   ]");
		System.out.println();
		System.out.println(" \"s\" - to display all Storages ");
		System.out.println(" \"c\" - to create a new Storage ");
		System.out.println(" \"l\" - to go into last Storage menu");
		System.out.println(" \"t\" - to show current time");
		System.out.println(" \"Q\" - to exit program");
		System.out.println();
		System.out.print(">> Your choice : ");
	}	
	
	public static void showAllStorages() {
		if( myStorage.size() > 0) {
			for(VehicleStorage x : myStorage) {
				x.showInfo();
			}	
		}
		else {
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println("-------  You do not have any warehouse  --------");
			System.out.println("------------------------------------------------");
		}
	
	}
	
	public static void startTheProgram(){
		MyView.clearScreen();
		System.out.println("[ !!! Welcome in the program  !!! ]");
		programStartTime = System.currentTimeMillis();
		MyTime.showCurrentTime();
	}
	
	public static void endTheProgram(){

		long programExecutionTime = System.currentTimeMillis() - programStartTime;
		System.out.println();
		System.out.println("[ The Program has been closed ] ");
		System.out.println("[ Execution time : " + ( double ) ( programExecutionTime / 1000.0 ) + " seconds ]" ); 
	
	}

}
