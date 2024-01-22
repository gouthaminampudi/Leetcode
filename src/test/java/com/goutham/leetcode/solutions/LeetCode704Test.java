package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LeetCode704Test {


	LeetCode704 lc704=null;
	@Before
	public void setUp() throws Exception {
		lc704 = new LeetCode704();
	}
	
	@Test
	public void testSearch() {
		int[] nums = {-1,0,3,5,9,12};
		int val = lc704.search(nums, 9);
		assertThat(val).isEqualTo(4);
	}

}
