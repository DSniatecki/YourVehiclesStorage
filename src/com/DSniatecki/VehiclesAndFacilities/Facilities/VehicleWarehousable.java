package com.DSniatecki.VehiclesAndFacilities.Facilities;

import java.util.Scanner;

public interface VehicleWarehousable {
	void showInfo(int storageNumber);
	void setInfo(Scanner input);
	void execute(Scanner input,int storageNumber);
	void showAllVehicles(Scanner input);
	void editInfo(Scanner input);
	public long getTotalPower();
	public long getTotalMileage();
	public long getTotalWeight();
}
