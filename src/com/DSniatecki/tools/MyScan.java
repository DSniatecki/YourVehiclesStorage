package com.DSniatecki.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class MyScan {
	
	public static int    scanInt(Scanner input, String question){
		int inputInt=0; 
		boolean isAnswerCorrectType=false;
		System.out.print(question);
		do {
			if(input.hasNextInt()) {
				inputInt = input.nextInt();
				isAnswerCorrectType = true;
				
			}
			else {
				System.out.println("[ Wrong Format ][ Enter an integer ]");
				System.out.print(question);
				input.next();
			}
			
		}while(!isAnswerCorrectType);
			
			
		return inputInt;
	}

	public static int    scanInt(Scanner input){
		int inputInt=0; 
		boolean isAnswerCorrectType=false;
		do {
			if(input.hasNextInt()) {
				inputInt = input.nextInt();
				isAnswerCorrectType = true;
			}
			else {
				input.next();
				System.out.println("[ Wrong Format ][ Enter an integer ]");
			}
			
		}while(!isAnswerCorrectType);
			
			
		return inputInt;
	}
	
	public static int    getInt(Scanner input){
		int b;
		
		do {
			try {
				b = input.nextInt();
				return b;
			}
			catch(InputMismatchException e){
				input.nextLine();
				System.out.println("[ Wrong Format ][ Enter an integer ]");
			}
		}while(true);
		}
	
	public static double scanDouble(Scanner input, String question){
		double inputDouble=0;
		boolean isAnswerCorrectType=false;
		System.out.print(question);
		do {
			if(input.hasNextDouble()) {
				inputDouble = input.nextDouble();
				isAnswerCorrectType = true;
			}
			else {
				System.out.println("[ Wrong Format ][ Enter a floating point number or an integer ]");
				System.out.print(question);
				input.next();
			}
			
		}while(!isAnswerCorrectType);
			
		return inputDouble;
	}

	public static double scanDouble(Scanner input){
	double inputDouble=0;
	boolean isAnswerCorrectType=false;
	do {
		if(input.hasNextDouble()) {
			inputDouble = input.nextDouble();
			isAnswerCorrectType = true;
		}
		else {
			input.next();
			System.out.println("[ Wrong Format ][ Enter a floating point number or an integer ]");
		}
		
	}while(!isAnswerCorrectType);
		
	return inputDouble;
	}

	public static double getDouble(Scanner input){
		int b;
		
		do {
			try {
				b = input.nextInt();
				return b;
			}
			catch(InputMismatchException e){
				input.nextLine();
				System.out.println("[ Wrong Format ][ Enter a floating point number or an integer ]");
			}
		}while(true);
		}

	public static String scanString(Scanner input){
		return input.nextLine();
	}
}
