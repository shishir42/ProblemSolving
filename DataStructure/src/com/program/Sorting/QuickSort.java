package com.program.Sorting;

import com.program.Helpers.Helpers;

public class QuickSort {
	public static void main(String[] args) {
		QuickSortMain sol = new QuickSortMain();
		int array[] = {10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11};
		sol.quickSortSol(array, 0, array.length-1);
		Helpers.printArray(array);
	}
}

class QuickSortMain{
	public int partition(int[] arr, int p, int q) {
		int pivot = q;
		int i = p-1;
		for(int j=p; j<=q; j++) {
			if (arr[j] <= arr[pivot]) {
				i++;
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j] = temp;
			}
		}
		return i;
	}
	
	public void quickSortSol(int[] arr, int start, int end) {
		if(start<end) {
			int pivot = partition(arr, start, end);
			quickSortSol(arr, start, pivot-1);
			quickSortSol(arr, pivot+1, end);
		}
	}
}
