package com.monocept.inheritance;

import java.util.Scanner;

public class TestVehicle {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of cars");
		int number = Integer.parseInt(scanner.nextLine());
		
		Car[] car = new Car[number];
		
		for(int i=0; i<number; i++) {
			
			car[i] = new Car();
			System.out.println("Enter details of car "+ (i+1));
			
			System.out.println("Enter company name");
			String companyName = scanner.nextLine();
			car[i].acceptCompanyName(companyName);
			
			System.out.println("Enter mileage");
			double mileage = Double.parseDouble(scanner.nextLine());
			car[i].acceptMileage(mileage);
			
			System.out.println("Enter price");
			double price = Double.parseDouble(scanner.nextLine());
			car[i].acceptPrice(price);
		}
		
		
		for(int i=0; i<number; i++) {
			System.out.println("");
			System.out.println("Car " + (i+1) + " Details");
			System.out.println(car[i]);
		}
		
		scanner.close();
		

	}

}
