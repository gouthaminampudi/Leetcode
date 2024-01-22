package com.goutham.leetcode.solutions;

public class LeetCode5 {

	
	 public String longestPalindrome(String s) {
		 
		 if(s.length()==1 ||isPalindrome(s) ) {
			 return s;
		 }
		 int[] currentLongestPalindrome= {0,0};
		 int curLength=0;
	        
	        for(int i=0;i<s.length();i++) {
	        	 for(int x=i;x<=s.length();x++) {
	        		 String sub = s.substring(i, x);
	 	        	if(isPalindrome(sub) && x-i>curLength ) {
	 	        		currentLongestPalindrome[0]=i;
	 	        		currentLongestPalindrome[1]=x;
	 	        		curLength =x-i;
	 	        		
	 	        	}
	 	        	
	 	        }
	        	
	        }
	        
	        
	        return s.substring(currentLongestPalindrome[0],currentLongestPalindrome[1]);
		 
	    }
	
	
	public boolean isPalindrome(String s) {

		
		int charLen = s.length() - 1;
		int strlen = s.length() / 2;

		for (int i = 0; i < strlen;i++) {

			if (s.charAt(i) != s.charAt(charLen - i)) {
				return false;
			}
		}

		return true;
		 
	}
	
	public String longestPalindrome1(String s) {
		 
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		int maxLength = 0;
		int start = 0;

		for(int i= 0; i < s.length(); i++) {
			for(int j= 0; j< s.length() - i; j++) {
				if(s.charAt(j) == s.charAt(j+i) && ((i <= 1) || (dp[j+1][j+i-1]))) {
					dp[j][j+i]= true;
					if(i + 1 > maxLength) {
						maxLength = i+1;
						start = j;
					}
				}
			}
		}
		return s.substring(start, start+maxLength);
			 
		    }
	
	
}
