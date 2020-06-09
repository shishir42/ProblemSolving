package com.program.DivideAndConquer;

public class ConvertOneStringToAnother {
	public static void main(String[] args) {
		ConvertOneStringToAnotherMain sol = new ConvertOneStringToAnotherMain();
		System.out.println(sol.findMinOperation("table", "tbres"));
	}
}

//table
//tbres

//t --> common
//a --> insert
//b --> common
//r --> replace
//s --> delete


//t a b l e
//t a b r e s
//t a b l e s
//t a b l e

class ConvertOneStringToAnotherMain{
	public int findMinOperation(String s1, String s2) {
		return finMinOperationAux(s1, s2, 0, 0);
	}
	
	private int finMinOperationAux(String s1, String s2, int l1, int l2) {
		// if we have reached the end of s1, then insert all the remaining characters of s2
		if(l1 == s1.length()) {
			return s2.length() - l2;
		}
		
		// if we have reached the end of s2, then delete all the remaining characters of s1
		if(l2 == s2.length()) {
			return s1.length() - l1;
		}
		
		// If the strings have a matching character, recursively match for the remaining lengths.
		if(s1.charAt(l1) == s2.charAt(l2)) {
			return finMinOperationAux(s1, s2, l1+1, l2+1);
		}
		
		int c1 = 1 + finMinOperationAux(s1, s2, l1+1, l2); // perform deletion
		int c2 = 1 + finMinOperationAux(s1, s2, l1, l2+1); // perform insertion
		int c3 = 1 + finMinOperationAux(s1, s2, l1+1, l2+1); //perform replacement
		
		return Math.min(c1, Math.min(c2,c3));
	}
}
