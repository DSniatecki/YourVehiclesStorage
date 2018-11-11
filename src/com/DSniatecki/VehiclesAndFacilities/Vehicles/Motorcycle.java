package com.DSniatecki.VehiclesAndFacilities.Vehicles;

import com.DSniatecki.tools.MyScan;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public final class Motorcycle extends Vehicle implements Serializable{
	
	private static final long serialVersionUID = 12L;

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

	public  void showInfo(int vehicleNumber) {
		super.showInfo(vehicleNumber);
		System.out.println(" - type of motorcycle         : " + motorcycleType );
		System.out.println(" - seat capacity              : " + typeOfSeat + " person(s) ");
		System.out.println(" - 0-100 km/h time            : " + accelerationTime + " seconds");
		System.out.println("====================================================");
	}
	public  void setInfo(Scanner input) {
		super.setInfo(input);
		input = new Scanner(System.in); 
		System.out.print(                          " - type of motorcycle         : ");
		motorcycleType   = MyScan.scanString(input);
		typeOfSeat       = MyScan.scanInt(input,   " - seat capacity [person(s)]  : ");
		accelerationTime = MyScan.scanDouble(input," - 0-100 km/h time [sec]      : ");
		System.out.println("====================================================");	
	}
	public  void editInfo(Scanner input) {
		String userChoice;
		
		System.out.println();
		System.out.println("==================================================================");
		System.out.println("          Give the car parameter you want to edit :           ");
		System.out.println("------------------------------------------------------------------");
		System.out.println(" - \"brand\"            - \"model\"          - \"production year   ");
		System.out.println(" - \"mileage\"          - \"power\"          - \"engine capacity ");
		System.out.println(" - \"weight\"           - \"accelaration\"   - \"type of seat   ");
		System.out.println(" - \"type of motorycle\"                                      ");
		System.out.println("------------------------------------------------------------------");
		System.out.print("Your choice : ");
		userChoice = MyScan.scanString(input);
		System.out.println("------------------------------------------------------------------");
		System.out.println();
		editInfoInside(userChoice, input);
		}
	private void editInfoInside(String userChoice, Scanner input) {
		
		switch(userChoice) {
		case "type of motorcycle" : 
			System.out.print(                          " - type of motorcycle         : ");
			motorcycleType   = MyScan.scanString(input);
			break;
		case "type of seat" :
			typeOfSeat       = MyScan.scanInt(input,   " - seat capacity [person(s)]  : ");
			break;
		case "acceleration" :
			accelerationTime = MyScan.scanDouble(input," - 0-100 km/h time [sec]      : ");
			break;
		case "weight" : 
			super.setWeight( MyScan.scanDouble(input," - weight [kg]                : "));
			break;
		case "engine capcaity":
			super.setEngineCapacity(MyScan.scanDouble(input," - engine capacity [cm^3]     : "));
			break;
		case "power":
			super.setPower(MyScan.scanInt(input,   " - engine power [hp]          : "));
			break;
		case "mileage":
			super.setMileage(MyScan.scanDouble(input," - mileage                    : "));
			break;
		case "production year":
			super.setProductionYear(MyScan.scanInt(input,   " - production date            : "));
			break;
		case "model":
			super.setModel(MyScan.scanString(input));
			break;
		case "brand":
			System.out.print(" - brand                      : ");
			super.setBrand( MyScan.scanString(input));
			break;
		default:
			
			System.out.println("[ This vehicle is not described by this parametr ] ");
		}	
	System.out.println("          [ Chosen parametr has been modified correctly ]");
		
		
	}
	
	public void sendToTheFile() throws IOException {

		String fileName = getBrand() + "." + getModel() + "." + getID() + ".txt";
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(fileName);
		
			fileWriter.write("[ "+ getID() + " ][ " + getBrand() +" " + getModel() +" ]"+ System.getProperty( "line.separator" ));
			fileWriter.write(" - production date            : "+ getProductionYear()+ System.getProperty( "line.separator" ));
			fileWriter.write(" - mileage                    : "+ getMileage() + " km"+ System.getProperty( "line.separator" ));
			fileWriter.write(" - engine power               : " + getPower() + " hp"+ System.getProperty( "line.separator" ));	
			fileWriter.write(" - engine capacity            : "+ getEngineCapacity() + " cm^3" + System.getProperty( "line.separator" ));
			fileWriter.write(" - weight                     : "+ getWeight() + " kg"+ System.getProperty( "line.separator" ));
			fileWriter.write(" - type of motorcycle         : " + motorcycleType + System.getProperty( "line.separator" ));
			fileWriter.write(" - seat capacity              : " + typeOfSeat + " person(s)"+ System.getProperty( "line.separator" ));
			fileWriter.write(" - 0-100 km/h time            : " + accelerationTime + " seconds"+ System.getProperty( "line.separator" ));
			System.out.println("");
			System.out.println("[ The file : " + fileName + " was created correctly ]");
			System.out.println("");
			
		
		} catch ( IOException e ) {
			System.out.println("");
			System.out.println("[ Warning ! An error occurred while creating the file ]");
			System.out.println("");
		} finally {
			fileWriter.close();
			
		}
		
		
		
	}
	
	public String getMotorcycleType() {
		return motorcycleType;
	}
	public    int getTypeOfSeat() {
		return typeOfSeat;
	}
	public double getAccelerationTime() {
		return accelerationTime;
	}

	static {	
		ID2=0;
	}

}
