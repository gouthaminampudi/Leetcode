package com.goutham.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode2 {
	
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	List<Integer>  l1Arr = new ArrayList<Integer>();
	List<Integer>  l2Arr = new ArrayList<Integer>();
	
	ListNode tempLn= l1;
	while(tempLn!=null) {
		l1Arr.add(tempLn.val);
		tempLn = tempLn.next;
	}

	tempLn= l2;
	while(tempLn!=null) {
		l2Arr.add(tempLn.val);
		tempLn = tempLn.next;
	}
	
	List<Integer> tempList = addTwoNumbers(l1Arr, l2Arr);
	
        return getlistNode(tempList);
    }


private ListNode getlistNode(List<Integer> listArr1) {
	ListNode startNode = new ListNode(listArr1.get(0));
	ListNode tempParentNode =  startNode;
	for(int i=1;i<listArr1.size();i++) {
		 ListNode x = new ListNode(listArr1.get(i));
		 tempParentNode.next = x;
		 tempParentNode =x;
	}
	return startNode;
}

public List<Integer> addTwoNumbers(List<Integer>  l1, List<Integer>  l2) {

	List<Integer> listAnsArr = new ArrayList<Integer>();

	int reminder = 0;
	Integer val = 0;
	Integer size = l1.size() > l2.size() ? l1.size() : l2.size();

	for (int i = 0; i < size; i++) {
		val = 0;

		if (l1.size() > l2.size()) {
			if (i + 1 <= l2.size()) {
				val = l1.get(i) + l2.get(i);
			} else {
				val = l1.get(i);
			}
		} else {
			if (i + 1 <= l1.size()) {
				val = l1.get(i) + l2.get(i);
			} else {
				val = l2.get(i);
			}

		}

		val = val + reminder;
		reminder = val / 10;
		listAnsArr.add(val % 10);
	}
	if(reminder>0)
	listAnsArr.add(reminder);
	return listAnsArr;
}

}
