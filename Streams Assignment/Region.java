package com.monocept.streamassignment;

public class Region {
	
	private int regionId;
	private String region;
	public Region() {
		
	}
	public Region(int regionId, String region) {
		super();
		this.regionId = regionId;
		this.region = region;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	

}
