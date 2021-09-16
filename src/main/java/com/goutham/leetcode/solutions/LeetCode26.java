package com.goutham.leetcode.solutions;
import java.util.HashSet;
import java.util.Set;

public class LeetCode26 {
	 public int removeDuplicates(int[] nums) {
		 
		 Set s = new HashSet();
		 int x=0;
		 for(int i=0;i<nums.length;i++) {
			 boolean b= s.add(nums[i]);
			 if(b) {
				 nums[x]=nums[i];
				 x++;
			 }
		 }
		 
		 
		return x;
	        
	    }
	 
	 public int removeDuplicates1(int[] nums) {
		 


		 int x=0;
		 for(int i=1;i<nums.length;i++) {
			 if(nums[x] != nums[i]) {
				 x++;
				 nums[x]=nums[i];
				
			 }
		 }
		 
		 
		return ++x;
	        
	    }

}
