package com.program.Sorting;

import com.program.Helpers.Helpers;

public class HeapSort {
	public static void main(String[] args) {
		int arr[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		HeapSortSol hs = new HeapSortSol(arr);
		hs.sort();
		Helpers.printArray(arr);
	}
}

class HeapSortSol{
	int[] arr = null;

	//Constructor
	public HeapSortSol(int[] arr) {
		this.arr = arr;
	}//end of method


	public void sort() {
		HeapByArray hba = new HeapByArray(arr.length); //We will reuse HeapByArray class to do sorting
		for(int i=0; i<arr.length;i++) { //Insert in Heap
			hba.insertInHeap(arr[i]);
		}
		for(int i=0; i<arr.length;i++) { //Extract from Heap and insert sorted data in current Array
			arr[i] = hba.extractHeadOfHeap();
		}
	}
}

class HeapByArray{
	int[] arr;
	int sizeOfTree;

	public HeapByArray(int size)
	{
		arr = new int[size+1];
		this.sizeOfTree=0;
	}

	public int sizeOfArray() {
		return this.arr.length;
	}

	public int sizeOfTree() {
		return this.sizeOfTree;
	}

	public boolean isEmptyHeap() {
		return this.sizeOfTree <= 0;
	}

	public void deleteHeap() {
		this.arr = null;
	}

	public void insertInHeap(int value) {
		arr[sizeOfTree+1]= value;
		sizeOfTree++;
		HeapifyBottomToTop(sizeOfTree);
		levelOrder();
	}

	public void peek() {
		if(sizeOfTree == 0) {
			System.out.println("Heap is empty");
		}else {
			System.out.println("Head of heap "+ arr[1]);
		}
	}

	public int extractHeadOfHeap() {
		if(this.sizeOfTree == 0) {
			System.out.println("Heap is empty");
			return -1;
		}else {
			int extractValue = arr[1];
			arr[1] = arr[sizeOfTree];
			sizeOfTree--;
			HeapifyTopToBottom(1);
			levelOrder();
			return extractValue;
		}
	}

	public void HeapifyBottomToTop(int index) {
		int parent = index/2;
		// We are at root of the tree. Hence no more Heapifying is required.
		if(index <= 1) {
			return;
		}
		// If Current value is smaller than its parent, then we need to swap

		if(arr[index]<arr[parent]) {
			int temp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = temp;
		}
		HeapifyBottomToTop(parent);		
	}

	public void HeapifyTopToBottom(int index) {
		int left  = index*2;
		int right = (index*2)+1;
		int smallestChild = 0;

		if (sizeOfTree < left) { //If there is no child of this node, then nothing to do. Just return.
			return; 
		}else if (sizeOfTree == left) { //If there is only left child of this node, then do a comparison and return.
			if(arr[index] > arr[left]) {
				int tmp = arr[index];
				arr[index] = arr[left];
				arr[left] = tmp;
			}
			return;
		}else { //If both children are there
			if(arr[left] < arr[right]) { //Find out the smallest child
				smallestChild = left;
			}else {
				smallestChild = right;
			}
			if(arr[index] > arr[smallestChild]) { //If Parent is greater than smallest child, then swap
				int tmp = arr[index];
				arr[index] = arr[smallestChild];
				arr[smallestChild] = tmp;
			}
		}
		HeapifyTopToBottom(smallestChild);
	}

	public void levelOrder() {
		System.out.println("Printing all the elements of this Heap...");// Printing from 1 because 0th cell is dummy
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}
}
