package com.DSniatecki.tools;


import java.text.DateFormat;
import java.util.Date;

public final class MyTime {
	
	private static Date rightNow;
	private static DateFormat timeFormatter;
	private static DateFormat dateFormatter;
	
	static {   
		timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);		
		dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT); 
	} 
	
	public static void showCurrentTime(){
		rightNow = new Date();				
		System.out.println();
		System.out.println(" <>        Current time :      <>"  );
		System.out.println(" <>   "+  timeFormatter.format(rightNow) + "   " +dateFormatter.format(rightNow) + "    <>");
		
	}

}
