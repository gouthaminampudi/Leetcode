package com.goutham.leetcode.solutions;

public class LeetCode189 {

	 public void rotate(int[] nums, int k) {
		 
		 int arrlength = nums.length;
		 k %= nums.length;

		 reverse(nums, 0, arrlength-1);
		 reverse(nums, 0, k-1);
		 reverse(nums, k, arrlength-1);
				 
	    }

	private void reverse(int[] nums, int start, int end) {
		
	
		while(start<end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
		start++;
		end--;
		}

	}
	 
}
