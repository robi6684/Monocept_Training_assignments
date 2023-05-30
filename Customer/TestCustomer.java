package com.monocept.oops1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TestCustomer {
	
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

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int custid;
		String name;
		String email;
		String password;
		
		System.out.println("Enter ID");
		custid = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter Name");
		name = scanner.nextLine();
		
		System.out.println("Enter Email");
		email = scanner.nextLine();
		
		if(!isValidEmail(email))
		{
			System.out.println("Invalid Email");
			System.exit(0);
		}
	
		
		System.out.println("Enter Password");
		password = scanner.nextLine();
		
		Customer customer1 = new Customer(custid,name,email,password);
		customer1.display();
		
		scanner.close();

	}

}
