package com.DSniatecki.VehiclesAndFacilities.Vehicles;

import com.DSniatecki.tools.MyScan;

import java.util.Scanner;

public abstract class Vehicle implements Vehicable{
	 
		private String ID;
		private String brand;
		private String model;
		private int productionYear;
		private double mileage;
		private int power;
		private double engineCapacity;
		private double weight;
		
		public Vehicle() {
			this("none", "none", 0, 0, 0, 0, 0);
		}	
		public Vehicle( String brand, String model,int productionYear,double mileage, int power, double engineCapacity, double weight) {		
			this.brand = brand;
			this.model = model;
			this.productionYear= productionYear;
			this.mileage = mileage;
			this.power = power;
			this.engineCapacity = engineCapacity;
			this.weight = weight;
		}

		public void showInfo(int vehicleNumber) {
			System.out.println();
			System.out.println("====================================================");
			System.out.println("                  Vehicle : " + vehicleNumber);
			System.out.println("----------------------------------------------------");
			System.out.println("[ "+ ID + " ][ " + brand +" " + model +" ]");
			System.out.println(" - production date            : "+ productionYear);
			System.out.println(" - mileage                    : "+ mileage + " km ");
			System.out.println(" - engine power               : " + power + " hp");	
			System.out.println(" - power per ton              : " + (Math.round((double)(power / weight )*1000.0)/1000.0) + " hp/ton");
			System.out.println(" - engine capacity            : "+ engineCapacity + " cm^3");
			System.out.println(" - weight                     : "+ weight + " kg ");

		}	
		public void setInfo(Scanner input) {
			System.out.println();
			System.out.println("====================================================");
			System.out.println(" Give the data below regarding this vehicle : ");
			System.out.print(" - brand                      : ");
			brand          = MyScan.scanString(input);
			System.out.print(" - model                      : ");
			model          = MyScan.scanString(input);
			productionYear = MyScan.scanInt(input,   " - production date            : ");
			mileage        = MyScan.scanDouble(input," - mileage                    : ");
			power          = MyScan.scanInt(input,   " - engine power [hp]          : ");
			engineCapacity = MyScan.scanDouble(input," - engine capacity [cm^3]     : ");
			weight         = MyScan.scanDouble(input," - weight [kg]                : ");
		}
		public abstract void editInfo(Scanner input);
		
		public String getID() {
			return ID;
		}
		public   void setID(String iD) {
			ID = iD;
		}
		public String getBrand() {
			return brand;
		}
		public String getModel() {
			return model;
		}
		public    int getProductionYear() {
			return productionYear;
		}
		public double getMileage() {
			return mileage;
		}
		public    int getPower() {
			return power;
		}
		public double getEngineCapacity() {
			return engineCapacity;
		}
		public double getWeight() {
			return weight;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public void setProductionYear(int productionYear) {
			this.productionYear = productionYear;
		}
		public void setMileage(double mileage) {
			this.mileage = mileage;
		}
		public void setPower(int power) {
			this.power = power;
		}
		public void setEngineCapacity(double engineCapacity) {
			this.engineCapacity = engineCapacity;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		
	
}
