
import java.util.Scanner;

import com.DSniatecki.VehiclesAndFacilities.Facilities.WarehousesOffice;

import com.DSniatecki.tools.MyView;

public class MainYVSclass {

	private static final long PROGRAM_START_TIME = System.currentTimeMillis();
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
		startTheProgram();
		
		
		WarehousesOffice VSO = new WarehousesOffice();
		
		VSO.loadTheStateFromFile("VehiclesStorageOffice.ser");
		VSO.execute(input);
		VSO.saveToFile("VehiclesStorageOffice.ser");
		
		endTheProgram();
	}
	
	private static void startTheProgram(){
		MyView.clearScreen(input);                        
		System.out.println(" _____________________________________________________________________ ");
		System.out.println("|  _________________________________________________________________  |");
		System.out.println("| |                                                                 | |");
		System.out.println("| |                 \" YOUR VEHICLES STORAGE V1.0\"                   | |");
		System.out.println("| |                                                                 | |");
		System.out.println("| |      ____________________________________________________       | |");	
		System.out.println("| |     /                                                    \\      | |");
		System.out.println("| |    /                                                      \\     | |");
		System.out.println("| |   /________________________________________________________\\    | |");
		System.out.println("| |     |_|___|___|___|___|___|___|___|___|___|___|____|___|_|      | |");
		System.out.println("| |     |___|                   |___|                    |___|      | |");
		System.out.println("| |     |_|_|                   |_|_|                    |_|_|      | |");
		System.out.println("| |     |___|                   |___|                    |___|      | |");
		System.out.println("| |     |_|_|___________________|_|_|____________________|_|_|      | |");
		System.out.println("| |                                                                 | |");
		System.out.println("| |                                                                 | |");
		System.out.println("| |_________________________________________________________________| |");
		System.out.println("|_____________________________________________________________________|");		
		System.out.println("");		
		System.out.println("                 [ !!! Welcome in the program  !!! ]                  ");
		MyView.waitUntil(input, "                    [ Press \"enter\" to continue ] ");
	
	
	
	}
	
	private static void endTheProgram(){

		long programExecutionTime = System.currentTimeMillis() - PROGRAM_START_TIME;
		System.out.println();
		System.out.println("[ The Program has been closed ] ");
		System.out.println("[ Execution time : " + ( double ) ( programExecutionTime / 1000.0 ) + " seconds ]" ); 
	
	}

}
