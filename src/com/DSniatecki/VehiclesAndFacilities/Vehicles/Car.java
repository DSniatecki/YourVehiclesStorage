package com.DSniatecki.VehiclesAndFacilities.Vehicles;

import com.DSniatecki.tools.MyScan;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public final class Car extends Vehicle implements Serializable{

	private static final long serialVersionUID = 11L;

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

	public  void showInfo(int vehicleNumber) {
		super.showInfo(vehicleNumber);
		System.out.println(" - fueltype                   : " + FuelType);
		System.out.println(" - type of body               : " + bodyType);
		System.out.println(" - number of doors            : " + doorsNumber + " doors");
		System.out.println(" - car length                 : " + length + " mm");	
		System.out.println("====================================================");
	}
	public  void setInfo(Scanner input) {
		super.setInfo(input);
		input = new Scanner(System.in);
		System.out.print(" - type of body [e.g. coupe ] : ");
		bodyType    = MyScan.scanString(input);
		System.out.print(" - fueltype [petrol/diesel]   : ");
		FuelType    = MyScan.scanString(input);
		length      = MyScan.scanInt(input," - length [ mm ]              : ");
		doorsNumber = MyScan.scanInt(input," - number of doors            : ");
		System.out.println("====================================================");
	}
	public  void editInfo(Scanner input) {
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
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		editInfoInside(userChoice, input);
		}
	private void editInfoInside(String userChoice, Scanner input) {
		
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
			doorsNumber = MyScan.scanInt(input," - number of doors            : ");
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
			System.out.println(" This vehicle is not described by this parametr ]");
		}	
		
	}
	
	public void sendToTheFile() throws IOException {
		
		String fileName = getBrand() + "." + getModel() + "." + getID() + ".txt";
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.write("[ "+ getID() + " ][ " + getBrand() +" " + getModel() +" ]"+ System.getProperty( "line.separator" ));
			fileWriter.write(" - production date            : "+ getProductionYear() + System.getProperty( "line.separator" ));
			fileWriter.write(" - mileage                    : "+ getMileage() + " km "+ System.getProperty( "line.separator" ));
			fileWriter.write(" - engine power               : " + getPower() + " hp" + System.getProperty( "line.separator" ));	
			fileWriter.write(" - engine capacity            : "+ getEngineCapacity() + " cm^3" + System.getProperty( "line.separator" ));
			fileWriter.write(" - weight                     : "+ getWeight() + " kg "+ System.getProperty( "line.separator" ));
			fileWriter.write(" - fueltype                   : " + FuelType + System.getProperty( "line.separator" ));
			fileWriter.write(" - type of body               : " + bodyType + System.getProperty( "line.separator" ));
			fileWriter.write(" - number of doors            : " + doorsNumber + " doors"+ System.getProperty( "line.separator" ));
			fileWriter.write(" - car length                 : " + length + " mm"+ System.getProperty( "line.separator" ));	
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
