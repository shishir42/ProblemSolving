package com.program.CircularQueueUsingArray;

//Dequeue Operation causes blank cells linear Queue(Array Implementation). We need improve that.
//if we delete the dequeue element the previous element index is unused.

//one way to solved above problem is shift element to the extreme left in the array 
//Problem with this solution, every time we dequeue the element from the array, then we need to shift element every time 
//and time complexity will be O(n)

//Circular helps to solved above problem and it be constant time O(n).

public class CircularQueueByArray {
	int[] arr;
	int size;
	int topOfQueue;
	int start;
	
	public CircularQueueByArray(int size) {
		this.arr = new int[size];
		this.size = size;
		this.topOfQueue = -1;
		this.start = -1;
	}
	
	public void initializeStartOfArray() {
		if (start == -1) { 
			start = 0;
		}
	}
	
	public void enQueue(int value) {
		if(this.arr == null) {
			System.out.println("Array is not yet created. Please create one first.");
		}else if(this.isQueueFull()) {
			System.out.println("Queue Overflow error");
		}else {
			this.initializeStartOfArray();
			if(this.topOfQueue+1 == this.size) {//if top is already at last cell of array, then reset it to first cell
				this.topOfQueue = 0;
			}else {
				this.topOfQueue++;
			}
			this.arr[this.topOfQueue] = value;
			System.out.println("\nSuccessfully inserted "+value+" in the queue");
		}
	}
	
	public void deQueue() {
		if (isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			System.out.println("\n---------------------------------------------");
			System.out.println("Before Dequeue..");printArray();
			System.out.println("\nDequeing value from Queue...");
			System.out.println("Dequeued: "+arr[start]+" from queue");
			arr[start] = 0; //initialize the unused cell to 0
			if (start == topOfQueue) { //if there is only 1 element in Queue
				start = topOfQueue = -1;
			}else if (start+1 == size) { //if start has reached end of array, then start again from 0
				start=0;
			}else {
				start++;
			}
		}
		System.out.println("After Dequeue..");printArray();
		System.out.println("---------------------------------------------");
	}
	
	public boolean isQueueEmpty() {
		if(this.topOfQueue == -1) {
			return true;
		}
		return false;
	}
	
	public boolean isQueueFull() {
		if(this.topOfQueue + 1 == this.start) {//If we have completed a circle, then we can say that Queue is full
			return true;
		}else if((this.start == 0) && (this.topOfQueue+1 == this.size)) {//Trivial case of Queue being full
			return true;
		}
		return false;
	}
	
	public void peekOperation() {
		if(this.isQueueEmpty()) {
			System.out.println("Queue is empty...");
		}else {
			System.out.println(this.arr[this.start]);
		}
	}
	
	public void deleteStack() {
		System.out.println("\n\nDeleting the entire Queue...");
		arr = null;
		System.out.println("Queue is successfully deleted !");
	}
	
	public void printArray() {
		System.out.println("Array now...");
		for(int i=0; i<size; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\nStart = " + start);
		System.out.println("End = "+ topOfQueue);
	}
}
