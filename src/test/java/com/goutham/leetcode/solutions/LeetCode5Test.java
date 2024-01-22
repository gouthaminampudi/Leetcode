package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
@RunWith(JUnitParamsRunner.class)
public class LeetCode5Test {

	LeetCode5 lc5=null;
	@Before
	public void setUp() throws Exception {
		lc5 = new LeetCode5();
	}

	@Test
	@Parameters({
        "babad|bab",
        "cbbd|bb",
        "a|a",
        "ac|a",
      "bb|bb",
       "eabcb|bcb"
	})
	public void testLongestPalindrome(String val, String expectedVal) throws Exception {
		
		String valid = lc5.longestPalindrome(val);
		
		assertThat(valid).isEqualTo(expectedVal);
	}

	@Test
	@Parameters({
        "babad|bab",
        "cbbd|bb",
        "a|a",
        "ac|a",
      "bb|bb",
       "eabcb|bcb"
	})
	public void testLongestPalindrome1(String val, String expectedVal) throws Exception {
		
		String valid = lc5.longestPalindrome1(val);
		
		assertThat(valid).isEqualTo(expectedVal);
	}

}
