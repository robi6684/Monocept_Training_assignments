package com.monocept.companyDb;

public class Employee {
	private int EMPNO;
	private String EMPNAME;
	private String JOB;
	private int MGR;
	private String HIREDATE;
	private double SAL;
	private double COMM;
	private int DEPTNO;
	
	public Employee(int eMPNO, String eMPNAME, String jOB, int mGR, String hIREDATE, double sAL, double cOMM,
			int dEPTNO) {
		EMPNO = eMPNO;
		EMPNAME = eMPNAME;
		JOB = jOB;
		MGR = mGR;
		HIREDATE = hIREDATE;
		SAL = sAL;
		COMM = cOMM;
		DEPTNO = dEPTNO;
	}

	public int getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(int eMPNO) {
		EMPNO = eMPNO;
	}

	public String getEMPNAME() {
		return EMPNAME;
	}

	public void setEMPNAME(String eMPNAME) {
		EMPNAME = eMPNAME;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String jOB) {
		JOB = jOB;
	}

	public int getMGR() {
		return MGR;
	}

	public void setMGR(int mGR) {
		MGR = mGR;
	}

	public String getHIREDATE() {
		return HIREDATE;
	}

	public void setHIREDATE(String hIREDATE) {
		HIREDATE = hIREDATE;
	}

	public double getSAL() {
		return SAL;
	}

	public void setSAL(double sAL) {
		SAL = sAL;
	}

	public double getCOMM() {
		return COMM;
	}

	public void setCOMM(double cOMM) {
		COMM = cOMM;
	}

	public int getDEPTNO() {
		return DEPTNO;
	}

	public void setDEPTNO(int dEPTNO) {
		DEPTNO = dEPTNO;
	}
	
	
	

}
