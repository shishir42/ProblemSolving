package com.program.SingleCircularLinkedList;

import com.program.Node.SingleNode;

//In the case of a circular doubly linked list, the only change that occurs is that end of the given list is linked back to the front
//Ex: multiple player board game. If we want to tracking players turn in linked list

//1.Escalator
//2.Time sharing problem used by the scheduler during the scheduling of the processes in the Operating system.
//3.Multiple Player board game
//4.Useful for implementation of queue. Unlike this implementation, we don’t need to maintain two pointers for front and rear if we use circular linked list. We can maintain a pointer to the last inserted node and front can always be obtained as next of last.
//5.Circular lists are useful in applications to repeatedly go around the list. For example, when multiple applications are running on a PC, it is common for the operating system to put the running applications on a list and then to cycle through them, giving each of them a slice of time to execute, and then making them wait while the CPU is given to another application. It is convenient for the operating system to use a circular list so that when it reaches the end of the list it can cycle around to the front of the list.
//6.Circular Doubly Linked Lists are used for implementation of advanced data structures like Fibonacci Heap.

//A simple example is keeping track of whose turn it is in a multi-player board game. Put all the players in a circular linked list. 
//After a player takes his turn, advance to the next player in the list. This will cause the program to cycle indefinitely among the players.

//Circular linked list should be used is a timesharing problem solved by the operating system. 
//The OS will pick a user; let it use a small amount of CPU time and then move on to the next user, etc.

//Circular linked list is the basic idea of round robin scheduling algorithm.

//A circularly linked list may be a natural option to represent arrays that are naturally circular, e.g. the corners of a polygon.

//Concept: One way direction in a circle
//Has head: No-because tail will refer to first node
//Has tail: Yes
//No of Node: 1-next node
//insert: 
//delete: 
//Benefit: execute to the end can be quickly.

public class SingleCircularLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size;

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public SingleNode createSingleLinkedList(int nodeValue) {
		SingleNode node = new SingleNode();
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
			SingleNode tempNode = head;
			for (int i = 0; i < this.getSize(); i++) {
				System.out.println(tempNode.getValue());
				if(i != this.size-1) {
					System.out.println(" --> ");
				}
				tempNode = tempNode.getNext();
			}
			System.out.println("\n");
		}else {
			System.out.println("\n Linked List does not exist");
		}
	}

	// Traverse Linked List using head and tail
	public void printHeadusingTail() {
		if(existsLinkedList()) {
			System.out.println("Printing Head.....");
			System.out.println(this.head.getValue());

			System.out.println("Printing Tail......");
			System.out.println(this.tail.getValue());

			System.out.println("Printing head using tail reference");
			System.out.println(this.tail.getNext().getValue());			
		}else {
			System.out.println("\n Linked List does not exist");
		}
	}

	public void insertLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		System.out.println("Inserting new node at location: " + location);
		if(!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return;
		}else if(location == 0) {// insert at first position
			node.setNext(head); // Here head having a reference of first node, so we need to break the link for new node inserted
			//Set the new node of next to head which the reference of first node, once done then it will create a linked between new inserted
			//node and first node

			head = node;  //Here we need to update head and assign the new node so that it will create a new linked between 
			// head and new node and break the linked between head and first node.

			tail.setNext(node); //Here currently tail node is pointing to last node and last node having a reference of first 
			//So we need to update the tail with the reference of new node so that last node and tail pointing to new node 
		}else if(location >= size) { //// insert at last position
			node.setNext(head); //Linked the new node with first node which has the reference pointing to head
			// Now new node is pointing to first node

			tail.setNext(node); // set the reference of last node to new node, now we have reference of last node and new node

			tail = node; // Tail node now pointing to new node and linked got destroyed between tail and last node

			//tail.setNext(head); or //node.setNext(head); //both are doing the same operation
		}else { //insert at specified location
			SingleNode tempNode = head;
			int index = 0;
			while(index < location - 1) { // loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}//tempNode currently references to node after which we should insert new node

			SingleNode nextNode = tempNode.getNext(); //this is the immediate next node after new node

			tempNode.setNext(node);//update reference of tempNode to reference to new node
			//linked get created between  previous node and new node 

			node.setNext(nextNode);//update newly added nodes' next.
			//linked get created between  new node and next node 
		}

		this.setSize(this.getSize() + 1);
	}

	//Searches a node with given value
	public boolean searchNode(int nodeValue) {
		if(existsLinkedList()) {
			SingleNode tempNode = head;
			for(int i = 0;i < getSize(); i++ ) {
				if(tempNode.getValue() == nodeValue) {
					System.out.print("Found node " + nodeValue + " at location: "+ (i + 1) +"\n");
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! \n");
		return false;
	}

	////Deletes a node having a given value
	public void deleteOfNode(int location) {
		if(!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		}else if(location == 0) {
			head = head.getNext(); // updating the reference of head to the second node i.e now head is pointing to second node(become first node)
			//Here once the head node pointing to second node then first node automatically deleted from list and it will collected by garbage 

			tail.setNext(head); //now we need to update the last node reference pointing to first node i.e head node. And this 
			// will delete the reference from previous pointing first node and last node.

			setSize(getSize()-1);

			//In case of only one node then head = head.getnext(); head = null and also set the tail = null, 
			//then it will destroyed the link between head and tail to node
			if(getSize() == 0) { // if there are no more nodes in this list
				tail = null;
			}	
		}else if(location >= getSize()) {
			SingleNode tempNode = head;
			for (int i = 0; i < size - 1; i++) {
				tempNode = tempNode.getNext(); //temp node points to 2nd last node
			}
			if (tempNode == head) { //if this is the only element in the list
				tail = head = null;
				setSize(getSize()-1);
				return;
			}
			tempNode.setNext(head); 
			tail= tempNode;
			setSize(getSize()-1);
		}else {
			//if any inside node is to be deleted
			SingleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the previous location
			}

			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			setSize(getSize()-1);
		}
	}

	//Delete linked list
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		if(tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete !");
			return;
		}else {
			tail.setNext(null);
			tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}
}

















