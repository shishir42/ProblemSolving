package com.program.StackUsingLinkedList;

import com.program.Singlelinkedlist.SingleLinkedList;

public class StackByLinkedList {
	private SingleLinkedList list;
	
	public StackByLinkedList() {
		this.list = new SingleLinkedList();
	}
	
	public void push(int nodeValue) {
		//create a node
		//node.value = nodeValue
		//node.next = head
		//head = node
		
		if(this.list.getHead() == null) {
			this.list.createSingleLinkedList(nodeValue);
		}else {
			this.list.insertInLinkedList(nodeValue, 0);
		}
		System.out.println("Inserted " + nodeValue + " in Stack !");
	}
	
	public int pop() {
		//isEmpty return error message
		//tempNode = head
		//head = head.next;
		//return tempNode.value
		int value = -1;
		if(this.isEmptyStack()) {
			System.out.println("Stack underflow error...");
		}else {
			value = this.list.getHead().getValue();
			list.deletionOfNode(0);
		}		
		return value;
	}
	
	public boolean isEmptyStack() {
		if(this.list.getHead() == null) {
			return true;
		}
		return false;
	}
	
	public int peek() {
		int value = -1;
		if(this.isEmptyStack()) {
			System.out.println("Stack is empty...");
		}else {
			value = this.list.getHead().getValue();
		}		
		return value;
	}
	
	public void deleteStack() {
		list.setHead(null);
	}
}
