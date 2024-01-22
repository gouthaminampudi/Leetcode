package com.goutham.leetcode.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PopulateCityData {

	public static List<CityData> populateCityData() {

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		File file = new File(classLoader.getResource("City_Zhvi_AllHomes.csv").getFile());

		Scanner input;
		CityData[] inventorys = new CityData[0];
		try {
			input = new Scanner(file);

			input.useDelimiter("\n");

			input.next();

			// System.out.println(test);

			while (input.hasNext()) {

				String tok = input.next();
				// System.out.println(tok);
				String[] tokens = tok.split(",");

				int startYear = 1996;

				Integer regionID = Integer.valueOf(tokens[0]);
				String regionName = tokens[1];
				String state = tokens[2];
				String metro = tokens[3];
				String countyName = tokens[4];

				Integer sizeRank = Integer.valueOf(tokens[5]);
				Map<Integer, List<Map<Integer, Integer>>> housedata = new HashMap();
				List<Map<Integer, Integer>> m = new ArrayList<Map<Integer, Integer>>();
				// System.out.println(tokens.length);

				int j = 1;

				for (int i = 1; i <= 253; i++) {

					if (j == 13) {
						housedata.put(startYear, m);
						j = 1;
						startYear++;
						m = new ArrayList<Map<Integer, Integer>>();
					}
					if (i == 253) {
						break;
					}

					Integer val = 0;
					if (!"".equalsIgnoreCase(tokens[i + 5]) && !"\r".equalsIgnoreCase(tokens[i + 5])) {
						val = Integer.valueOf(tokens[i + 5]);
					}

					Map<Integer, Integer> h = new HashMap<Integer, Integer>();
					h.put(j, val);

					m.add(h);

					j++;
				}

				CityData newInventory = new CityData(regionID, regionName, state, metro, countyName, sizeRank,
						housedata);
				inventorys = addInventory(inventorys, newInventory);

				// System.out.println(inventorys.length);

			}

			input.close();
			// return new ArrayList<Inventory>(Arrays.asList(inventorys));
		} catch (FileNotFoundException e) {
			return new ArrayList<CityData>();

		}

		return new ArrayList<CityData>(Arrays.asList(inventorys));

	}

	private static CityData[] addInventory(CityData[] inventorys, CityData inventoryToAdd) {
		CityData[] newInventorys = new CityData[inventorys.length + 1];
		System.arraycopy(inventorys, 0, newInventorys, 0, inventorys.length);
		newInventorys[newInventorys.length - 1] = inventoryToAdd;

		return newInventorys;
	}

	public static void printToCSV(List<CityData> cityDatas) {

		try (PrintWriter writer = new PrintWriter(new File("CityData.csv"))) {

			StringBuilder sb = new StringBuilder();
			sb.append("RegionID");
			sb.append(',');
			sb.append("RegionName");
			sb.append(',');
			sb.append("State");
			sb.append(',');
			sb.append("Metro");
			sb.append(',');
			sb.append("CountyName");
			sb.append(',');
			sb.append("SizeRank");
			sb.append('\n');

			for (CityData cityData : cityDatas) {
				sb.append(cityData.getRegionID());
				sb.append(',');
				sb.append(cityData.getRegionName());
				sb.append(',');
				sb.append(cityData.getState());
				sb.append(',');
				sb.append(cityData.getMetro());
				sb.append(',');
				sb.append(cityData.getCountyName());
				sb.append(',');
				sb.append(cityData.getSizeRank());
				sb.append('\n');

			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try (PrintWriter writer = new PrintWriter(new File("CityMonthlyValue.csv"))) {

			StringBuilder sb = new StringBuilder();
			sb.append("RegionID");
			sb.append(',');
			sb.append("year");
			sb.append(',');
			sb.append("month");
			sb.append(',');
			sb.append("value");
			sb.append('\n');

			int i = 0;
			for (CityData cityData : cityDatas) {

				Map<Integer, List<Map<Integer, Integer>>> houseData = cityData.getHousedata();
				Set<Integer> years = houseData.keySet();
				for (Integer year : years) {
					List<Map<Integer, Integer>> list = houseData.get(year);
					for (Map<Integer, Integer> map : list) {
						sb.append(cityData.getRegionID());
						sb.append(',');
						sb.append(year);
						sb.append(',');

						Set<Entry<Integer, Integer>> entSet = map.entrySet();
						for (Entry ent : entSet) {
							sb.append(ent.getKey());
							sb.append(',');
							sb.append(ent.getValue());
							sb.append('\n');
							i++;
						}

					}

				}

			}

			writer.write(sb.toString());

			System.out.println("done! ->" + i);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void getCityData() {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		File file = new File(classLoader.getResource("test4.csv").getFile());

		List<CityMonthlyData> inputList = new ArrayList<CityMonthlyData>();
		try {

			InputStream inputFS = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			// skip the header of the csv
			inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (Exception e) {

		}
		System.out.println(inputList.size());
	}

	private static Function<String, CityMonthlyData> mapToItem = (line) -> {
		String[] p = line.split(",");// a CSV has comma separated lines
		CityMonthlyData item = new CityMonthlyData();
		item.setRegionId(Integer.valueOf(p[0]));// <-- this is the first column in the csv file
		item.setYear(Integer.valueOf(p[1]));
		item.setMonth(Integer.valueOf(p[2]));
		item.setValue(Integer.valueOf(p[3]));

		return item;
	};
	
	public static void loadCityDataToDB(List<CityData> cityDatas) {
	      try {
			Class.forName("org.sqlite.JDBC");

	        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
	        Statement stat = conn.createStatement();
	        stat.executeUpdate("drop table if exists city_data;");
	        
	        StringBuffer sb = new StringBuffer();
	        sb.append("create table city_data(\n");
			sb.append("RegionID");
			sb.append(',');
			sb.append("RegionName");
			sb.append(',');
			sb.append("State");
			sb.append(',');
			sb.append("Metro");
			sb.append(',');
			sb.append("CountyName");
			sb.append(',');
			sb.append("SizeRank");
			sb.append('\n');
	        sb.append(")");
	        conn.createStatement().execute(sb.toString());
	        
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static String formatDuration(Duration duration) {
		long seconds = duration.getSeconds();
		long absSeconds = Math.abs(seconds);
		String positive = String.format("%d:%02d:%02d", absSeconds / 3600, (absSeconds % 3600) / 60, absSeconds % 60);
		return seconds < 0 ? "-" + positive : positive;
	}

}
