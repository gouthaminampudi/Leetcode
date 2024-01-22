package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LeetCode917Test {
	
LeetCode917 leetCode917 = null;
	
	@Before
	public void setUp() throws Exception {
		leetCode917 = new LeetCode917();
	}
	
	@Test
	@Parameters({
        "ab-cd|dc-ba",
        "a-bC-dEf-ghIj|j-Ih-gfE-dCba",
        "Test1ng-Leet=code-Q!|Qedo1ct-eeLg=ntse-T!"
	})
	public void testReverseOnlyLetters(String val, String expectedVal) throws Exception {
		 String retVal = leetCode917.reverseOnlyLetters(val);
		 
		 assertThat(retVal).isEqualTo(expectedVal);
	}
	
	@Test
	@Parameters({
        "ab-cd|dc-ba",
        "a-bC-dEf-ghIj|j-Ih-gfE-dCba",
        "Test1ng-Leet=code-Q!|Qedo1ct-eeLg=ntse-T!"
	})
	public void testReverseOnlyLettersSol1(String val, String expectedVal) throws Exception {
		 String retVal = leetCode917.reverseOnlyLettersSol1(val);
		 
		 assertThat(retVal).isEqualTo(expectedVal);
	}
	
	@Test
	@Parameters({
        "ab-cd|dc-ba",
        "a-bC-dEf-ghIj|j-Ih-gfE-dCba",
        "Test1ng-Leet=code-Q!|Qedo1ct-eeLg=ntse-T!"
	})
	public void testReverseOnlyLettersSol2(String val, String expectedVal) throws Exception {
		 String retVal = leetCode917.reverseOnlyLettersSol2(val);
		 
		 assertThat(retVal).isEqualTo(expectedVal);
	}


}
