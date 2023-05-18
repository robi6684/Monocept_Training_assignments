package com.monocept.controlstructures;

import java.util.Scanner;

public class RideBillCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int total_bill = 0;
		
		System.out.println("Enter the height");
		int height = scanner.nextInt();
		
		if(height <= 120)
		{
			System.out.println("Can't Ride, height is less");
			System.exit(0);
		}
			
		
		System.out.println("Enter the age");
		int age = scanner.nextInt();
		
		if(age < 12)
			total_bill += 5;
		
		else if(age < 18)
			total_bill += 7;
		
		else if(age < 45)
			total_bill += 12;
		
		else if(age <= 55)
			total_bill += 0;
		
		else
		{
			System.out.println("Can't Ride, age limit exceeded");
			System.exit(0);
		}
		
		System.out.println("Want photos? (Yes or No)");
		String answer = scanner.next();
		
		if(answer.equals("Yes"))
			total_bill += 3;
				
			
		System.out.println("Total ride bill is : $" + total_bill);
		
		scanner.close();

	}

}
