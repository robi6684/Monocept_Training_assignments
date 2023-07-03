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
			//choice = scanner.nextInt();
			choice = Integer.parseInt(bufferedReader.readLine());
			switch(choice) {
			case 1: 
				System.out.println("Enter department number");
				int deptNo = Integer.parseInt(bufferedReader.readLine());
				
				System.out.println("Enter department name");
				String deptName = bufferedReader.readLine();
				
				System.out.println("Enter department location");
				String location = bufferedReader.readLine();
				dbConnection.insertIntoDepartment(deptNo,deptName,location);
				break;
			case 2:
				System.out.println("Enter employee number");
				int empNo = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter employee name");
				String empName = bufferedReader.readLine();
				System.out.println("Enter job");
				String job = bufferedReader.readLine();
				System.out.println("Enter manager");
				String mgr = bufferedReader.readLine();
				System.out.println("Enter hire date in (YYYY/MM/DD)");
				String date = bufferedReader.readLine();
				System.out.println("Enter salary");
				double sal = Double.parseDouble(bufferedReader.readLine());
				System.out.println("Enter commission");
				String comm = bufferedReader.readLine();
				System.out.println("Enter department number");
				int deptno = Integer.parseInt(bufferedReader.readLine());
				dbConnection.insertIntoEmployee(empNo,empName,job,mgr,date,sal,comm,deptno);
				break;
			case 3:
				System.out.println("Enter department");
				String department = bufferedReader.readLine();
				dbConnection.displayEmployeesOfDepartment(department);
				break;
			case 4:
				dbConnection.increaseCommission();
				break;
			case 5:
				System.out.println("Enter employee number");
				int empno = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter employee name");
				String empname = bufferedReader.readLine();
				System.out.println("Enter job");
				String jobs = bufferedReader.readLine();
				System.out.println("Enter manager");
				String manager = bufferedReader.readLine();
				System.out.println("Enter hire date in (YYYY/MM/DD)");
				String hireDate = bufferedReader.readLine();
				System.out.println("Enter salary");
				double salaries = Double.parseDouble(bufferedReader.readLine());
				System.out.println("Enter commission");
				String commission = bufferedReader.readLine();
				dbConnection.insertEmployeeIntoAccountingDepartment(empno,empname,jobs,manager,hireDate,salaries,commission);
				break;
			case 6:
				System.out.println("Enter salary");
				double salary = Double.parseDouble(bufferedReader.readLine());
				dbConnection.deleteEmployeeFromSalary(salary);
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
		//scanner.close();
		//dbConnection.insertIntoDepartment();
		//dbConnection.deleteFromDepartment("Delete from DEPT where DEPTNO = 30");
		//dbConnection.updateDepartment("update DEPT set DNAME = 'ACCOUNTING' where DEPTNO = 10");
		//dbConnection.insertIntoEmployee();
		//dbConnection.displayEmployeesOfDepartment("ACCOUNTING");
		//dbConnection.increaseCommission();
		//dbConnection.deleteEmployeeFromSalary(5000); 
		//dbConnection.displayAllEmployees();
		//dbConnection.displayAlldDepartments();
		//dbConnection.insertEmployeeIntoAccountingDepartment();
}
}
