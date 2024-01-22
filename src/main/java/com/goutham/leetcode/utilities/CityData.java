package com.goutham.leetcode.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
 

public class CityData {
	
	private Integer RegionID;
	private String RegionName;
	private String State;
	private String Metro;
	private String CountyName;
	private Integer SizeRank;
	//Map<year,List<Map<month,houseVal>>>
	private Map<Integer,List<Map<Integer,Integer>>> housedata;
	public CityData() {
		
	}
	
	
	public CityData(Integer regionID, String regionName, String state, String metro, String countyName,
			Integer sizeRank, Map<Integer, List<Map<Integer, Integer>>> housedata) {
		super();
		RegionID = regionID;
		RegionName = regionName;
		State = state;
		Metro = metro;
		CountyName = countyName;
		SizeRank = sizeRank;
		this.housedata = housedata;
	}
	public Integer getRegionID() {
		return RegionID;
	}
	public void setRegionID(Integer regionID) {
		RegionID = regionID;
	}
	public String getRegionName() {
		return RegionName;
	}
	public void setRegionName(String regionName) {
		RegionName = regionName;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getMetro() {
		return Metro;
	}
	public void setMetro(String metro) {
		Metro = metro;
	}
	public String getCountyName() {
		return CountyName;
	}
	public void setCountyName(String countyName) {
		CountyName = countyName;
	}
	public Integer getSizeRank() {
		return SizeRank;
	}
	public void setSizeRank(Integer sizeRank) {
		SizeRank = sizeRank;
	}
	public Map<Integer, List<Map<Integer, Integer>>> getHousedata() {
		return housedata;
	}
	public void setHousedata(Map<Integer, List<Map<Integer, Integer>>> housedata) {
		this.housedata = housedata;
	}
	
	public List<CityMonthlyData> getCityMonthlyData(){


		Map<Integer, List<Map<Integer, Integer>>> houseData = this.getHousedata();
		List<CityMonthlyData> cmdList = new ArrayList<CityMonthlyData> ();
		Set<Integer> years = houseData.keySet();
		for (Integer year : years) {
			
			List<Map<Integer, Integer>> list = houseData.get(year);
			for (Map<Integer, Integer> map : list) {
				CityMonthlyData cmd = new CityMonthlyData();
				cmd.setRegionId(getRegionID());
				
				cmd.setYear(year);
				

				Set<Entry<Integer, Integer>> entSet = map.entrySet();
				for (Entry ent : entSet) {
					cmd.setMonth(Integer.valueOf(ent.getKey().toString()));			
					cmd.setValue(Integer.valueOf(ent.getValue().toString()));

				}
				cmdList.add(cmd);
			}

		}
		return cmdList;

	
	}

}
