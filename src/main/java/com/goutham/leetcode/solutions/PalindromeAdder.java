package com.goutham.leetcode.solutions;

public class PalindromeAdder {

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int number) {
        int reversed = reverse(number);
        return number == reversed;
    }

    // Method to reverse a number
    public static int reverse(int number) {
        int reversed = 0;
        while (number > 0) {
            reversed = (reversed * 10) + (number % 10);
            number = number / 10;
        }
        return reversed;
    }

    // Method that adds a number to its reverse until the sum is a palindrome
    public static int makePalindrome(int number) {
           while (!isPalindrome(number)) {
            int reversed = reverse(number);
            number = number + reversed;
        }
        return number;
    }

    public static void main(String[] args) {
        int number = 6016; // replace this with the number you want to test
        int palindrome = makePalindrome(number);
        System.out.println("Palindrome formed: " + palindrome);
    }
}

