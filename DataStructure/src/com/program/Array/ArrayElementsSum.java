package com.program.Array;

import java.util.Scanner;

public class ArrayElementsSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			ArraySumElement sumElement = new ArraySumElement();
			sumElement.sumOfAllElement(arr, n);
			System.out.println("-----------------------------------");
			System.out.println(sumElement.sumOfAllElementUsingRecursion(arr, n));
			testCases--;
		}		
		sc.close();
	}
}

class ArraySumElement{
	public void sumOfAllElement(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		System.out.println("Sum: " + sum);
	}
	
	public int sumOfAllElementUsingRecursion(int[] arr, int n) {
		if(n <= 0)
		{
			return 0;
		}
		
		return (sumOfAllElementUsingRecursion(arr, n-1) + arr[n-1]);
	}
}
