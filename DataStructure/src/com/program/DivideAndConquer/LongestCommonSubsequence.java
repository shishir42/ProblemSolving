package com.program.DivideAndConquer;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		LCSMain sol = new LCSMain();
		System.out.println(sol.findLCSLength("houdini", "hdupti"));
	}
}

class LCSMain{
	public int findLCSLength(String s1, String s2) {
		return findLCSLengthAux(s1, s2, 0, 0);
	}

	private int findLCSLengthAux(String s1, String s2, int i1, int i2) {
		if (i1 == s1.length() || i2 == s2.length())//Base Case
		{
			return 0;
		}

		int c3 = 0;
		if (s1.charAt(i1) == s2.charAt(i2)) {//If current character in both the string matches, then increase the index by 1 in both the strings.
			c3 = 1 + findLCSLengthAux(s1, s2, i1 + 1, i2 + 1);
		}

		int c1 = findLCSLengthAux(s1, s2, i1, i2 + 1);//Increase index of 2nd String
		int c2 = findLCSLengthAux(s1, s2, i1 + 1, i2);//Increase index of 1st String

		return Math.max(c3, Math.max(c1, c2));
	}
}
