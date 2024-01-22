package com.goutham.leetcode.solutions;

import java.util.Arrays;

public class LeetCode704 {
	public int search(int[] nums, int target) {
		int start =0;
		return searchAgain(start,nums, target);
	}


	
	private int searchAgain(int start,int[] nums, int target) {
		int pivot = nums.length/2;
		
		int end =-1;

		if(target ==nums[pivot]) {
			return pivot;
		}else if(target >nums[pivot]) {
			
			start=pivot;
			end = nums.length;
		}else if(target <nums[pivot]) {
			start=0;
			end =pivot;
	//		end =search(Arrays.copyOfRange(nums, 0,pivot), target);
		}
		
		for(int x =start;x<end;x++) {
			if(target==nums[x]) {
				return x;
			}
		}
	return end;
	}

}

