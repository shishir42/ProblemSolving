package com.program.Sorting;

import com.program.Helpers.Helpers;

public class SelectionSort {
	public static void main(String[] args) {
		SelectionSortSol sol = new SelectionSortSol();
		int[] arr = {30, 10, 50, 20, 60, 40};
		Helpers.printArray(sol.selectionSortImp(arr));
	}
}

class SelectionSortSol{
	public int[] selectionSortImp(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if(arr[j] < arr[min]) {//find which is the smallest element to right of 'i'
					min = j;
				}
			}
			if(min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		return arr;
	}
}
