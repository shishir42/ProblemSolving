package com.program.Array;

import java.util.ArrayList;

import com.program.Helpers.Helpers;

public class CreateTargetArrayInGivenOrder {
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};
		CreateTargetArrayInGivenOrderSol sol = new CreateTargetArrayInGivenOrderSol();
		int [] result = sol.createTargetArray(nums, index);
		Helpers.printArray(result);
		
		int[] nums1 = {1,2,3,4,0}, index1 = {0,1,2,3,0};
		int [] result1 = sol.createTargetArray(nums1, index1);
		Helpers.printArray(result1);
		
		int[] nums2 = {50, 40, 70, 60, 90}, index2 = {3,  0,  4,  1,  2};
		int[] result2 = sol.reorderArray(nums2, index2);
		Helpers.printArray(result2);
	}
}

class CreateTargetArrayInGivenOrderSol{
	public int[] createTargetArray(int[] nums, int[] index) {
		ArrayList<Integer> target = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			target.add(index[i], nums[i]);
		}
		
		int arr[] = new int[nums.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = target.get(i);
		}
		
		return arr;
	}
	
	//without duplicate index 
	public int[] reorderArray(int[] nums, int[] index) {
		int temp[] = new int[nums.length];
		
		// arr[i] should be present at index[i] index 
		for (int i = 0; i < nums.length; i++) {
			temp[index[i]] = nums[i];
		}
		
		// Copy temp[] to arr[] 
        for (int i=0; i<nums.length; i++) 
        {  
        	nums[i]   = temp[i]; 
        	index[i] = i;
        } 
		
		return nums;
	}
}

//Reorder an array according to given indexes
//Given two arrays of integers nums and index. Your task is to create target array under the following rules:
//
//Initially target array is empty.
//From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
//Repeat the previous step until there are no elements to read in nums and index.
//Return the target array.
//
//It is guaranteed that the insertion operations will be valid.
//
// 
//
//Example 1:
//
//Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
//Output: [0,4,1,3,2]
//Explanation:
//nums       index     target
//0            0        [0]
//1            1        [0,1]
//2            2        [0,1,2]
//3            2        [0,1,3,2]
//4            1        [0,4,1,3,2]