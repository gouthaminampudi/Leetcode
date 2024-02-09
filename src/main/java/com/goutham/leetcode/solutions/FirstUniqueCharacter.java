package com.goutham.leetcode.solutions;

import java.util.HashMap;

public class FirstUniqueCharacter {
    
    public static void main(String[] args){
        String test = "leeltcode";

        int indexOfFirstUniqueChar = findIndexOfFirstUniqueChar(test);
        findIndexOfFirstUniqueCharTwo(test);
        if(indexOfFirstUniqueChar==-1){
            System.out.println("There are no unique characters");
        }else{
            System.out.println("Index of First Unique character is : "+indexOfFirstUniqueChar);
        }
    }


    public static int findIndexOfFirstUniqueChar(String test){

        HashMap<Character, Integer> charMap =  new HashMap<Character, Integer>();

        for(char c: test.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }

        for(int i=0;i<test.length();i++){
            if(charMap.get(test.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public static int findIndexOfFirstUniqueCharTwo(String test){

        int[] arrInt = new int[test.length()];

        for(char c: test.toCharArray()){
          //  System.out.println(c-'0');
            System.out.println(c-'a');
        }
        return -1;
    }

}
