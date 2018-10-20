package com.DSniatecki.VehiclesAndFacilities.Facilities;

import java.util.Scanner;

public interface WarehousesOfficable {
	public void execute(Scanner input);
	public void readFromFile(String fileLocation);
	public void savetoFile(String fileLocation);
}
