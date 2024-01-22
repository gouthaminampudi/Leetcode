package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
@RunWith(JUnitParamsRunner.class)
public class LeetCode242Test {

LeetCode242 lc242=null;
	
	@Before
	public void setUp() throws Exception {
		lc242=new LeetCode242();
	}
	@Test
	@Parameters({
        "anagram|nagaram|true",
        "rat|cat|false",
        "ac|bb|false"
		
	})
	public void testIsAnagram(String val,String expectedVal,boolean result) {
		
		boolean resultFromMethod = lc242.isAnagram(val, expectedVal);
		assertThat(resultFromMethod).isEqualTo(result);
	}

}
