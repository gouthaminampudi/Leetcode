package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
@RunWith(JUnitParamsRunner.class)

public class LeetCode20Test {

	LeetCode20 lc20=null;
	
	@Before
	public void setUp() throws Exception {
		lc20=new LeetCode20();
	}

	@Test
	@Parameters({
        "()|true",
        "()[]{}|true",
        "(]|false",
        "([)]|false",
        "[|false",
		"((|false"
	})
	public void testIsValid(String s, boolean expectedVal) throws Exception {
		boolean valid  = lc20.isValid(s);
		assertThat(valid).isEqualTo(expectedVal);
	}

	@Test
	@Parameters({
        ")|true",
        "}|true",
        "]|true",
        "(|false"
	})
	public void testIsClosedParantheses(Character s, boolean expectedVal) throws Exception {
		boolean valid  = lc20.isClosedParantheses(s);
		assertThat(valid).isEqualTo(expectedVal);
		
	}
	@Test
	@Parameters({
        "()|true",
        "()[]{}|true",
        "(]|false",
        "([)]|false",
        "[|false",
		"((|false",
		"{[]}|true",
		"(){}}{|false"
		
	})
	public void testIsValid2(String s, boolean expectedVal) throws Exception {
		boolean valid  = lc20.isValid2(s);
		assertThat(valid).isEqualTo(expectedVal);
	}

	@Test
	@Parameters({
        "()|true",
        "()[]{}|true",
        "(]|false",
        "([)]|false",
        "[|false",
		"((|false",
		"{[]}|true",
		"(){}}{|false"
		
	})
	public void testIsValid3(String s, boolean expectedVal) throws Exception {
		boolean valid  = lc20.isValid3(s);
		assertThat(valid).isEqualTo(expectedVal);
	}

}
