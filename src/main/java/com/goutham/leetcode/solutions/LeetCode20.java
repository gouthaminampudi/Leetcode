package com.goutham.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class LeetCode20 {
	/**
	 * leetcode -20 ( - ),{,[ [ - ],(,{ { - },[,(
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {

		List<Character> l1 = new ArrayList<Character>();

		if (s.length() == 1) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			l1.add(s.charAt(i));
		}

		List<Character> removedList = removeMatchingParantheses(l1);
		return removedList.size() == 0;

	}

	List<Character> removeMatchingParantheses(List<Character> l1) {

		if (l1.size() == 0) {
			return l1;
		}
		int i = 0;
		while (i < l1.size()) {

			if (isClosedParantheses(l1.get(i)) && i > 0) {
				if ((l1.get(i).charValue() == 41 && l1.get(i - 1).charValue() == 40)
						|| (l1.get(i).charValue() == 93 && l1.get(i - 1).charValue() == 91)
						|| (l1.get(i).charValue() == 125 && l1.get(i - 1).charValue() == 123)) {
					l1.remove(i);
					l1.remove(i - 1);
					l1 = removeMatchingParantheses(l1);
				} else if ((l1.get(i).charValue() == 41 && l1.get(i - 1).charValue() != 40)
						|| (l1.get(i).charValue() == 93 && l1.get(i - 1).charValue() != 91)
						|| (l1.get(i).charValue() == 125 && l1.get(i - 1).charValue() != 123)) {
					break;
				}

			} else if (isClosedParantheses(l1.get(i)) && i == 0) {
				return l1;
			}

			i++;
		}
		return l1;
	}

	boolean isClosedParantheses(Character character) {

		return character.charValue() == 41 || character.charValue() == 93 || character.charValue() == 125;
	}

	public boolean isValid2(String s) {

		char[] strArr = s.toCharArray();

		if (s.length() % 2 > 0) {
			return false;
		}
		int times = s.length() / 2;

		boolean noVal = false;
		int i = 0;
		while (!noVal && i < times) {
			noVal = removeMatchingParantheses(strArr);
			i++;
		}

		return noVal;

	}

	private boolean removeMatchingParantheses(char[] strArr) {

		boolean noValue = false;
		int i = 0;
		while (i < strArr.length) {

			if (isClosedParantheses(strArr[i]) && i > 0) {
				if ((strArr[i] == 41 && strArr[i - 1] == 40) || (strArr[i] == 93 && strArr[i - 1] == 91)
						|| (strArr[i] == 125 && strArr[i - 1] == 123)) {
					strArr[i] = ' ';
					strArr[i - 1] = ' ';
					for (int x = i; x < strArr.length - 1; x++) {
						strArr[x - 1] = strArr[x + 1];
						strArr[x + 1] = ' ';
					}
					break;
				} else {
					return false;
				}

			}

			i++;
		}

		for (int i1 = 0; i1 < strArr.length; i1++) {

			if (strArr[i1] == ' ') {
				noValue = true;

			} else {
				noValue = false;
				break;
			}
		}

		return noValue;

	}

	public boolean isValid3(String s) {

		if (s.length() % 2 > 0) {
			return false;
		}
		int times = s.length() / 2;

		List<Character> l1 = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			l1.add(s.charAt(i));
		}

		boolean noVal = false;
		

		for (int i = 0; i < times;i++) {
			noVal = removeMatchingParantheses2(l1);

		}

		return noVal;

	}

	boolean removeMatchingParantheses2(List<Character> l1) {


		for (int i=0;i < l1.size();i++) {

			if (isClosedParantheses(l1.get(i)) && i > 0) {
				if ((l1.get(i).charValue() == 41 && l1.get(i - 1).charValue() == 40)
						|| (l1.get(i).charValue() == 93 && l1.get(i - 1).charValue() == 91)
						|| (l1.get(i).charValue() == 125 && l1.get(i - 1).charValue() == 123)) {
					l1.remove(i);
					l1.remove(i - 1);
					break;
				} else {
					return false;
				}

			}

		}
		return l1.isEmpty();
	}

}
