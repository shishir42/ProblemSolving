package com.program.DivideAndConquer;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubsequenceMain sol = new LongestPalindromicSubsequenceMain();
		System.out.println(sol.findLPSLength("ABCCBUA"));
	}
}

class LongestPalindromicSubstringMain{
	public int findLPSLenght(String str) {
		return LPSAUX(str, 0, str.length()-1);
	}

	private int LPSAUX(String str, int startIndex, int endIndex) {
		if (startIndex > endIndex) {//BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
			return 0;
		}
		if (startIndex == endIndex) {//BASE CASE - If both the index are at same position then its a palidrome as its 1 character.
			return 1;
		}	
		int c1 = 0;
		if (str.charAt(startIndex) == str.charAt(endIndex)) {  //CASE#1 - If index pointed characters matches then we 
			int remainingLength = endIndex - startIndex - 1;	   	 //add 2 to the existing known palindrome length only if
																	 //remaining string is a palindrome too
			if (remainingLength == LPSAUX(str, startIndex + 1, endIndex - 1))
				c1 = remainingLength + 2;
		}
		int c2 = LPSAUX(str, startIndex + 1, endIndex);//CASE#2 - Skip one element from beginning
		int c3 = LPSAUX(str, startIndex, endIndex - 1);//CASE#3 - Skip one element from end
		return Math.max(c1, Math.max(c2, c3));//Take the max sized palindrome
	}
}
