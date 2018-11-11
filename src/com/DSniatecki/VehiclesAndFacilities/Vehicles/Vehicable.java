package com.DSniatecki.VehiclesAndFacilities.Vehicles;

import java.io.IOException;
import java.util.Scanner;

public interface Vehicable {
	void showInfo(int vehicleNumber);
	void setInfo( Scanner input);
	void setID(String iD);
	void editInfo(Scanner input);
	void sendToTheFile() throws IOException;
}

