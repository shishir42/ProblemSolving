package com.program.Array;

public class NumberSmallerThanCurrentNumber {

	public static void main(String[] args) {
		int arr[] = {8,1,2,2,3};
		new SmallNumberThanCurrent().smallerNumberThanCurentValueOnlyRightSide(arr);
		System.out.println("\n");
		new SmallNumberThanCurrent().smallerNumbersThanCurrent(arr);
		System.out.println("\n");
		new SmallNumberThanCurrent().smallNumberThanCurrentForAll(arr);
	}
}

class SmallNumberThanCurrent{
	public void smallerNumberThanCurentValueOnlyRightSide(int[] nums) {
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
				System.out.print(countSmaller[i] + " ");
			}
		}
	}
	
	
	public int[] smallNumberThanCurrentForAll(int[] nums) {
		int ans[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			int firstNum = nums[i];
			for (int j = 0; j < nums.length; j++) {
				if(firstNum > nums[j]) {
					count++;
				}
			}
			ans[i] = count;
		}
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		
		return ans;
	}
	
	public int[] smallerNumbersThanCurrent(int[] nums) {
	    int[] counter = new int[101];
	    for (int num : nums) {
	      counter[num]++;
	    }
	    int sum = 0;
	    int[] preSum = new int[101];
	    for (int i = 0; i < 101; i++) {
	      preSum[i] = sum;
	      sum += counter[i];
	    }
	    int[] ans = new int[nums.length];
	    for (int i = 0; i < nums.length; i++) {
	      ans[i] = preSum[nums[i]];
	    }
	    
	    for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	    return ans;
	  }
}

//https://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
//https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/303-range-sum-query---immutable/315-count-of-smaller-numbers-after-self.html


