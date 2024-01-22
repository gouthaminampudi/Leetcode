package com.goutham.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetCode2Test {
	
	
LeetCode2 lc2=null;
	
	@Before
	public void setUp() throws Exception {
		lc2=new LeetCode2();
	}
	
	@Test
	public void testAddTwoNumbers() {
		Integer[] listArr1 = {9,9,9,9,9,9,9};
		Integer[] listArr2 = {9,9,9,9};
		Integer[] listAnsArr = {8,9,9,9,0,0,0,1};
		
		List<Integer> list1 = Arrays.asList(listArr1);
		List<Integer> list2 = Arrays.asList(listArr2);
		
		List<Integer> resultFromMethod = lc2.addTwoNumbers(list1, list2);
		System.out.println(resultFromMethod);
		Assert.assertArrayEquals(listAnsArr, resultFromMethod.toArray());
		
	}
	
	@Test
	public void testAddTwoNumbers5() {
		Integer[] listArr1 = {9,9,9,9,9,9,9};
		Integer[] listArr2 = {9,9,9,9};
		Integer[] listAnsArr = {8,9,9,9,0,0,0,1};
		
		List<Integer> list1 = Arrays.asList(listArr2);
		List<Integer> list2 = Arrays.asList(listArr1);
		
		List<Integer> resultFromMethod = lc2.addTwoNumbers(list1, list2);
		System.out.println(resultFromMethod);
		Assert.assertArrayEquals(listAnsArr, resultFromMethod.toArray());
		
	}
	
	@Test
	public void testAddTwoNumbers2() {
		Integer[] listArr1 = {2,4,3};
		Integer[] listArr2 = {5,6,4};
		Integer[] listAnsArr = {7,0,8};
		
		List<Integer> list1 = Arrays.asList(listArr1);
		List<Integer> list2 = Arrays.asList(listArr2);
		
		List<Integer> resultFromMethod = lc2.addTwoNumbers(list1, list2);
		System.out.println(resultFromMethod);
		Assert.assertArrayEquals(listAnsArr, resultFromMethod.toArray());
		
	}
	
	@Test
	public void testAddTwoNumbers3() {
		Integer[] listArr1 = {1,2};
		Integer[] listArr2 = {1,2};
		Integer[] listAnsArr = {2,4};
		
		List<Integer> list1 = Arrays.asList(listArr1);
		List<Integer> list2 = Arrays.asList(listArr2);
		
		List<Integer> resultFromMethod = lc2.addTwoNumbers(list1, list2);
		System.out.println(resultFromMethod);
		Assert.assertArrayEquals(listAnsArr, resultFromMethod.toArray());
		
	}
	
	@Test
	public void testAddTwoNumbers6() {
		Integer[] listArr1 = {0};
		Integer[] listArr2 = {0};
		Integer[] listAnsArr = {0};
		
		List<Integer> list1 = Arrays.asList(listArr1);
		List<Integer> list2 = Arrays.asList(listArr2);
		
		List<Integer> resultFromMethod = lc2.addTwoNumbers(list1, list2);
		System.out.println(resultFromMethod);
		Assert.assertArrayEquals(listAnsArr, resultFromMethod.toArray());
		
	}
	
	@Test
	public void testAddTwoNumbers4() {
		/*Integer[] listArr1 = {9,9,9,9,9,9,9};
		Integer[] listArr2 = {9,9,9,9};
		Integer[] listAnsArr = {8,9,9,9,0,0,0,1};
		*/
		
		
		Integer[] listArr1 = {0};
		Integer[] listArr2 = {0};
		Integer[] listAnsArr = {0};
		
		ListNode listArr1Node = getlistNode(listArr1);
		ListNode listArr2Node = getlistNode(listArr2);


		ListNode resultFromMethod = lc2.addTwoNumbers(listArr1Node, listArr2Node);
		List<Integer>  l1Arr = new ArrayList<Integer>();
		ListNode tempLn= resultFromMethod;
		while(tempLn!=null) {
			l1Arr.add(tempLn.val);
			tempLn = tempLn.next;
		}
		
		Assert.assertArrayEquals(listAnsArr, l1Arr.toArray());
	}
	
	private ListNode getlistNode(Integer[] listArr1) {
		ListNode startNode = new ListNode(listArr1[0]);
		ListNode tempParentNode =  startNode;
		for(int i=1;i<listArr1.length;i++) {
			 ListNode x = new ListNode(listArr1[i]);
			 tempParentNode.next = x;
			 tempParentNode =x;
		}
		return startNode;
	}
}