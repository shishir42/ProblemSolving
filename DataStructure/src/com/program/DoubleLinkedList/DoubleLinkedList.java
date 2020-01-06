package com.program.DoubleLinkedList;

import com.program.Node.DoubleNode;

//In double linked list each node contains two references, that references to the previous and next node.
//Ex: Music player which has next and previous buttons
//Disadvantage: when your are in last node and automatically control want to go in the first node, then not possible with double linked list
//Time Complexity: O(n)
//Space Complexity: O(1)

//1.DNA molecules
//2.Browser cache which allows to use BACK button.
//3.Train coaches are connected with the next and the previous ones.
//4.Roller chain of bicycle(doubly circular linked list)
//5.A great way to represent a deck of cards in a game.
//6.The browser cache which allows you to hit the BACK button (a linked list of URLs)
//7.Applications that have a Most Recently Used (MRU) list (a linked list of file names)
//8.A stack, hash table, and binary tree can be implemented using a doubly linked list. 
//9.Undo functionality in Photoshop or Word (a linked list of state)

//Concept: two way direction
//Has head: Yes
//Has tail: Yes
//No of Node: 2-next node and previous node
//insert: 
//delete: 
//Benefit: allow to traverse the list in both directions


public class DoubleLinkedList {
	private DoubleNode head;
	private DoubleNode tail;
	private int size;

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
		node.setPrevious(null);
		this.head = node;
		this.tail = node;
		this.size = 1;
		return head;
	}

	public boolean existsLinkedList() {
		return this.head != null; //// if head is not null return true otherwise return false
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

	public void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		System.out.println("Inserting new node at location: " + location);
		if(!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		}else if(location == 0) {// insert at first position
			node.setNext(head); // set the reference of first node in the next of new node, 
			//so that it will create linked between new node and first node

			node.setPrevious(null); // set the new node previous to null because it will become a first node of linked list

			head.setPrevious(node); // set the reference of new node in the previous of new node, so that
			//it will generate a linked between first node and new node

			head = node; // we need to update the head reference to new node, so that it generate the linked between 
			// head with new node and disconnect the linked between head and first node

		}else if(location >= this.size) {// insert at last position
			node.setNext(null);  //set the null in the next of new node, because after this there is no more node in the list
			node.setPrevious(tail); // set the new node previous to tail, so that the link get generated between
			//new node and last node
			tail.setNext(node); // set the last node previous to new node, so that the link get generated between 
			//last node and new node
			tail = node; // update the tail node to the new node, so that it destroyed the link between tail and last node 
			// and it will generate a link between new node(which become a last node) and tail
		}else {// insert at specified location
			DoubleNode tempNode = head;
			int index = 0;
			while(index < location -1) {
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

	//Searches a node with given value
	public boolean searchNode(int nodeValue) {
		if(existsLinkedList()) {
			DoubleNode tempNode = head;
			for (int i = 0; i < this.getSize(); i++) {
				if(tempNode.getValue() == nodeValue) {
					System.out.print("Found node " + nodeValue + " at location: "+ (i + 1) +"\n");
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
		if(!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		}else if(location == 0) { // we want to delete first element
			if (getSize() == 1) { // if this is the only node in this list
				head = tail = null;//linked get destroyed between head and tail with first node 
				setSize(getSize() - 1);
				return;
			}else {
				head = head.getNext();// updating the reference of head to the second node i.e now head is pointing to second node(become first node)
				//Here once the head node pointing to second node then first node automatically deleted from list and it will collected by garbage 

				head.setPrevious(null); //update the reference of previous with head so that the first node is get deleted from head and next node
				//now next node become the first node which is pointing to head
				setSize(getSize() - 1);
			}
		}else if (location >= getSize()) { //If location is not in range or equal, then delete last node
			//Here we have checked >= that means any how user want to delete the last node
			//if not then if location > this.size then show the error that node is not present

			DoubleNode tempNode = tail.getPrevious(); // temp node points to 2nd last node 
			if (tempNode == head) { // if this is the only element in the list
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}

			tail = tempNode; ////here we are deleting last node which is node4
			//linked get created between tail and node 3 and destroyed between node 4 and tail
			tempNode.setNext(null); //last node of next should be set to null
			setSize(getSize() - 1);			
		}else { //if any inside node is to be deleted
			DoubleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			tempNode.getNext().setPrevious(tempNode);
			setSize(getSize() - 1);
		}
	}

	//delete whole linked list
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		DoubleNode tempNode = head;
		for (int i = 0; i < size; i++) {
			tempNode.setPrevious(null);
			tempNode = tempNode.getNext();
		}

		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully !");
	}
}











