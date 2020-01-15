package com.program.QueueByLinkedList;

import com.program.Node.SingleNode;
import com.program.Singlelinkedlist.SingleLinkedList;

//When to use
//1.Helps manage the data in particular way(FIFO)
//2.not easily corrupted (No one can easily insert the data in middle)

//When to avoid
//Random access not  possible-if we have done some mistake, its costly to rectify 

public class QueueByLinkedList {
	SingleLinkedList singleLinkedList;
	
	public QueueByLinkedList() {
		this.singleLinkedList = new SingleLinkedList();
	}
	
	public boolean isQueueEmpty() {
		if(this.singleLinkedList.getHead() == null) {
			return true;
		}
		return false;
	}
	
	public void deleteStack() {
		if(this.singleLinkedList != null) {
			this.singleLinkedList.setHead(null);
		}
	}
	
	public void peek() {
		if(this.isQueueEmpty()) {
			System.out.println("Queue is empty");
		}else {
			System.out.println("Peek: " + this.singleLinkedList.getHead().getValue());
		}
	}
	
	public void enQueue(int value) {
		//create a node
		//node.value = nodeValue
		//node.next = null
		
		//if tail equals is null or queue is empty
		//head = tail = node
		//else if queue is not empty
		//tail.next = node
		//tail = node
		
		if(this.singleLinkedList.getHead() == null) {
			this.singleLinkedList.createSingleLinkedList(value);
		}else {
			// push a value on last of queue, update list tail too
			this.singleLinkedList.insertInLinkedList(value, this.singleLinkedList.getSize());
		}
	}
	
	public void deQueue() {
		//if head is null
		//then error
		
		//tmpNode = head
		//head = head.next
		//print tempNode.value
		SingleNode tempNode = null;
		if(this.isQueueEmpty()) {
			System.out.println("Queue is empty");
		}else {
//			tempNode = this.singleLinkedList.getHead();
//			this.singleLinkedList.setHead(this.singleLinkedList.getHead().getNext());
//			System.out.println("Deque:" + tempNode.getValue());
			
			System.out.println("Deque: " + this.singleLinkedList.getHead().getValue());
			this.singleLinkedList.deletionOfNode(0);
		}
	}
	
	public void traverseList() {
		if(!this.isQueueEmpty()) {
			this.singleLinkedList.traverseLinkedList();
		}
	}
}


















