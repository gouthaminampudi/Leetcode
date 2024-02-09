package com.goutham.tutorials;

import java.util.Random;

public class BubbleSort {
	
	
	public  static void main(String[] args) {
		int[] intArr = new int[10];
		
		Random rand = new Random();
		
		for(int i=0;i<intArr.length;i++) {
			intArr[i] = rand.nextInt(100000);
		}
		
		//Before Sort
		printArray(intArr);
		System.out.println("****************break*************");
		boolean sorted = true;
		
		while(sorted){
			sorted = false;
			for(int i=0;i<intArr.length-1;i++) {
				
				if(intArr[i]>intArr[i+1]) {
					int temp = intArr[i];
					intArr[i] = intArr[i+1];
					intArr[i+1]=temp;
					sorted = true;
				}
			}
			
		}
		
		//after Sort
		printArray(intArr);
		
	}

	private static void printArray(int[] intArr) {
		for(int i=0;i<intArr.length;i++) {
			System.out.println(intArr[i]);
		}
		
	}
	

}
