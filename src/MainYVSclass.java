
import java.util.Scanner;

import com.DSniatecki.VehiclesAndFacilities.Facilities.WarehousesOffice;

import com.DSniatecki.tools.MyTime;
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
		System.out.println("[ !!! Welcome in the program  !!! ]");
		MyTime.showCurrentTime();
		MyView.waitUntil(input);
	}
	
	private static void endTheProgram(){

		long programExecutionTime = System.currentTimeMillis() - PROGRAM_START_TIME;
		System.out.println();
		System.out.println("[ The Program has been closed ] ");
		System.out.println("[ Execution time : " + ( double ) ( programExecutionTime / 1000.0 ) + " seconds ]" ); 
	
	}

}
