package com.goutham.leetcode.solutions;

public class ShiftOperations {

 
	    public int divide(int dividend, int divisor) {
	        // Handle edge cases
	        if (dividend == 0) {
	            return 0;
	        }
	        if (divisor == 0) {
	            throw new IllegalArgumentException("Division by zero is not allowed.");
	        }
	        if (dividend == Integer.MIN_VALUE && divisor == -1) {
	            return Integer.MAX_VALUE;
	        }

	        // Determine the sign of the result
	        boolean negative = (dividend < 0) != (divisor < 0);

	        // Work with long to handle overflow
	        long longDividend = Math.abs((long) dividend);
	        long longDivisor = Math.abs((long) divisor);

	        long result = 0;
	        while (longDividend >= longDivisor) {
	            long temp = longDivisor, multiple = 1;
	            while (longDividend >= (temp << 1)) {
	                temp <<= 1;
	                multiple <<= 1;
	            }
	            longDividend -= temp;
	            result += multiple;
	        }

	        // Apply the sign to the result and cast back to int
	        return negative ? -(int) result : (int) result;
	    }

	    // Test the method with an example
	    public static void main(String[] args) {
	    	ShiftOperations solution = new ShiftOperations();
	        int dividend = 25;
	        int divisor = 5;
	        int result = solution.divide(dividend, divisor);
	        System.out.println("Result: " + result);
	    }

}
