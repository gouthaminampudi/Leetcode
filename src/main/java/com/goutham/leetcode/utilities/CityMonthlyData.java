package com.goutham.leetcode.utilities;

public class CityMonthlyData {

	private int regionId;
	private int year;
	private int month;
	private int value;
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "CityMonthlyData [regionId=" + regionId + ", year=" + year + ", month=" + month + ", value=" + value
				+ "]";
	}
	
	
	
}
