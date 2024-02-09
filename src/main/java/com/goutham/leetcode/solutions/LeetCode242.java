package com.goutham.leetcode.solutions;

import java.util.Arrays;

public class LeetCode242 {
	  public boolean isAnagram(String s, String t) {
		  
		/*  if(s.length()!=t.length()) {
			  return false;
		  }
		  char[] sArr = s.toCharArray();
		  char[] tArr = t.toCharArray();
		  
		  Arrays.sort(sArr);
		  Arrays.sort(tArr);
		  
		  for(int i=0;i<sArr.length;i++) {
			  if(tArr[i]!=sArr[i]) {
				  return false;
			  }
		  }
	        return true;
	    */
		  
		  
		  int[] fs = new int[26]; // create two empty arrays count number of offset for each char in the string array (from letter 'a')
		  int[] ft = new int[26];
	        for(char c: s.toCharArray()){
	            fs[c-'a']++; //any char inside of s.toCharArray() count++
	        }
	        for(char c: t.toCharArray()){ //same here
	            ft[c-'a']++;
	        }
	        for(int i = 0; i < 26; i++){ //compare the two arrays char by char if any not equal -> false
	            if(fs[i] != ft[i])
	                return false;
	        }
	        System.out.println('b'-'a');
	        return true;
	  }

}
