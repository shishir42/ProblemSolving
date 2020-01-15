package com.program.QueueByLinkedList;

public class QueueByLinkedListMain {

	public static void main(String[] args) {
		System.out.println("Creating a queue");
		QueueByLinkedList queue = new QueueByLinkedList();
				
		System.out.println("Enqueueing 6 values into queue");
		for(int i=1 ; i<=6; i++) {
			queue.enQueue(i*10);
		}
		System.out.println();
		
		System.out.println("Peeking value");
		queue.peek();
		System.out.println();
		queue.traverseList();
		
		System.out.println("Dequeueing value into queue");
		queue.deQueue();
		System.out.println("Print List after deque value");
		queue.traverseList();
	}

}
