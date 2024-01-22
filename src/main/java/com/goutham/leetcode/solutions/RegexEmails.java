package com.goutham.leetcode.solutions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEmails {
	
	
	public String addCommas(String emailString) {
		
		
		Pattern pattern = Pattern.compile(">;\\s*(.*?)\\s*<");
		Matcher matcher = pattern.matcher(emailString);
		String result = matcher.replaceAll(",");
		return result;
		
	}

}
