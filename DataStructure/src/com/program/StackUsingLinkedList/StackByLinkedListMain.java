package com.program.StackUsingLinkedList;

public class StackByLinkedListMain {

	public static void main(String[] args) {
		StackByLinkedList stack = new StackByLinkedList();
		
		for (int i = 1; i <= 5; i++) {
			stack.push(i * 1);
		}
		System.out.println();

		System.out.println("Peeking value");
		System.out.println(stack.peek());
		System.out.println();

		System.out.println("Poping values from stack");
		for (int i = 1; i <= 5; i++) {
			System.out.println(stack.pop());
		}
		System.out.println();
	}
}
