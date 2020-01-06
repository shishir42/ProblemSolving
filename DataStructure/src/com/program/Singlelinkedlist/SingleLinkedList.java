package com.program.Singlelinkedlist;

import com.program.Node.SingleNode;

//In a single linked list each node in the list stores the data of the node and a reference  to the next node in the list.
//It does not store the any reference to the previous node

//How linked list stored in memory 
//.memory are stored as non-contiguous allocation 
//.create as many node whenever required
//.we cannot access node directly, need to traverse from head to tail


//Advantages over arrays
//1) Dynamic size
//2) Ease of insertion/deletion

//Drawbacks:
//1) Random access is not allowed. We have to access elements sequentially starting from the first node. 
//So we cannot do binary search with linked lists efficiently with its default implementation. Read about it here.
//2) Extra memory space for a pointer is required with each element of the list.
//3) Not cache friendly. Since array elements are contiguous locations, there is locality of reference which is not there in case of linked lists.

//One of the biggest drawbacks is that, given there items are not stored in adjacent memory, 
//operations like itemAtIndex will have a O(n) complexity because you will need to traverse your input to get to the specified index.

//1.Human brain of a child(In order to remember something eg . poem he has to link it , 
//if you will ask him the last line he will have to read from the first line)

//2.message delivery on network (message is broken into packets and each packet has a key 
//of the next one so that at the receiver's end , it will be easy to club them)

//3.Implementation of stacks and queues
//4.Implementation of graphs : Adjacency list representation of graphs is most popular which is uses linked list to store adjacent vertices.
//5.Dynamic memory allocation : We use linked list of free blocks.
//6.Maintaining directory of names
//7.Performing arithmetic operations on long integers
//8.Manipulation of polynomials by storing constants in the node of linked list
//9.representing sparse matrices
//10.Undo button of any application like Microsoft Word, Paint, etc: A linked list of states.
//11.GPS Navigation: A linked list of map data. Travelling from origin to destination is example of traversing through all nodes. Rerouting by a GPS is an example of Add and Remove operations of map data.

//Applications of linked list in real world-
//Image viewer – Previous and next images are linked, hence can be accessed by next and previous button.
//Previous and next page in web browser – We can access previous and next url searched in web browser by pressing back and next button since, they are linked as linked list.
//Music Player – Songs in music player are linked to previous and next song. you can play songs either from starting or ending of the list.

//Real work application example link: https://medium.com/journey-of-one-thousand-apps/data-structures-in-the-real-world-508f5968545a

//Some of the major application :
//1. Tree
//2. Graph
//3. Stack
//4. Queue
//5. LRU/MRU
//6. Symbol table management in compiler design
//7. Hash table

//Concept: one way direction
//Has head: Yes
//Has tail: Yes
//No of Node: 1-next node
//insert: 
//delete: 
//Benefit: require small space for each element

public class SingleLinkedList {
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
		return this.head != null; //// if head is not null return true otherwise return false
	}

	//Traverses Linked List
	public void traverseLinkedList() {
		if(existsLinkedList()) {
			SingleNode tempNode = head;
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

	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		System.out.println("Inserting new node at location: " + location);
		if(!this.existsLinkedList()) {  //Linked List not exist
			System.out.println("The linked list does not exist!!");
			return;
		}else if(location == 0) {// insert at first position
			//set the reference of head to the next of new node, once the reference happen
			// then linked get created between new node and first node.
			node.setNext(head); 

			//Next, we have to point head and new node, then cancelled the linked between head and first node
			node = head;
		}else if(location >= this.size) {// insert at last position 
			
			//Set the null in the next of new node, so this will indicate that there is no more node 
			node.setNext(null);

			//Update the previous node(last node) reference to the new node reference, 
			//so that it will create an linked between previous node(last node) with new node
			tail.setNext(node);

			//Pointing tail reference to the newly added node which is last node and connection between last node and tail got disconnected 
			tail = node;
		}else { // insert at specified location
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

	//Deletes a node having a given value
	public void deletionOfNode(int location) {
		//.Delete the first node: 2 cases 
		// Delete the node which having only single node
		// Delete the first node which have multiple node

		//.Delete the last node: 2cases
		// Delete the node which have only single node
		// Delete the last node which have multiple  node

		if(!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		}else if(location == 0) { // we want to delete first element
			head = head.getNext(); // updating the reference of head to the second node i.e now head is pointing to second node(become first node)
			//Here once the head node pointing to second node then first node automatically deleted from list and it will collected by garbage 

			setSize(getSize() - 1);

			//In case of only one node then head = head.getnext(); head = null and also set the tail = null, 
			//then it will destroyed the link between head and tail to node
			if(getSize() == 0) { // if there are no more nodes in this list
				tail = null;
			}
		}else if (location >= getSize()) { //If location is not in range or equal, then delete last node
			//Here we have checked >= that means any how user want to delete the last node
			//if not then if location > this.size then show the error that node is not present
			
			SingleNode tempNode = head;
			for (int i = 0; i < getSize() - 1; i++) {
				tempNode = tempNode.getNext(); //temp node points to 2nd last node
			}

			if (tempNode == head) { //if this is the only element in the list
				tail = head = null;
				setSize(getSize()-1);
				return;
			}
			tempNode.setNext(null); 
			tail= tempNode;
			setSize(getSize()-1);
		}else { //if any inside node is to be deleted
			SingleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the previous location
			}
			
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			setSize(getSize()-1);
		}
	}

	//Deletes entire Linked List
	void deleteAllNodeFromLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully !");
	}
}