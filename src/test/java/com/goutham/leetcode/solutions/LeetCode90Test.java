package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.goutham.leetcode.util.IntArrayParam;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LeetCode90Test {
	
	LeetCode90 leetCode90 = null;
	
	@Before
	public void setUp() throws Exception {
		leetCode90 = new LeetCode90();
	}

	@Test
	@Parameters({
        "1;2;2|6",
        "1;2;3;4|11",
        "1;2;3;4;5|16"
	})
	public void testSubsetsWithDup(@IntArrayParam final int[] nums,int expectedVal) throws Exception {
		 List<List<Integer>> list = leetCode90.subsetsWithDup(nums);
		 
		 assertThat(list.size()).isEqualTo(expectedVal);
	}

}
