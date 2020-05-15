package com.program.Array;

import com.program.Helpers.Helpers;

public class ElementsWithGreatestElementOnRightSide {
	public static void main(String[] args) {
		 ElementsWithGreatestElementOnRightSideSol sol = new ElementsWithGreatestElementOnRightSideSol();
		 sol.replaceElement(new int [] {17,18,5,4,6,1});
		 sol.nextGreatest(new int [] {17,18,5,4,6,1});
	}
}

class ElementsWithGreatestElementOnRightSideSol{
	public int[] replaceElement(int[] arr) {
		int n = arr.length;
		int maxNumber = 0;
		int[] newArr = new int[n];
		for (int i = 0; i < n-1; i++) {
			maxNumber = arr[i+1];
			for (int j = i+1; j < n; j++) {				
				if(arr[j] > maxNumber) {
					maxNumber = arr[j];
				}
			}
			newArr[i] = maxNumber;
		}		
		newArr[n-1] = -1;
		Helpers.printArray(newArr);
		return newArr;
	}
	
	
	//A tricky method is to replace all elements using one traversal of the array. 
	//The idea is to start from the rightmost element, move to the left side one by one, 
	//and keep track of the maximum element. Replace every element with the maximum element.
	public int[] nextGreatest(int[] arr) {
		int n = arr.length;
		
		int maxFromRight = arr[n-1];
		
		arr[n-1] = -1;
		
		for (int i = n-2; i>=0; i--) {
			int temp = arr[i];
			arr[i] = maxFromRight;
			
			if(maxFromRight < temp) {
				maxFromRight = temp;
			}
		}
		
		Helpers.printArray(arr);
		return arr;
	}
}
//17,18,5,4,6,1
//18,6,6,6,1,-1 