import java.util.Scanner;

import com.DSniatecki.tools.MyTime;
import com.DSniatecki.tools.MyView;
import com.DSniatecki.vehiclesAndTheirWarehuses.VehiclesStorageOffice;

public class MainYVSclass {

	public static long programStartTime;
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		startTheProgram();
		
		VehiclesStorageOffice VSO = new VehiclesStorageOffice();
		VSO.execute(input);
		
		endTheProgram();
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
