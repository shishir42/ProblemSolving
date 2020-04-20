package com.program.Array;

import com.program.Helpers.Helpers;

public class ElementsWithGreatestElementOnRightSide {
	public static void main(String[] args) {
		 ElementsWithGreatestElementOnRightSideSol sol = new ElementsWithGreatestElementOnRightSideSol();
		 sol.replaceElement(new int [] {17,18,5,4,6,1});
	}
}

class ElementsWithGreatestElementOnRightSideSol{
	public int[] replaceElement(int[] arr) {
		int n = arr.length;
		int maxNumber = 0;
		int[] newArr = new int[n];
		for (int i = 0; i < n; i++) {
			maxNumber = arr[i+1];
			for (int j = i+1; j < n; j++) {				
				if(arr[j] > maxNumber) {
					maxNumber = arr[j];
				}
			}
			
			System.out.println(maxNumber);
		}
		
		Helpers.printArray(newArr);
		return newArr;
	}
}


//17,18,5,4,6,1
//18,6,6,6,1,-1 