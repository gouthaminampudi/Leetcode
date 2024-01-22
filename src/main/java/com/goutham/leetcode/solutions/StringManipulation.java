package com.goutham.leetcode.solutions;

public class StringManipulation {

	public String replaceString(String str) {
		String[] arr = str.split("\"");
		StringBuffer strBuff = new StringBuffer("");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains("$")) {
				String[] ass = arr[i].replace("$", ";").split(";");
				String rt = "";
				for (int x = 0; x < ass.length; x++) {

					if (ass[x].matches("((?<!^,)\\d+(,|(\\.(?=\\d+$))(?!$)|$))+")) {
						ass[x] = ass[x].replace(",", "");
					}
					rt = rt + ass[x];
				}
				arr[i] = rt;
			}
			strBuff.append(arr[i]);
		}
		return strBuff.toString();
	}
}
