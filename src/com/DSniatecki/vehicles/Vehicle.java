package com.DSniatecki.vehicles;

import com.DSniatecki.tools.MyScan;
import java.util.Scanner;

public class Vehicle {
	 
		private String ID;
		
		private String brand;
		private String model;
		private int productionYear;
		private double mileage;
		private int power;
		private double engineCapacity;
		private double weight;
		
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
			System.out.println("[ "+ ID + " ][ " + brand +" " + model +" ]");
			System.out.println(" - year of production         : "+ productionYear);
			System.out.println(" - mileage                    : "+ mileage + " km ");
			System.out.println(" - power                      : " + power + " hp");	
			System.out.println(" - power per ton              : " + (Math.round((double)(power / weight )*1000.0)/1000.0) + " hp/ton");
			System.out.println(" - engine Capacity            : "+ engineCapacity + " cm^3");
			System.out.println(" - weight                     : "+ weight + " kg ");

		}
		
		public void setInfo(Scanner input) {
			System.out.println(" Podaj ponizsze dane dotyczace tego pojazdu : ");
			System.out.print(" - marka                      : ");
			brand           = input.nextLine();
			System.out.print(" - model                      : ");
			model           = input.nextLine();
			productionYear = MyScan.scanInt(input," - year of production         : ");
			mileage        = MyScan.scanDouble(input," - mileage                    : ");
			power          = MyScan.scanInt(input," - moc silnika [km]           : ");
			engineCapacity = MyScan.scanDouble(input," - pojemnosc silnika [cm^3]   : ");
			weight         = MyScan.scanDouble(input," - waga [kg]                  : ");
		}
		
		public int getPower() {
			return power;
		}
		public void setPower(int power) {
			this.power = power;
		}
		public double getEngineCapacity() {
			return engineCapacity;
		}
		public void setEngineCapacity(double engineCapacity) {
			this.engineCapacity = engineCapacity;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public void setID(String ID){
			this.ID = ID;
		}
		public String getID() {
			return this.ID;
		}
		
}
