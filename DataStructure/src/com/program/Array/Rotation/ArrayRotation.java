//a b c d 
//d a b c

package com.program.Array.Rotation;

import com.program.Helpers.Helpers;

public class ArrayRotation {
	public static void main(String[] args) {
		ArrayRotationSol sol = new ArrayRotationSol();
		int[] arr = { 1, 2, 3, 4, 5};
		Helpers.printArray(sol.rotateByK(arr, 1));
		Helpers.printArray(sol.rotateByK(arr, 2));
		Helpers.printArray(sol.rotateByK(arr, 3));
	}
}

class ArrayRotationSol{
	public void rotateArray(int[] arr) {
		int n = arr.length;
		int temp = arr[n-1];
		for (int i = n-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}
	
	public int[] rotateByK(int[] arr, int k) {
		while(k != 0) {
			rotateArray(arr);
			k--;
		}
		return arr;
	}
}