/**
 * 
 */
package com.goutham.leetcode.solutions;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class LeetCode189Test {
	
	LeetCode189 leetCode189;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		leetCode189 = new LeetCode189();
	}

	@Test
	public void testRotate() {
		int[] arr = {1,2,3,4,5};
		leetCode189.rotate(arr, 2);
		
		assertTrue(arr[0] == 4);
		assertTrue(arr[1] == 5);
		assertTrue(arr[2] == 1);
		assertTrue(arr[3] == 2);
		assertTrue(arr[4] == 3);
		
	}
	
	@Test
	public void testRotate1() {
		int[] arr = {-1,-100,3,99};
		leetCode189.rotate(arr, 3);
		
		assertTrue(arr[0] ==-100);
		assertTrue(arr[1] == 3);
		assertTrue(arr[2] == 99);
		assertTrue(arr[3] == -1);

		
	}

	
	
	@Test
	public void estRotate2() {
		int[] arr = {1,2,3,4,5,6,7};
		leetCode189.rotate(arr, 3);
		
		assertTrue(arr[0] ==5);
		assertTrue(arr[1] == 6);
		
	}
}
