package com.goutham.leetcode.solutions;

public class LeetCode14 {
	
	  public String longestCommonPrefix(String[] strs) {
		  

	/*	  String sub="";

		  for (int x=1;x<=strs[0].length();x++) {
			  String sub1 =strs[0].substring(0,x);
			  boolean match = true;
			  for(int y=1;y<strs.length;y++) {

				  if(!strs[y].startsWith(sub1)) {
					  return sub;
				  }
			  }
			  if(match) {
				  sub = strs[0].substring(0,x);
			  }
			  
		  }
		return sub;*/
		  
		  if (strs.length == 0) return "";
		    String prefix = strs[0];
		    for (int i = 1; i < strs.length; i++)
		        while (strs[i].indexOf(prefix) != 0) {
		            prefix = prefix.substring(0, prefix.length() - 1);
		            if (prefix.isEmpty()) return "";
		        }        
		    return prefix;
	        
	    }
	  

}
