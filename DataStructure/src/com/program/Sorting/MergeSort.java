package com.program.Sorting;

public class MergeSort {
	public static void main(String[] args) {
		int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		MergeSortSol sol = new MergeSortSol();
		
		System.out.println("User entered Array: ");
		sol.printArray(array);

		long start = System.nanoTime();
		sol.mergeSort(array, 0, array.length-1);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end-start));

		System.out.println("\nAfter sorting: ");
		sol.printArray(array);
	}
}

class MergeSortSol
{
	public void mergeSort(int[] arr, int left, int right)
	{
		if(right > left) {
			int m = (right + left)/2;
			mergeSort(arr, left, m);
			mergeSort(arr, m+1, right);
			merge(arr, left, m, right);
		}
	}

	private void merge(int[] arr, int left, int m, int right) {
		int[] leftTempArray = new int[m-left+2];
		int[] rightTempArray = new int[right-m+1];

		//Copy values from Array 'Arr' to these tmp arrays
		for (int i = 0; i < m-left; i++) {
			leftTempArray[i]= arr[left+i];
		}
		for (int i = 0; i < right-m; i++) {
			rightTempArray[i]=arr[m+1+i];
		}

		//Merge values and insert into Array 'Arr'
		leftTempArray[m-left+1]= Integer.MAX_VALUE; 
		rightTempArray[right-m] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = left; k <= right; k++) {
			if (leftTempArray[i] < rightTempArray[j]) {
				arr[k] = leftTempArray[i];
				i++;
			} else {
				arr[k] = rightTempArray[j];
				j++;
			}
		}
	}

	public void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}
}