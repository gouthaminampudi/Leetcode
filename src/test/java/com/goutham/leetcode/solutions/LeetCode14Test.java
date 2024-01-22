package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.goutham.leetcode.util.IntArrayParam;
import com.goutham.leetcode.util.StringArrayParam;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LeetCode14Test {
	
	
LeetCode14 leetCode14 = null;
	
	@Before
	public void setUp() throws Exception {
		leetCode14 = new LeetCode14();
	}

	

	@Test
	@Parameters({
        "flower;flow;flight|fl",
        "dog;racecar;car|",
        "|"
	})
	
	public void testLongestCommonPrefix(@StringArrayParam final String[] strs,String expectedVal) {
		
		String common = leetCode14.longestCommonPrefix(strs);
		 assertThat(common).isEqualTo(expectedVal);
	}

}
