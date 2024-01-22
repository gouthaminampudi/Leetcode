package com.goutham.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		
		
		int len = nums.length;
		Set<List<Integer>>  list = new HashSet<List<Integer>> ();
	
		  list.add(new ArrayList());

		  	int startInt=0;
		  	while(startInt<= nums.length)		{
		  	int numOfItems =0;
			while(numOfItems<=nums.length) {
				for(int startPosition=0;startPosition<nums.length;startPosition++) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(nums[startInt]);
					getList(nums, startPosition+startInt, numOfItems,l);
					list.add(l);
					
				}
				numOfItems++;
			}
			startInt++;
		  	}
		return list.stream().collect(Collectors.toList());
		
		
	}
	

	private void getList(int[] nums, int startPosition, int numOfItems, List<Integer> l ) {

		int i=startPosition+1;
		if((numOfItems+i)<nums.length) {
			for(int x=0;x<numOfItems;x++) {
				l.add(nums[i]);
				i++;
			}
		}

	}

}
