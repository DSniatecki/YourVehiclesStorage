package com.DSniatecki.tools;

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
				System.out.println("[ !!! wrong answer format !!! ]");
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
			}
			
		}while(!isAnswerCorrectType);
			
			
		return inputInt;
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
				System.out.println("[ !!! wrong answer format !!! ]");
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
		}
		
	}while(!isAnswerCorrectType);
		
	return inputDouble;
	}

}
