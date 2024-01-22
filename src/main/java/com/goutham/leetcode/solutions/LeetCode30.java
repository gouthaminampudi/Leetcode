package com.goutham.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class LeetCode30 {

	
 

    public static List<Integer> findSubstring(String s, String[] words) {

    	List<Integer> listInt = new ArrayList<Integer>();

    	return listInt;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "this", "way"};
        List<String> permutations = getPermutations(words);

        System.out.println("Permutations of words using all the words:");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    private static List<String> getPermutations(String[] words) {
        List<String> permutations = new ArrayList<String>();
        boolean[] used = new boolean[words.length];
        StringBuilder permutation = new StringBuilder();
        permute(words, used, permutation, permutations);
        return permutations;
    }

    private static void permute(String[] words, boolean[] used, StringBuilder permutation, List<String> permutations) {
        if (permutation.length() == words.length) {
            permutations.add(permutation.toString());
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (used[i]) continue;
            permutation.append(words[i]);
            used[i] = true;
            permute(words, used, permutation, permutations);
            permutation.deleteCharAt(permutation.length() - 1);
            used[i] = false;
        }
    }
}

