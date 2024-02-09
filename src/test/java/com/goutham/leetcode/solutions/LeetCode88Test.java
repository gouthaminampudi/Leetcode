package com.goutham.leetcode.solutions;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LeetCode88Test {

	LeetCode88 leetCode88;
	@Before
	public void setup() {
		leetCode88 = new LeetCode88();
	}
	
	
	@Test
	public void testMerge() {
		
		int[] nums1 = {1,2,3,0,0,0},  nums2 = {2,5,6};
		
		int m = 3, n=3;
		leetCode88.merge(nums1, m, nums2, n);
		
		assertTrue(nums1[0] == 1);
		assertTrue(nums1[1] == 2);
		assertTrue(nums1[2] == 2);
		assertTrue(nums1[3] == 3);
		assertTrue(nums1[4] == 5);
		assertTrue(nums1[5] == 6);
		
		
	}
	
	@Test
	public void testMerge2() {
		
		int[] nums1 = {-1,0,0,3,3,3,0,0,0},  nums2 = {1,2,2};
		
		int m = 6, n=3;
		leetCode88.merge(nums1, m, nums2, n);
		
		assertTrue(nums1[0] == 1);
		assertTrue(nums1[1] == 2);
		assertTrue(nums1[2] == 2);
		assertTrue(nums1[3] == 3);
		assertTrue(nums1[4] == 5);
		assertTrue(nums1[5] == 6);
		
		
	}

}
