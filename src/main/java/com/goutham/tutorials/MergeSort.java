package com.goutham.tutorials;

import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] intArr = new int[10];
		
		Random rand = new Random();
		
		for(int i =0;i<intArr.length;i++) {
			intArr[i] = rand.nextInt(100000);
		}
		
		//before sort
		printArr(intArr);

		System.out.println("*****************middle***************");
		
		mergeSort(intArr);
		

		//after sort
		printArr(intArr);
	}

	private static void mergeSort(int[] intArr) {
		
		int intArrLength = intArr.length;
		

		
		if(intArrLength<2) {
			return;
		}
		

		//midpoint
		
		int midPoint = intArrLength/2;
		

		
		int[] leftArray = new int[midPoint];
		int[] rightArray = new int[intArrLength-midPoint];
		
		
		for(int i=0;i<midPoint;i++) {
			leftArray[i] = intArr[i];
		}
		
		for(int i=midPoint;i<intArrLength;i++) {
			rightArray[i-midPoint] = intArr[i];
		}
		/*System.out.println("*****************before left array***************");
		printArr(leftArray);
		System.out.println("*****************after left array***************");
		System.out.println("*****************middle***************");
		System.out.println("*****************before right array***************");
		printArr(rightArray);
		System.out.println("*****************after right array***************");*/
		
		
		mergeSort(leftArray);
		mergeSort(rightArray);
		
		merge(intArr,leftArray,rightArray);
		
	}

	private static void merge(int[] intArr, int[] leftArray, int[] rightArray) {
		
		int leftLength = leftArray.length;
		int rightLength = rightArray.length;

		int i = 0,j =0,k=0;
		
		//now merge the arrays into intArr
		
		while(i<leftLength && j<rightLength) {
			if(leftArray[i]<rightArray[j]) {
				intArr[k] = leftArray[i];
				i++;
				
			}else {
				
				intArr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while(i<leftLength ) {
			intArr[k] = leftArray[i];
			i++;
			k++;
		}
		
		while(j<rightLength ) {
			intArr[k] = rightArray[j];
			j++;
			k++;
		}
		
		
	}

	private static void printArr(int[] intArr) {
		
		for(int i=0;i<intArr.length;i++) {
			System.out.println(intArr[i]);
			
		}
		
	}

}
