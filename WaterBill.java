package com.monocept.controlstructures;

import java.util.Scanner;

public class WaterBill {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		final int meter_charge = 75;
		int total_bill;
		int no_of_units;
		int charge;
		
		System.out.println("Enter number of units consumed");
		no_of_units = scanner.nextInt();
		
		if(no_of_units <= 100)
			charge = no_of_units * 5;
		
		else if(no_of_units > 100 && no_of_units <= 250)
			charge = no_of_units * 10;
		
		else
			charge = no_of_units * 20;
		
		total_bill = meter_charge + charge;
		
		System.out.println("Total Water Bill = " + total_bill);
		
		scanner.close();

	}

}
