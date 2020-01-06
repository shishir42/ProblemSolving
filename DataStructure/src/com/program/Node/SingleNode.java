package com.program.Node;

public class SingleNode {
	private int value;
	private SingleNode next;
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public SingleNode getNext() {
		return this.next;
	}
	public void setNext(SingleNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.value + " ";
	}
}
