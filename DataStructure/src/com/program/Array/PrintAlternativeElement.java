package com.program.Array;

import java.util.Scanner;

public class PrintAlternativeElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  testCases = sc.nextInt();
		while(testCases > 0)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			ArrayOperationMethod array = new ArrayOperationMethod();
			array.printAlternative(arr);
			testCases--;
		}
	}
}

class ArrayOperationMethod{
	public void printAlternative(int[] arr) {
		for (int i = 0; i < arr.length; i+=2) {
			System.out.println(arr[i]);
		}
	}
}
