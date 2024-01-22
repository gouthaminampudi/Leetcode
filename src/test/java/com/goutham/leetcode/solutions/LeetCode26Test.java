package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.goutham.leetcode.util.IntArrayParam;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LeetCode26Test {

	LeetCode26 leetCode26=null;
	@Before
	public void setUp() throws Exception {
		leetCode26=new LeetCode26();
	}

	@Test
	@Parameters({
        "1;2;2|2",
        "1;2;3;4|4",
        "1;2;2;3;5|4"
	})
	public void testRemoveDuplicates(@IntArrayParam final int[] nums,int expectedVal) throws Exception {
		int val = leetCode26.removeDuplicates(nums);
		 assertThat(val).isEqualTo(expectedVal);
	}

	@Test
	@Parameters({
        "1;1;2|2",
        "1;2;3;4|4",
        "1;2;2;3;5|4"
	})
	public void testRemoveDuplicates1(@IntArrayParam final int[] nums,int expectedVal) throws Exception {
		int val = leetCode26.removeDuplicates1(nums);
		 assertThat(val).isEqualTo(expectedVal);
	}

}
