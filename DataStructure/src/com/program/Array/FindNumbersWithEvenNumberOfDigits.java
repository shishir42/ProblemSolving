package com.program.Array;

//Input: nums = [12,345,2,6,7896]
//Output: 2
//Explanation: 
//12 contains 2 digits (even number of digits). 
//345 contains 3 digits (odd number of digits). 
//2 contains 1 digit (odd number of digits). 
//6 contains 1 digit (odd number of digits). 
//7896 contains 4 digits (even number of digits). 
//Therefore only 12 and 7896 contain an even number of digits.


public class FindNumbersWithEvenNumberOfDigits {
	public static void main(String[] args) {
		FindNumbersWithEvenNumberOfDigitsSolution sol = new FindNumbersWithEvenNumberOfDigitsSolution();
		System.out.println(sol.findNumbers(new int[] {12,345,2,6,7896}));
		System.out.println(sol.findNumbers(new int[] {555,901,482,1771}));
	}
}

class FindNumbersWithEvenNumberOfDigitsSolution{
	public int findNumbers(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			String str = Integer.toString(nums[i]);
			//System.out.println(str.length());
			if(str.length()%2 == 0) {
				count++;
			}
		}
		
		return count;
	}
}