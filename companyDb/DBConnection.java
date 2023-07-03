package com.monocept.companyDb;

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
	
	public static DBConnection getObject() {
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
			//System.out.println("Connection established successfully");
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void createComapanyDatabase() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate("CREATE DATABASE COMPANY");
			System.out.println("Database created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createDepartmentTable() {
		try {
			statement = connection.createStatement();
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
			statement = connection.createStatement();
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
	
	public void insertIntoDepartment(int deptNo,String deptName,String location) {
		
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO DEPT VALUES(?,?,?)");
			preparedStatement.setInt(1, deptNo);
			preparedStatement.setString(2, deptName);
			preparedStatement.setString(3,location);
			preparedStatement.executeUpdate();
			System.out.println("Values inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertIntoEmployee(int empNo, String empName, String job, String mgr, String date, double sal,
			String comm, int deptNo) {

		try {
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
			
			preparedStatement.setInt(8, deptNo);
			preparedStatement.executeUpdate();
			System.out.println("Values inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void displayEmployeesOfDepartment(String department) {
		try {
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
			System.out.println("Values updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertEmployeeIntoAccountingDepartment(int empNo, String empName, String job, String mgr, String date, double sal,
			String comm) {

		try {
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
			
			preparedStatement.setInt(8, 10);
			preparedStatement.executeUpdate();
			System.out.println("Values inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteEmployeeFromSalary(double salary) {
		try {
			preparedStatement = 
					connection.prepareStatement("DELETE FROM EMP WHERE SAL<"+ salary+";");
			preparedStatement.executeUpdate();
			System.out.println("Values deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void displayAllEmployees() {
		try {
			statement = connection.createStatement();
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
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM DEPT;");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) +"\t" + resultSet.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	

}
