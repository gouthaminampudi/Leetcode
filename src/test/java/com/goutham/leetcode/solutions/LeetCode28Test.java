package com.goutham.leetcode.solutions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LeetCode28Test {

	LeetCode28 leetCode28=null;
	@Before
	public void setUp() throws Exception {
		leetCode28=new LeetCode28();
	}
	
	@Test
	public void testStrStr() {
		int i = leetCode28.strStr("leetcode", "ode");
		System.out.println(i);
	}

}
