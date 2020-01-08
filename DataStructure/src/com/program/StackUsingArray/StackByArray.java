package com.program.StackUsingArray;

public class StackByArray {
	int[] arr;
	int topOfStack; //keep the track of the cell which is last occupied in Array, this will help in insertion/deletion
	
	public StackByArray(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("Successfully created an empty Stack of Size: " + size);
	}
	
	public boolean isEmptyStack() {
		if(this.topOfStack == -1) {
			System.out.println("Stack is empty");
			return true;
		}
		return false;
	}
	
	public boolean isFullStack() {
		if(this.topOfStack == this.arr.length - 1) {
			System.out.println("Stack is full");
			return true;
		}
		return false;
	}
	
	public void peekOperation() {
		if(!this.isEmptyStack()) {
			System.out.println("Top of stack " + this.arr[this.topOfStack]);
		}else {
			System.out.println("Stack is empty");
		}
	}
	
	public void push(int value) {
		if(this.isFullStack()) {
			System.out.println("Stack Overflow Error....");
		}else {
			this.arr[this.topOfStack + 1] = value;
			this.topOfStack++;
			System.out.println("Successfully inserted " + value + "in the stack");
		}
	}
	
	public void pop() {
		if(this.isEmptyStack()) {
			System.out.println("Stack Underflow error....");
		}else {
			System.out.println("Poping value from stack " + this.arr[this.topOfStack] + "....");
			this.topOfStack--;
		}
	}
	
	public void deleteStack() {
		this.arr = null;
		System.out.println("Stack is successfully deleted");
	}
}
