package com.program.Array;

import java.util.Arrays;
import java.util.Scanner;

//Input:
//1
//5
//2 4 1 0 6

//search, insert, insert operation element index, delete operation
//1 2 2 0
//Output:
//1 1 1

public class ArrayOperation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		//System.out.println("1: " + t);
		while(t --> 0) {
			int n = sc.nextInt();
			//System.out.println("2: " + n);
			int[] a = new int[10000];
			Arrays.fill(a, -1);
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				//System.out.println("3: " + a[i]);
			}

			int x = sc.nextInt();
			int y = sc.nextInt();
			int y1 = sc.nextInt();
			int z = sc.nextInt();

			ArrayOperationsMethods array = new ArrayOperationsMethods();
			boolean b = array.searchElement(a, x);
			if(b== true)
			{
				System.out.println("Search: 1");
			}
			else
			{
				System.out.println("Search: 0");
			}

			b = array.insertElement(a, y, y1);
			if(b== true)
			{
				System.out.println("Insert: 1");
			}
			else
			{
				System.out.println("Insert: 0");
			}

			b = array.deleteElement(a, z);
			if(b== true)
			{
				System.out.println("Delete: 1");
			}
			else
			{
				System.out.println("Delete: 0");
			}
		}
		sc.close();
	}
}

class ArrayOperationsMethods {
	public boolean searchElement(int[] arr, int searchElement) {
		if(arr != null && arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == searchElement) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean insertElement(int[] arr, int element, int index) {
		if(arr != null && arr.length > 0 & index > 0) {
			arr[index] = element;
			return true;
		}
		return false;
	}

	public boolean insertSorted(int arr[], int n, int key, int capacity) 
	{ 
		// Cannot insert more elements if n  
		// is already more than or equal to  
		// capacity 
		if (n >= capacity) {
			return false;
		} 
		arr[n] = key; 

		return true; 
	}

	// function to search a key to be deleted 
	public int findElement(int arr[], int n, int key) 
	{ 
		int i; 
		for (i = 0; i < n; i++) 
			if (arr[i] == key) {
				return i;
			} 

		return -1; 
	}  

	// Function to delete an element 
	public int deleteElement(int arr[], int n, int key) 
	{ 
		// Find position of element to be  
		// deleted 
		int pos = findElement(arr, n, key); 

		if (pos == -1) 
		{ 
			System.out.println("Element not found"); 
			return n; 
		} 

		// Deleting element 
		int i; 
		for (i = pos; i< n - 1; i++) {
			arr[i] = arr[i + 1]; 
		}
			
		return n - 1; 
	} 


	public boolean deleteElement(int[] arr, int index) {
		if(arr != null && arr.length > 0) {
			arr[index] = Integer.MIN_VALUE;
			return true;
		}
		return false;
	}

	public boolean removeTheElement(int[] arr, int index) { 
		// If the array is empty 
		// or the index is not in array range 
		// return the original array 
		if (arr == null || index < 0 || index >= arr.length) { 

			return false; 
		} 

		// Create another array of size one less 
		int[] anotherArray = new int[arr.length - 1]; 

		// Copy the elements except the index 
		// from original array to the other array 
		for (int i = 0, k = 0; i < arr.length; i++) { 

			// if the index is 
			// the removal element index 
			if (i == index) { 
				continue; 
			} 

			// if the index is not 
			// the removal element index 
			anotherArray[k++] = arr[i]; 
		} 

		// return the resultant array 
		return true; 
	} 

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" "); 
	}
}

