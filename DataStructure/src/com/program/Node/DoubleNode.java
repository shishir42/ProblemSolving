package com.program.Node;

public class DoubleNode {
	private int value;
	private DoubleNode next;
	private DoubleNode previous;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public DoubleNode getNext() {
		return next;
	}
	public void setNext(DoubleNode next) {
		this.next = next;
	}
	public DoubleNode getPrevious() {
		return previous;
	}
	public void setPrevious(DoubleNode previous) {
		this.previous = previous;
	}
	@Override
	public String toString() {
		return value + "";
	}
}
