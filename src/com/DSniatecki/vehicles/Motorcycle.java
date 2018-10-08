package com.DSniatecki.vehicles;

import com.DSniatecki.tools.MyScan;
import java.util.Scanner;

public class Motorcycle extends Vehicle{

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
		
		if((typeOfSeat < 1 || typeOfSeat > 2 ) && weight != 0) {
			System.out.println("# Warning !!! #[ " + getID() + " This object has na incorrect seat type ]# Warning !!! #");
		}
	}

	public void showInfo() {
	
		System.out.println("------------------------------------------------");
		super.showInfo();
		System.out.println(" - type of motorcycle         : " + motorcycleType );
		System.out.println(" - seat capacity              : " + typeOfSeat + " person(s) ");
		System.out.println(" - 0-100 kmh time             : " + accelerationTime + " seconds");
		System.out.println("------------------------------------------------");
	}

	public void setInfo(Scanner input) {
		input = new Scanner(System.in);
		System.out.println();
		System.out.println("================================================");
		super.setInfo(input);
		input = new Scanner(System.in);
		System.out.print(" - type of motorcycle         : ");
		motorcycleType   = input.nextLine();
		typeOfSeat       = MyScan.scanInt(input," - siedzenie [ilo miejscowe]  : ");
		accelerationTime = MyScan.scanDouble(input," - czas 0-100 km/h [sek]      : ");
		System.out.println("================================================");	
	}
	
	static {
	
		ID2=0;
	}

	
}
