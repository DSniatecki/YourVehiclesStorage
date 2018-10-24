package com.DSniatecki.VehiclesAndFacilities.Facilities;

import java.util.Scanner;

public interface VehicleWarehousable {
	void showInfo(int storageNumber);
	void setInfo(Scanner input);
	void execute(Scanner input,int storageNumber);
	void showAllVehicles(Scanner input);
	void editInfo(Scanner input);
	long getTotalPower();
	long getTotalMileage();
	long getTotalWeight();
}
