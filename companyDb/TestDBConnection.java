package com.monocept.companyDb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestDBConnection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		DBConnection dbConnection = DBConnection.getObject();
		
		dbConnection.connect();
		//dbConnection.createComapanyDatabase();
		//dbConnection.createDepartmentTable();
		//dbConnection.createEmployeeTable();
		BufferedReader bufferedReader= new BufferedReader(
	            new InputStreamReader(System.in));
		int choice;
		while(true) {
			System.out.println("1. Insert records into department table");
			System.out.println("2. Insert records into employee table");
			System.out.println("3. Display employee from department");
			System.out.println("4. Update commission of employees");
			System.out.println("5. Insert new employee in accounting department");
			System.out.println("6. Delete employees from salary");
			System.out.println("7. Display all departments");
			System.out.println("8. Display all employees");
			System.out.println("9. Exit");
			System.out.println("Enter choice");
			choice = Integer.parseInt(bufferedReader.readLine());
			switch(choice) {
			case 1: 
				dbConnection.insertIntoDepartment();
				break;
			case 2:
				dbConnection.insertIntoEmployee();
				break;
			case 3:
				dbConnection.displayEmployeesOfDepartment();
				break;
			case 4:
				dbConnection.increaseCommission();
				break;
			case 5:
				dbConnection.insertEmployeeIntoAccountingDepartment();
				break;
			case 6:
				
				dbConnection.deleteEmployeeFromSalary();
				break;
			case 7:
				dbConnection.displayAlldDepartments();
				break;
			case 8:
				dbConnection.displayAllEmployees();
				break;
			case 9:
				System.exit(0);
			default :
				System.exit(0);
			}
			
		}
	}
}
