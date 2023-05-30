package com.monocept.enums;

import java.util.Scanner;
import java.util.regex.Pattern;


public class TestCustomers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int number = 10;
		
		Customers[] customers = new Customers[number];
		
		readInput(customers,scanner,number);
		
		sortCustomers(customers,number);
		
		displayDetails(customers,number);
		
		
		scanner.close();

	}
	

	private static void readInput(Customers[] customers, Scanner scanner, int number) {
		
		 for(int i=0; i<number; i++) {
			System.out.println("Enter Customer-" + (i+1) + " Details");
			 
				
			System.out.println("Enter ID");
			int custid = scanner.nextInt();
			
			scanner.nextLine();
			
			System.out.println("Enter Name");
			String name = scanner.nextLine();
			
			System.out.println("Enter Email");
			String email = scanner.nextLine();
			
			while(!isValidEmail(email))
			{
				System.out.println("Invalid Email. Enter again");
				email = scanner.nextLine();
			}
		
			
			System.out.println("Enter Password");
			String password = scanner.nextLine();
			
			customers[i] = new Customers(custid,name,email,password);
			System.out.println("");
		 }
		
	}
	
	private static void sortCustomers(Customers[] customers, int number) {
		
		//Arrays.sort(customers, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
	        
	        for (int i = 0; i < number - 1; i++) {
	        	swapCustomers(customers,number,i);
	        }
	}
	
	private static void swapCustomers(Customers[] customers, int number, int i) {
		
		Customers temp;
		for (int j = 0; j < number - i - 1; j++) {
            if (((boolean) (customers[j].getName().compareToIgnoreCase(customers[j + 1].getName()) > 0))) {
                temp = customers[j];
                customers[j] = customers[j + 1];
                customers[j + 1] = temp;
            }
        }
	}
	
	 private static void displayDetails(Customers[] customers, int number) {
			
		 for(int i=0; i<number; i++) {
			 System.out.println("");
			 System.out.println("Customer-" + (i+1) + " Details");
			 System.out.println(customers[i]);
		 }
			
		}

	public static boolean isValidEmail(String email)
	    {
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                            "[a-zA-Z0-9_+&*-]+)*@" +
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                            "A-Z]{2,7}$";
	                              
	        Pattern pat = Pattern.compile(emailRegex);
	        if (email == null)
	            return false;
	        return pat.matcher(email).matches();
	    }

}
