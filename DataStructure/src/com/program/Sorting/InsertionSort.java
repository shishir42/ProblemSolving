package com.program.Sorting;

import com.program.Helpers.Helpers;

public class InsertionSort {
	public static void main(String[] args) {
		InsertionSortSol sol = new InsertionSortSol();
		int arr[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		Helpers.printArray(sol.insertionSort(arr));
	}
}

class InsertionSortSol{
	public int[] insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i], j=i;
			while(j>0 && arr[j-1]>temp)
			{
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
		return arr;
	}
}
