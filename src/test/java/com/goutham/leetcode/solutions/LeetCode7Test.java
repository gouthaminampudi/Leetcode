package com.goutham.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LeetCode7Test {

	
LeetCode7 leetCode7 = null;
	
	@Before
	public void setUp() throws Exception {
		leetCode7 = new LeetCode7();
	}

	
	@Test
	public void testReverse() {
		
		int x = leetCode7.reverse(-123456789);
		
		System.out.println(x);
		 assertThat(x).isEqualTo(0);
		}
	
	
	
	@Test
	public void testReverse1() {
		
		int x = leetCode7.reverse(1563847412);
		
		System.out.println(x);
		 assertThat(x).isEqualTo(0);
		}

}
