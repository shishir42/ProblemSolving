package com.program.DoubleCircularLinkedList;

import com.program.Node.DoubleNode;

//In the case of a circular doubly linked list, the only change that occurs is that end of the given list is linked back 
//to the front of the list and vice versa
public class DoubleCircularLinkedList {
	private DoubleNode head;
	private DoubleNode tail;
	private int size;// denotes size of list

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public DoubleNode createDoubleLinkedList(int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		this.head = node;
		this.tail = node;
		this.size = 1;
		return this.head;
	}

	public boolean existsLinkedList() {
		return this.head != null; // if head is not null return true otherwise return false
	}

	//Traverses Linked List
	public void traverseLinkedList() {
		if(existsLinkedList()) {
			DoubleNode tempNode = head;
			for (int i = 0; i < this.getSize(); i++) {
				System.out.println(tempNode.getValue());
				if(i != this.getSize() - 1) {
					System.out.println("-->");
				}
				tempNode = tempNode.getNext();
			}
		}else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println("\n");
	}

	public void traverseLinkedListInReverseOrder() {
		if(existsLinkedList()) {
			DoubleNode tempNode = tail;
			for (int i = 0; i < this.getSize(); i++) {
				System.out.println(tempNode.getValue());
				if(i != this.getSize() - 1) {
					System.out.println("<--");
				}
				tempNode = tempNode.getPrevious();
			}
		}else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println("\n");
	}

	// Traverse Linked List
	void printHeadUsingTail() {
		if (existsLinkedList()) {
			System.out.println("\n\nPrinting Tail...");
			System.out.println(tail.getValue());

			System.out.println("\nPrinting Head using Head reference...");
			System.out.println(head.getValue());

			System.out.println("\nPrinting Head using Tail reference...");
			System.out.println(tail.getNext().getValue());

		} else {
			System.out.println("Linked List does not exists");
		}
	}

	public void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return; // Linked List does not exists
		} else if (location == 0) {// insert at first position
			node.setNext(head); // linked create between new node and first node
			node.setPrevious(tail); //linked create between new node and last node
			head.setPrevious(node); //linked create between first node and new node
			head = node; //linked create between head and new node and it will destroyed the linked between head and first node
			tail.setNext(node);//linked create between last node and new node and it will destroyed the linked between first node and last node			
		}else if(location >= getSize()) {// insert at last position
			node.setNext(head); //linked create between new node and first node
			node.setPrevious(tail); //linked create between new node and last node
			head.setPrevious(node); //linked create between first node and new node
			tail.setNext(node); //linked create between last node and new node and it will destroyed the linked between first node and last node
			tail = node; //linked create between tail and new node and it will destroyed the linked between tail and last node
		}else {// insert at specified location
			DoubleNode tempNode = head;
			int index = 0;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}//tempNode currently references to node after which we should insert new node			
			
			node.setNext(tempNode.getNext()); //linked created between new node and next node
			node.setPrevious(tempNode); //linked created between new node node and previous node
			tempNode.setNext(node); //linked created between previous node and new node
			node.getNext().setPrevious(node); // linked created between next node and new node
		}
		this.setSize(this.getSize() + 1);
	}

	// Searching a specified value in linked list
	public boolean searchNode(int nodeValue) {
		if (existsLinkedList()) {
			DoubleNode tempNode = head;
			traverseLinkedList();
			for (int i = 0; i < size; i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! ");
		return false;
	}

	// Deletes a node having a given value
	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			if (getSize() == 1) { // if this is the only node in this list
				head.setNext(null);
				head.setPrevious(null);
				head = tail = null;
				setSize(getSize() - 1);
				return;
			}else {
				head = head.getNext();
				head.setPrevious(null);
				tail.setNext(head);
				setSize(getSize() - 1);
			}
		} else if (location >= getSize()) { // If location is not in range or equal, then delete last node
			if (getSize() == 1) { // if this is the only element in the list
				head.setNext(null);
				head.setPrevious(null);
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tail = tail.getPrevious();
			tail.setNext(head);
			head.setPrevious(tail);
			setSize(getSize() - 1);
		} else { // if any inside node is to be deleted
			DoubleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			tempNode.getNext().setPrevious(tempNode);
			setSize(getSize() - 1);
		} // end of else
	}

	//Deletion of linked list
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		if (tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete anymore !");
			return;
		}else {
			head.setPrevious(null);
			tail.setNext(null);
			head = null;
			tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}
}
