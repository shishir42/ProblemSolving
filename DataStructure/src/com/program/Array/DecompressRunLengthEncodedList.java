package com.program.Array;

import java.util.Arrays;

//3a4b2c
//aaabbbbcc


//nums = [1, 2, 3, 4]
//o/p: [2, 4, 4, 4]

//for pair {1,2}: one element of 2
//for pair {3,4}: three element of 4

//literal array: new int[]{1, 2, 3}
//empty array: new int[] {}


public class DecompressRunLengthEncodedList {
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.decompressRLElist(new int[]{1,2,3,4});
	}
}

class Solution
{
	public int[] decompressRLElist(int[] nums) {
		int[] rleList = new int[] {};
		
		for (int i = 0; i < nums.length; i+=2) {
			for (int j = 0; j < nums[i]; j++) {
				rleList = appendArray(rleList, nums[i+1]);
			}
		}
		
		System.out.println(Arrays.toString(rleList));		
		return rleList;
	}
	
	public int[] appendArray(int[] arr, int num) {
		arr = Arrays.copyOf(arr, arr.length +1);
		arr[arr.length - 1] = num;
		return arr;
	}
}