package com.program.Sorting;

import com.program.Helpers.Helpers;

public class BubbleSort {
	public static void main(String[] args) {
		BubbleSortImplementation sol = new BubbleSortImplementation();
		int[] arr = {30, 10, 50, 20, 60, 40};
		Helpers.printArray(sol.bubbleSort(arr));
		Helpers.printArray(sol.bubbleSort1(arr));
		Helpers.printArray(sol.bubbleSort2(arr));
	}
}

class BubbleSortImplementation{
	public int[] bubbleSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len-1; i++) {
			for (int j = 0; j < len-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public int[] bubbleSort1(int[] arr) {
		int n = arr.length;		
		for (int pass = n-1; pass >= 0; pass--) {
			for (int i = 0; i < pass-1; i++) {
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}		
		return arr;
	}
	
	public int[] bubbleSort2(int[] arr) {
		int n = arr.length;
		int pass, swapped = 1;
		for (pass = n-1;pass >=0 && swapped == 1; pass--) {
			swapped = 0;
			for (int i = 0; i < pass-1; i++) {
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		
		return arr;
	}
}
