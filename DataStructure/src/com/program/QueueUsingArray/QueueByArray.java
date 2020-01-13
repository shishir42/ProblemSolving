package com.program.QueueUsingArray;

public class QueueByArray {
	int[] arr;
	int topOfQueue;
	int beginingOfQueue;
	
	//Creation of empty queue of specified size
	public QueueByArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginingOfQueue = -1;
		System.out.println("Successfully created empty queue of size: " + size);
	}
	
	public boolean isQueueEmpty() {
		if(this.beginingOfQueue == -1) {
			return true;
		}
		return false;
	}
	
	public boolean isQueueFull() {
		if(this.topOfQueue == this.arr.length - 1) {
			return true;
		}
		return false;
	}
	
	//Queue works with FIFO
	public void enQueue(int value) {
		if(this.arr == null) {
			System.out.println("Array is not yet created. Please create one first.");
		}else if(this.isQueueFull()) {
			System.out.println("Queue Overflow error...");
		}else if(this.isQueueEmpty()) {  //if the queue is empty then we need to initialize beginning index
			this.beginingOfQueue = 0;
			this.topOfQueue++;
			this.arr[this.topOfQueue] = value;
			System.out.println("Successfully inserted " + value + "in the queue");
		}else {//if the queue already has some elements in it then no need to initialize beginning index
			this.topOfQueue++;
			this.arr[this.topOfQueue] = value;
			System.out.println("Successfully inserted " + value + "in the queue");
		}
		
		printQueue();
	}
	
	public void deQueue() {
		if(this.arr == null) {
			System.out.println("Array is not yet created. Please create one first.");
		}else if(this.isQueueEmpty()) {
			System.out.println("Queue Underflow error");
		}else {
			System.out.println("Dequeue vale from Queue...");
			System.out.println("Dequeued: " + this.arr[this.beginingOfQueue] + " from queue");
			this.beginingOfQueue++;
			if(this.beginingOfQueue > this.topOfQueue) {
				this.topOfQueue = -1;
				this.beginingOfQueue = -1;
			}
		}
	}
	
	public void peekOperation() {
		if(this.isQueueEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println(this.arr[this.beginingOfQueue]);
		}
	}
	
	public void printQueue() {
		if(this.isQueueEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println("Queue now ...");
			for(int i=this.beginingOfQueue; i<=topOfQueue; i++) {
				System.out.println(arr[i] + "   ");
			}
			System.out.println();
		}
	}
	
	public void deleteQueue() {
		arr = null;
		System.out.println("Queue is successfully deleted !");
	}
}
