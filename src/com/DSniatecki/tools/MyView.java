package com.DSniatecki.tools;

import java.io.IOException;
import java.util.Scanner;

public final class MyView {
	
//	public static void   clearScreen(){
//	    //Clears Screen in java
//	    try {
//	        if (System.getProperty("os.name").contains("Windows")) {
//	        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//	        }
//	        else {
//	            Runtime.getRuntime().exec("clear");
//	        }
//	   } catch (IOException | InterruptedException ex) {}
//	
//	}
	
	@SuppressWarnings("resource")
	public static void   clearScreen(Scanner input){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows")) {
	        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else {
	            Runtime.getRuntime().exec("clear");
	        }
	   } catch (IOException | InterruptedException ex) {}
	
	    input = new Scanner(System.in);
	    
	}
	
	
	public static void   waitUntil(Scanner input){
		System.out.println();
		System.out.print("[ Press enter to continue ] ");
		input.nextLine();
	}
		
	public static void   waitUntil(Scanner input, String message){
		System.out.println();
		System.out.print(message);
		input.nextLine();
	}

}
