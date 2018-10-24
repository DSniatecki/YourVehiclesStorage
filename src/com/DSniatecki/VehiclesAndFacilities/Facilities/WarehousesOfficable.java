package com.DSniatecki.VehiclesAndFacilities.Facilities;

import java.util.Scanner;

public interface WarehousesOfficable {
	void execute(Scanner input);
	void readFromFile(String fileLocation);
	void savetoFile(String fileLocation);
}
