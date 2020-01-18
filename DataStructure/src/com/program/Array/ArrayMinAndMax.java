package com.program.Array;

import java.util.Scanner;

public class ArrayMinAndMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases > 0)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			ArrayMinMaxOperation maxmin = new ArrayMinMaxOperation();
			//maxmin.printArray(arr);
			maxmin.maxminOperation(arr);
			
			System.out.println("------------------------------------------");
			System.out.println("Max Value: " + maxmin.maxminOperation(arr, 0, arr.length - 1).max);
			System.out.println("Min Value:" + maxmin.maxminOperation(arr, 0, arr.length - 1).min);
			
			System.out.println("------------------------------------------");
			System.out.println("Max Value: " + maxmin.maxminOperation(arr, arr.length).max);
			System.out.println("Min Value:" + maxmin.maxminOperation(arr, arr.length).min);
			
			testCases--;
		}
		
		sc.close();
	}
}

class ArrayMinMaxOperation{
	int min;
	int max;
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	//Simple Linear Search
	//Time Complexity: O(n)

	//In this method, total number of comparisons is 1 + 2(n-2) in worst case and 1 + n – 2 in best case.
	//In the below implementation, worst case occurs when elements are sorted in descending order and best case occurs when elements are sorted in ascending order.
	public void maxminOperation(int[] arr) {
		/*If there is only one element then return it as min and max both*/
		if(arr.length == 1) {
			min = arr[0];
			max = arr[0];
		}
		
		/* If there are more than one elements, then initialize min  
	    and max*/
//		if(arr[0] > arr[1]) {
//			max = arr[0];
//			min = arr[1];
//		}else {
//			max = arr[1];
//			min = arr[0];
//		}
		
		
		if (arr[0] > arr[1]) { 
			max = arr[0];
			min = arr[1];
        } else { 
        	max = arr[1];
			min = arr[0];
        } 
  
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}else if (arr[i] < min){
				min = arr[i];
			}
		}
		
		System.out.println("Max Value: " + max);
		System.out.println("Min Value:" + min);
	}
	
	//Time Complexity: O(n)
	//Total number of comparisons: let number of comparisons be T(n). T(n) can be written as follows:
	//Algorithmic Paradigm: Divide and Conquer
	
	//	 T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2  
	//			  T(2) = 1
	//			  T(1) = 0
	//			If n is a power of 2, then we can write T(n) as:
	//
	//			   T(n) = 2T(n/2) + 2 
	//			After solving above recursion, we get
	//
	//			  T(n)  = 3n/2 -2 
	//			Thus, the approach does 3n/2 -2 comparisons if n is a power of 2. 
	//			And it does more than 3n/2 -2 comparisons if n is not a power of 2.
	public Pair maxminOperation(int[] arr, int low, int high) {
		Pair minmax = new Pair();
		Pair mml = new Pair(); 
        Pair mmr = new Pair(); 
        int mid; 
		
		/* If there is only on element */
		if(low == high) {
			minmax.max = arr[low];
			minmax.min = arr[low];
			return minmax;
		}
		
		/* If there are two elements */
		if(high == low + 1) {
			if (arr[low] > arr[high]) { 
                minmax.max = arr[low]; 
                minmax.min = arr[high]; 
            } else { 
                minmax.max = arr[high]; 
                minmax.min = arr[low]; 
            } 
			return minmax;
		}
		
		/* If there are more than 2 elements */
		mid = (low + high)/2;
		mml = maxminOperation(arr, low, mid);
		mmr = maxminOperation(arr, mid + 1, high);
		
		/* compare minimums of two parts*/
		if (mml.min < mmr.min) { 
            minmax.min = mml.min; 
        } else { 
            minmax.min = mmr.min; 
        } 
  	
		/* compare maximums of two parts*/
        if (mml.max > mmr.max) { 
            minmax.max = mml.max; 
        } else { 
            minmax.max = mmr.max; 
        } 
		
		return minmax;
	}
	
	//Compare in Pairs
	//	If n is odd then initialize min and max as first element.
	//	If n is even then initialize min and max as minimum and maximum of the first two elements respectively.
	//	For rest of the elements, pick them in pairs and compare their
	//	maximum and minimum with max and min respectively.
	
	
	//	Time Complexity: O(n)
	//
	//	Total number of comparisons: Different for even and odd n, see below:
	//
	//	       If n is odd:    3*(n-1)/2  
	//	       If n is even:   1 Initial comparison for initializing min and max, 
	//	                           and 3(n-2)/2 comparisons for rest of the elements  
	//	                      =  1 + 3*(n-2)/2 = 3n/2 -2
	//	Second and third approaches make equal number of comparisons when n is a power of 2.
	//
	//	In general, method 3 seems to be the best.
	public Pair maxminOperation(int[] arr, int n) {
		Pair minmax = new Pair();
		int i;
		
		/* If array has even number of elements then   
	    initialize the first two elements as minimum and   
	    maximum */
		
		if(n % 2 == 0) {
			if(arr[0] > arr[1]) {
				minmax.max = arr[0];
				minmax.min = arr[1];
			}else {
				minmax.max = arr[1];
				minmax.min = arr[0];
			}
			i = 2;/* set the starting index for loop */
		}else {
			/* If array has odd number of elements then   
		    initialize the first element as minimum and   
		    maximum */
			minmax.max = arr[0];
			minmax.min = arr[0];
			i = 1;/* set the starting index for loop */
		}
		
		/* In the while loop, pick elements in pair and   
	     compare the pair with max and min so far */
	        while (i < n - 1) { 
	            if (arr[i] > arr[i + 1]) { 
	                if (arr[i] > minmax.max) { 
	                    minmax.max = arr[i]; 
	                } 
	                if (arr[i + 1] < minmax.min) { 
	                    minmax.min = arr[i + 1]; 
	                } 
	            } else { 
	                if (arr[i + 1] > minmax.max) { 
	                    minmax.max = arr[i + 1]; 
	                } 
	                if (arr[i] < minmax.min) { 
	                    minmax.min = arr[i]; 
	                } 
	            } 
	            i += 2; 
	            /* Increment the index by 2 as two   
	               elements are processed in loop */
	        } 
		return minmax;
	}
	
	class Pair { 
	    int min; 
	    int max; 
	} 
}
