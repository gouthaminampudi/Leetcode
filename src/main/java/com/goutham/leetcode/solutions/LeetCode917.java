package com.goutham.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class LeetCode917 {
	
	public String reverseOnlyLetters(String s) {
	      


		return "";
	    }

	
public String reverseOnlyLettersSol1(String s) {
      
        int strLen = s.length();
        List<String> ls = new ArrayList<String>();
        List<String> interimls = new ArrayList<String>();
        while(ls.size() < strLen) ls.add("<>"); 
    
        for(int i = strLen-1;i>=0;i--) {
        	char c = s.charAt(i);
        	if(Character.isLetter(c)) {
        		interimls.add(String.valueOf(c));
        	}else {
        		ls.set(i, String.valueOf(c));
        	}
        }
        
        for(int x=0;x<interimls.size();x++) {
        	for(int y=0;y<ls.size();y++) {
        		if("<>".equalsIgnoreCase(ls.get(y))) {
        			ls.set(y, interimls.get(x));
        			break;
        		}
        	}
        	
        }
        
        StringBuffer bf = new StringBuffer();

        for(int i=0;i<ls.size();i++) {
        	bf.append(ls.get(i));
        }
        
        System.out.println(bf.toString());
	return bf.toString();
    }

public String reverseOnlyLettersSol2(String s) {
    
    List<String> interimls = new ArrayList<String>();
       StringBuilder bf = new StringBuilder();
   
       for(int i = s.length()-1;i>=0;i--) {
       	if(Character.isLetter(s.charAt(i))) {
       		interimls.add(String.valueOf(s.charAt(i)));
       	}
       }
       
       for(int i = 0;i<s.length();i++) {
       	if(!Character.isLetter(s.charAt(i))) {
       		bf.append(s.charAt(i));
       	}else {
       		bf.append(interimls.get(0));
       		interimls.remove(0);
       	}
       }

	return bf.toString();
   }

public static void main(String[] args) {
	  String str = "Test1ng-Leet=code-Q!";
	LeetCode917 lc917 = new LeetCode917();
	lc917.reverseOnlyLetters(str);
}

}
