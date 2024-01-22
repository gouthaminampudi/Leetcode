package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LeetCode11Test {

LeetCode11 leetCode11 = null;
	
	@Before
	public void setUp() throws Exception {
		leetCode11 = new LeetCode11();
	}

	@Test
	public void testMaxArea() {
		
		int[] maxSize = {1,8,6,2,5,4,8,3,7};
		
		int max = leetCode11.maxArea1(maxSize);
		System.out.println(max);
		 assertThat(max).isEqualTo(49);
	}
	
	@Test
	public void testMaxArea2() {
		
		int[] maxSize = {2,3,4,5,18,17,6,100,100};
		
		int max = leetCode11.maxArea1(maxSize);
		System.out.println(max);
		 assertThat(max).isEqualTo(100);
	}
	
	
	@Test
	public void testMaxArea1() {
		
		int[] maxSize = {3,4};
		
		int max = leetCode11.maxArea(maxSize);
		System.out.println(max);
		 assertThat(max).isEqualTo(3);
	}
	
	@Test
	public void testMaxArea3() {
		
		int[] maxSize = {2,3,4,5,18,17,6,100,100};
		
		int max = leetCode11.maxArea2(maxSize);
		
		 assertThat(max).isEqualTo(100);
	}
	
	@Test
	public void testMaxArea4() {
		
		int[] maxSize = {1,1000,1000,6,2,5};
		
		int max = leetCode11.maxArea2(maxSize);
		
		 assertThat(max).isEqualTo(1000);
	}
}
