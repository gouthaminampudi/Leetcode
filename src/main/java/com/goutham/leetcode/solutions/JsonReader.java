package com.goutham.leetcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class JsonReader {
	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		
		
		
		File file = new File(classLoader.getResource("city.json").getFile());
		Scanner myJson;
		List<JSONObject> list = new ArrayList<JSONObject>();
		int i =0;
		try {
			myJson = new Scanner(file);
			while(myJson.hasNextLine()) {
				String xyz = myJson.nextLine();
		
//				if(i<10) {
//					System.out.println(xyz);
//				}
				//if(xyz.startsWith("{")) {
					JSONObject myJsonobject = new JSONObject(xyz);
					list.add(myJsonobject);	
				//}

				i++;
			}
			
			
//			System.out.println("Tests");
//			System.out.println(list.size());
			JSONObject j = list.get(0);
			System.out.println(((JSONObject)j.get("properties")).get("street"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
