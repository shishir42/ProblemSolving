package com.program.Array;

public class FindMaxAndMin {

	public static void main(String[] args) {
		int[] arr = {11, 2, 4, 14, 1, 33};
		System.out.println("Max Number: " + maxNumber(arr));
		System.out.println("Min Number: " + minNumber(arr));
	}
	
	public static int maxNumber(int[] arr){
		// Initialize maximum element 
		int max = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	public static int minNumber(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
}	
