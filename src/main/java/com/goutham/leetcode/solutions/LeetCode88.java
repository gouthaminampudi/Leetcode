package com.goutham.leetcode.solutions;

public class LeetCode88 {
	
	
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	        
		 int[] splitArr = new int[m];
		 
		 for(int i=0;i<m;i++) {

				 splitArr[i] = nums1[i];
		 }
		 
		 merge(nums1, splitArr, nums2);
	    }

	private void merge(int[] nums1, int[] splitArr, int[] nums2) {
		
		int splitarrLength = splitArr.length;
		int nums2Length = nums2.length;

		
		int i=0,j=0,k=0;
		
		while(i<splitarrLength && j<nums2Length) {
			
			if(splitArr[i]<nums2[j]) {
				nums1[k] = splitArr[i];
				i++;
			}else {
				nums1[k] = nums2[j];
				j++;
			}
			k++;
		}
		
		while(i<splitarrLength) {
			nums1[k] = splitArr[i];
			i++;
			k++;
		}
		
		while(j<nums2Length) {
			nums1[k] = nums2[j];
			j++;
			k++;
		}
		
	}	
	

}
