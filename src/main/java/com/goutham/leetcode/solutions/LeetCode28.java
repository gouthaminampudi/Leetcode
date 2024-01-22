package com.goutham.leetcode.solutions;

public class LeetCode28 {
	
	public int strStr(String haystack, String needle) {
		
		
		char[] hayArray = haystack.toCharArray();
		char[] needleArray = needle.toCharArray();
		
		boolean firstMatch = false;
		
			
			for(int x=0;x<hayArray.length;x++) {
				
				if (hayArray.length-x<needleArray.length) {
					for (int i = 0; i < needleArray.length; i++) {
						if (firstMatch == false && needleArray[i] == hayArray[x]) {
							firstMatch = true;
						}

						if (firstMatch) {

							if (needleArray[i] == hayArray[x + i]) {
								firstMatch = true;
							} else {
								firstMatch = false;
							}
						}
						if (firstMatch && needleArray.length == i + 1) {
							return x;
						}
					} 
				}
			}
			

        
    return 0;
    
	}

}
