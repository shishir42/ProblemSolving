package com.program.BinaryHeap;

public class BinaryHeapByArray {
	int[] arr;
	int sizeOfTree;
	
	public BinaryHeapByArray(int size) {
		arr = new int[size + 1];//We are adding 1 here so that first cell of the array can be left blank all the time. This is eliminate problem of array starting from index 0.
		this.sizeOfTree = 0;
		System.out.println("Empty Heap Created...");		
	}
	
	public int sizeOfArray() {
		return arr.length;
	}
	
	public int sizeOfTree() {
		return this.sizeOfTree;
	}
	
	public boolean isHeapEmpty() {
		if(this.sizeOfTree() <= 0) {
			return true;
		}
		
		return false;
	}
	
	public void deleteHeap() {
		this.arr = null;
	}
	
	public void insertHeap(int value) {
		System.out.println("Insert" + value +" value at heap ");
		arr[sizeOfTree + 1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree);
		System.out.println("Inserted " + value + " successfully in Heap !");
		levelOrder();
	}

	public void peek() {
		if(sizeOfTree <= 0) {
			System.out.println("Heap is empty");
		}else {
			System.out.println("Peek of Binary Heap " + this.arr[1]);
		}
	}
	
	public int extractHeadofHeap() {
		if(sizeOfTree == 0) {
			System.out.println("Heap is empty");
			return -1;
		}else {
			System.out.println("Head of the Heap is: " + arr[1]);
			System.out.println("Extracting it now...");
			int extractedValue = arr[1];
			arr[1] = arr[sizeOfTree];
			sizeOfTree--;
			heapifyTopToBottom(1);
			System.out.println("Successfully extracted value from Heap.");
			levelOrder();
			return extractedValue;
		}
	}
	
	private void heapifyTopToBottom(int index) {
		int left = index*2;
		int right = (index*2) + 1;
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
		heapifyTopToBottom(smallestChild);
	}

	private void heapifyBottomToTop(int index) {
		int parent = index / 2;
		// We are at root of the tree. Hence no more Heapifying is required.
		if (index <= 1) {
			return;
		}
		// If Current value is smaller than its parent, then we need to swap
		if (arr[index] < arr[parent]) {
			int tmp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = tmp;
		}
		heapifyBottomToTop(parent);
	}
	
	private void levelOrder() {
		System.out.println("Printing all the elements of this Heap...");// Printing from 1 because 0th cell is dummy
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}
}
