package com.DSniatecki.vehicles;

import com.DSniatecki.tools.MyScan;
import java.util.Scanner;

public final class Motorcycle extends Vehicle{

	private static int ID2;
	
	private String motorcycleType;
	private int typeOfSeat;
	private double accelerationTime;
	
	
    public Motorcycle() {
    	this("none","none", 0, 0, 0, 0, 0,"none", 0, 0);
    }
	
	public Motorcycle(String brand,String model,int productionYear,double mileage, int power, double engineCapacity, double weight,String motorcycleType, int typeOfSeat, double accelerationTime) {
		super(brand, model, productionYear, mileage, power, engineCapacity, weight);
		this.motorcycleType = motorcycleType;
		this.typeOfSeat = typeOfSeat;
		this.accelerationTime = accelerationTime;
		ID2++;
		super.setID("M." + ID2);
		
	}

	public void showInfo(int vehicleNumber) {
		super.showInfo(vehicleNumber);
		System.out.println(" - type of motorcycle         : " + motorcycleType );
		System.out.println(" - seat capacity              : " + typeOfSeat + " person(s) ");
		System.out.println(" - 0-100 km/h time            : " + accelerationTime + " seconds");
		System.out.println("====================================================");
	}

	public void setInfo(Scanner input) {
		super.setInfo(input);
		input = new Scanner(System.in); 
		System.out.print(                          " - type of motorcycle         : ");
		motorcycleType   = input.nextLine();
		typeOfSeat       = MyScan.scanInt(input,   " - seat capacity [person(s)]  : ");
		accelerationTime = MyScan.scanDouble(input," - 0-100 km/h time [sec]      : ");
		System.out.println("====================================================");	
	}
	
	static {	
		ID2=0;
	}

	
}
