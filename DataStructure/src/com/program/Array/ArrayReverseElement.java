package com.program.Array;

import java.util.Scanner;

public class ArrayReverseElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			ReverseElementOperation reverseElementOperation = new ReverseElementOperation();
			reverseElementOperation.reverseElementUsingIterative(arr, 0, n-1);
			System.out.println("*******************************");
			reverseElementOperation.reverseElementusingRecursion(arr, 0, n-1);
			testCases--;
		}
		sc.close();
	}
}

class ReverseElementOperation{

	//Time Complexity : O(n)
	public void reverseElementUsingIterative(int[] arr, int start, int end) {
		int temp;
		while(start < end)
		{
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		printArray(arr);
	}

	public void reverseElementusingRecursion(int[] arr, int start, int end) {
		int temp;
		if(start >= end)
		{
			return;
		}
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverseElementusingRecursion(arr, start+1, end-1);
	}

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	//	Method 1:
	//		1- Store array elements into a vector in C++.
	//		2- Then reverse the vector using predefined functions.
	//		3- Then store reversed elements into the array back.
	//
	//		Method 2:
	//		1- Store array elements into a stack.
	//		2- As the stack follows Last In First Out, so we can store elements from
	//		top of the stack into the array which will be itself in a reverse manner.
	//
	//		Method 3:
	//		1- In this method, the idea is to use a negative sign but by storing it into a variable.
	//		2- By using this statement x = (INT_MIN/INT_MAX), we get -1 in a variable x.
	//		3- As INT_MIN and INT_MAX have same values just of opposite signs, so on dividing them it will give -1.
	//		4- Then ‘x’ can be used in decrementing the index from last.

	//https://www.geeksforgeeks.org/reverse-array-without-using-subtract-sign-anywhere-code/

	//	for(int i =0, j = arr.length-1; i < j ; i++, j--){
	//        int temp = arr[i];
	//        arr[i] = arr[j];
	//        arr[j] = temp;
	//    }

	//	for(int i=n-1;i>=0;i--){
	//        System.out.print(a[i]+" ");
	//    }
}
