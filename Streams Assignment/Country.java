package com.monocept.streamassignment;

public class Country {
	
	private String abbreviation;
	private String country;
	private int regionId;
	public Country() {
		super();
	}
	public Country(String abbreviation, String country, int regionId) {
		super();
		this.abbreviation = abbreviation;
		this.country = country;
		this.regionId = regionId;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	@Override
	public String toString() {
		return "[abbreviation=" + abbreviation + ", country=" + country + ", regionId=" + regionId + "]";
	}
	
	
}
