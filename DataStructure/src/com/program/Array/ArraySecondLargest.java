package com.program.Array;

import java.util.Scanner;

public class ArraySecondLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			SecondLargestOperation secondLargestElement = new SecondLargestOperation();
			secondLargestElement.printSecondLargestElement(arr, n);
			System.out.println("-----------------------------------------------");
			secondLargestElement.printSecondLargestElementEfficient(arr, n);
		}
	}
}


//A simple solution will be first sort the array in descending order and 
//then return the second element from the sorted array. The time complexity of this solution is O(nlogn).
//

//A Better Solution is to traverse the array twice. In the first traversal find the maximum element. 
//In the second traversal find the greatest element less than the element obtained in first traversal. 
//The time complexity of this solution is O(n).
//

//A more Efficient Solution can be to find the second largest element in a single traversal.
//Below is the complete algorithm for doing this:
//
//1) Initialize two variables first and second to INT_MIN as,
//   first = second = INT_MIN
//2) Start traversing the array,
//   a) If the current element in array say arr[i] is greater
//      than first. Then update first and second as,
//      second = first
//      first = arr[i]
//   b) If the current element is in between first and second,
//      then update second to store the value of current variable as
//      second = arr[i]
//3) Return the value stored in second.
class SecondLargestOperation{
	public void printSecondLargestElement(int[] arr, int n) {
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(arr[i]> arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("-------------------output----------------");
		System.out.println(arr[n -2]);
	}


	public void printSecondLargestElementEfficient(int[] arr, int n) {
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		/* There should be atleast two elements */
		if (n < 2) 
		{ 
			System.out.print(" Invalid Input "); 
			return; 
		} 

		for (int i = 0; i < n; i++) {

			/* If current element is smaller than  
            first then update both first and second */			
			if(arr[i] > first) {
				second = first;
				first = arr[i];								
			}
			else if (arr[i] >= second && arr[i] <= first) {
				/* If arr[i] is in between first and  
	               second then update second  */
				second = arr[i];
			}
		}
		
		System.out.println(second);
	}
}
