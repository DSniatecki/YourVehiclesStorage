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
