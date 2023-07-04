package com.monocept.companyDb;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBConnection {
	
	private static DBConnection dbConnection = null;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	private DBConnection() {
		
	}
	
	public static DBConnection getDBConnectionObject() {
		if(dbConnection == null)
			dbConnection = new DBConnection();
		return dbConnection;
	}
	
	public void connect() {
		try {
			//Registering the drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establishing connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Saraswati@123");
			statement = connection.createStatement();
			//System.out.println("Connection established successfully");
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void createComapanyDatabase() {
		try {
			statement.executeUpdate("CREATE DATABASE COMPANY");
			System.out.println("Database created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createDepartmentTable() {
		try {
			statement.executeUpdate("USE COMPANY");
			statement.executeUpdate("CREATE TABLE DEPT ("
					+ " DEPTNO integer NOT NULL,"
					+ " DNAME varchar(14),"
					+ " LOC varchar(13),"
					+ " CONSTRAINT DEPT_PRIMARY_KEY PRIMARY KEY (DEPTNO));");
			System.out.println("Department Table created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createEmployeeTable() {
		try {
			statement.executeUpdate("USE COMPANY");
			statement.executeUpdate(" CREATE TABLE EMP ("
					+ " EMPNO               integer NOT NULL,"
					+ " ENAME               varchar(10),"
					+ " JOB                 varchar(9),"
					+ " MGR                 integer,"
					+ " HIREDATE            DATEtime,"
					+ " SAL                 DECIMAL(10,2),"
					+ " COMM                DECIMAL(10,2),"
					+ " DEPTNO              integer NOT NULL,"
					+ " CONSTRAINT EMP_FOREIGN_KEY FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO),"
					+ " CONSTRAINT EMP_PRIMARY_KEY PRIMARY KEY (EMPNO));");
			System.out.println("Employee Table created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void insertIntoDepartment(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		
		try {
			System.out.println("Enter department number");
			int deptNo = Integer.parseInt(bufferedReader.readLine());
			
			System.out.println("Enter department name");
			String deptName = bufferedReader.readLine();
			
			System.out.println("Enter department location");
			String location = bufferedReader.readLine();
			preparedStatement = connection.prepareStatement("INSERT INTO DEPT VALUES(?,?,?)");
			preparedStatement.setInt(1, deptNo);
			preparedStatement.setString(2, deptName);
			preparedStatement.setString(3,location);
			preparedStatement.executeUpdate();
			System.out.println("New department added successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertIntoEmployee(BufferedReader bufferedReader) throws NumberFormatException, IOException {

		try {
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
			preparedStatement = connection.prepareStatement("INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, empNo);
			preparedStatement.setString(2, empName);
			preparedStatement.setString(3, job);

			if(mgr.equals("NULL"))
				preparedStatement.setNull(4, Types.NULL);
			else {
				int value = Integer.parseInt(mgr);
				preparedStatement.setInt(4, value);
			}
	
			preparedStatement.setString(5, date);
			preparedStatement.setDouble(6, sal);
			
			if(comm.equals("NULL"))
				preparedStatement.setNull(7, Types.NULL);
			else {
				double commission = Double.parseDouble(comm);
				preparedStatement.setDouble(7, commission);
			}
			
			preparedStatement.setInt(8, deptno);
			preparedStatement.executeUpdate();
			System.out.println("New employee added successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void displayEmployeesOfDepartment(BufferedReader bufferedReader) throws IOException {
		try {
			System.out.println("Enter department");
			String department = bufferedReader.readLine();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT EMP.* FROM EMP INNER JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO "
					+ "WHERE DEPT.DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = " + "'"+department+"');");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) +"\t" + resultSet.getString(3)
				+"\t" + resultSet.getInt(4) + "\t" + resultSet.getString(5) + "\t" + resultSet.getDouble(6)
				+"\t" + resultSet.getDouble(7) + "\t" + resultSet.getInt(8));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void increaseCommission() {
		try {
			preparedStatement = 
					connection.prepareStatement("UPDATE EMP SET COMM = 0.2*IFNULL(COMM,0) + IFNULL(COMM,0);");
			preparedStatement.executeUpdate();
			System.out.println("Commission of each employee increased by 20%");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertEmployeeIntoAccountingDepartment(BufferedReader bufferedReader) throws NumberFormatException, IOException {

		try {
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
			preparedStatement = connection.prepareStatement("INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, empno);
			preparedStatement.setString(2, empname);
			preparedStatement.setString(3, jobs);
			if(manager.equals("NULL"))
				preparedStatement.setNull(4, Types.NULL);
			else {
				int value = Integer.parseInt(manager);
				preparedStatement.setInt(4, value);
			}

			preparedStatement.setString(5, hireDate);
			preparedStatement.setDouble(6, salaries);
			if(commission.equals("NULL"))
				preparedStatement.setNull(7, Types.NULL);
			else {
				double comm = Double.parseDouble(commission);
				preparedStatement.setDouble(7, comm);
			}
			
			preparedStatement.setInt(8, 10);
			preparedStatement.executeUpdate();
			System.out.println("New Employee into Accounting department added");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteEmployeeBySalary(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		try {
			System.out.println("Enter salary");
			double salary = Double.parseDouble(bufferedReader.readLine());
			preparedStatement = 
					connection.prepareStatement("DELETE FROM EMP WHERE SAL<"+ salary+";");
			preparedStatement.executeUpdate();
			System.out.println("Records having salary less than " + salary + " deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void displayAllEmployees() {
		try {
			resultSet = statement.executeQuery("SELECT * FROM EMP;");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) +"\t" + resultSet.getString(3)
				+"\t" + resultSet.getInt(4) + "\t" + resultSet.getString(5) + "\t" + resultSet.getDouble(6)
				+"\t" + resultSet.getDouble(7) + "\t" + resultSet.getInt(8));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	public void displayAlldDepartments() {
		try {
			resultSet = statement.executeQuery("SELECT * FROM DEPT;");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) +"\t" + resultSet.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	

}
