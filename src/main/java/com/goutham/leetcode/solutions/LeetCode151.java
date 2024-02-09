package com.goutham.leetcode.solutions;

public class LeetCode151 {
    public String reverseWords(String s) {

        s = s.trim();
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<strArr.length;i++){
            //if(!"".equalsIgnoreCase(strArr[strArr.length-1-i]))
            if(strArr[strArr.length-1-i].trim().length()>0)
                sb.append(strArr[strArr.length-1-i].trim()).append(" ");
        }
       return sb.toString().trim(); 
    }
}
