package com.DSniatecki.VehiclesAndFacilities.Vehicles;

import com.DSniatecki.tools.MyScan;

import java.io.Serializable;
import java.util.Scanner;

public final class Car extends Vehicle implements Serializable{

	private static final long serialVersionUID = 1L;

	private static int ID2;
	
	private int length;
	private int doorsNumber;
	private String bodyType;
	private String FuelType;
	
    public Car() {
    	this("none", "none", 0, 0, 0, 0, 0, 0, 0, "none", "none");
    }
	public Car(String brand,String model,int productionYear,double mileage, int power, double engineCapacity,
			double weight, int length, int doorsNumber,String bodyType, String FuelType) {	
		
		super(brand, model, productionYear, mileage, power, engineCapacity, weight);
		this.length = length;
		this.doorsNumber = doorsNumber;
		this.bodyType = bodyType;
		this.FuelType = FuelType;
		
		ID2++;
		super.setID("C." + ID2);
	}

	public void showInfo(int vehicleNumber) {
		super.showInfo(vehicleNumber);
		System.out.println(" - fueltype                   : " + FuelType);
		System.out.println(" - type of body               : " + bodyType);
		System.out.println(" - number of doors            : " + doorsNumber + " doors");
		System.out.println(" - car length                 : " + length + " mm");	
		System.out.println("====================================================");
	}
	public void setInfo(Scanner input) {
		super.setInfo(input);
		input = new Scanner(System.in);
		System.out.print(" - type of body [e.g. coupe ] : ");
		bodyType    = MyScan.scanString(input);
		System.out.print(" - fueltype [petrol/diesel]   : ");
		FuelType    = MyScan.scanString(input);
		length      = MyScan.scanInt(input," - length [ mm ]              : ");
		doorsNumber = MyScan.scanInt(input," - number of door             : ");
		System.out.println("====================================================");
	}
	public void editInfo(Scanner input) {
		String userChoice;
		
		System.out.println();
		System.out.println("==============================================================");
		System.out.println("Give the car parameter you want to edit :");
		System.out.println("--------------------------------------------------------------");
		System.out.println(" - \"brand\"         -\"model\"         -\"production year");
		System.out.println(" - \"mileage\"       -\"power\"         -\"engine capacity\" ");
		System.out.println(" - \"weight\"        -\"length\"        -\"number of doors\" ");
		System.out.println(" - \"type of body\"  -\"type of fuel\"  ");
		System.out.println("--------------------------------------------------------------");
		System.out.print("Your choice : ");
	
		userChoice = MyScan.scanString(input);
	
		switch(userChoice) {
			case "type of fuel" : 
				System.out.print(" - fueltype [petrol/diesel]   : ");
				FuelType    = MyScan.scanString(input);
				break;
			case "type of body" :
				System.out.print(" - type of body [e.g. coupe ] : ");
				bodyType    = MyScan.scanString(input);
				break;
			case "length" :
				length      = MyScan.scanInt(input," - length [ mm ]              : ");
				break;
			case "number of doors":
				doorsNumber = MyScan.scanInt(input," - number of door             : ");
				break;
			case "weight" : 
				break;
			case "engine capcaity":
				break;
			case "power":
				break;
			case "mileage":
				break;
			case "production year":
				break;
			case "model":
				break;
			case "brand":
				break;
			default:
				System.out.println(" [ This vehicle is not described by this parametr");
		}	
		
			
	
	}
	
	
	public    int getLength() {
		return length;
	}
	public    int getDoorsNumber() {
		return doorsNumber;
	}
	public String getBodyType() {
		return bodyType;
	}
	public String getFuelType() {
		return FuelType;
	}

	static {	
		ID2=0;
	}

}
