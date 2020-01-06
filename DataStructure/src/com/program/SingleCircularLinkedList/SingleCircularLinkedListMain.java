package com.program.SingleCircularLinkedList;

public class SingleCircularLinkedListMain {

	public static void main(String[] args) {
		SingleCircularLinkedList list = new SingleCircularLinkedList();
		list.createSingleLinkedList(1);  // Zeroth position
		list.insertLinkedList(2, 1);     // first position
		list.insertLinkedList(3, 2);
		list.insertLinkedList(4, 3);
		list.traverseLinkedList();  
		System.out.println("**********************************************");
		list.insertLinkedList(33, 3);
		list.traverseLinkedList();		
		System.out.println("**********************************************");
		list.searchNode(33);
		System.out.println("**********************************************");
		list.printHeadusingTail();
		System.out.println("*********************Before*************************");
		list.traverseLinkedList();		
		list.deleteOfNode(3); // starting from zero
		System.out.println("*********************After*************************");
		list.traverseLinkedList();
	}

}
