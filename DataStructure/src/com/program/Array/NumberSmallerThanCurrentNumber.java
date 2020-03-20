package com.program.Array;

public class NumberSmallerThanCurrentNumber {

	public static void main(String[] args) {
		int arr[] = {8,1,2,2,3};
		new SmallNumberThanCurrent().smallerNumberThanCurentValue(arr);
	}
}

class SmallNumberThanCurrent{
	public void smallerNumberThanCurentValue(int[] nums) {
		int n = nums.length;
		if(n > 0)
		{
			
			int [] countSmaller = new int[n];
			//Count smaller elements on right side
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if(nums[i] > nums[j])
					{
						countSmaller[i]++;
					}
				}
			}
			
			for (int i = 0; i < countSmaller.length; i++) {
				System.out.println(countSmaller[i]);
			}
		}
	}
}

//https://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
//https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/303-range-sum-query---immutable/315-count-of-smaller-numbers-after-self.html


