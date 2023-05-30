package com.monocept.inheritance;

public class Car extends FourWheeler {
	
	double price;
	
	public void acceptPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Comapny Name : " + companyName + "\t" + "Mileage : " + mileage + "\t" + "Price : $" + price;
	}

}
