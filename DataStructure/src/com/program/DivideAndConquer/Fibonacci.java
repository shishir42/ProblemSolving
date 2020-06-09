package com.program.DivideAndConquer;

public class Fibonacci {
	public static void main(String[] args) {
		FibonacciMain main = new FibonacciMain();
		int output = main.calculate(9);
		System.out.println("Output: " + output);
	}
}

//0 1 1 2 3 5

class FibonacciMain{
	public int calculate(int n) {
//		if(n < 1) {
//			System.out.println("Please enter a positive number"); 
//			return n;
//		}
//		else if(n == 1) {
//			return 0;
//		}
//		else if(n==1) {
//			return 1;
//		}
//		else {
//			return calculate(n-1) + calculate(n-2);
//		}
		
		if (n <= 1) 
		       return n; 
		    return calculate(n-1) + calculate(n-2);
	}
}
