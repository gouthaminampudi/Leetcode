package com.goutham.leetcode.solutions;

public class LeetCode7 {
	 public int reverse(int x) {
		 
		 boolean isnegative = false;
		 if(x<10 && x>-10) {
			 return x;
		 }
		 
		 System.out.println(Integer.MIN_VALUE );
		 System.out.println(Integer.MAX_VALUE );
		 if(x<=Integer.MIN_VALUE || x>=Integer.MAX_VALUE) {
			 return 0;
		 }
		 
		 if(x<0) {
			 isnegative = true;
			 x= x*-1;
		 }
		 
		 int quotient = x/10;
		 int rem = x%10;
		 Integer count =0;
		 count = (count+ rem)*10;
		 while(quotient>9) {
				 rem = quotient%10;
				 quotient = quotient/10;
				 
				 if(count+rem > Integer.MAX_VALUE/10 || count+rem < Integer.MIN_VALUE/10){
		             return 0;
		         }
				 
				 count = (count+ rem)*10;
		 }
		 count = (count+ quotient);
		 
		 if(count > Integer.MAX_VALUE || count < Integer.MIN_VALUE){
             return 0;
         }

		 if(isnegative){
			 count = count *-1;
		 }
		return count;
	        
	    }

}
