package com.program.DoubleLinkedList;

public class DoubleLinkedListMain {

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.createDoubleLinkedList(5);
		list.traverseLinkedList();
		
		list.insertInLinkedList(10, 1);
		list.traverseLinkedList();
		
		list.insertInLinkedList(20, 2);
		list.traverseLinkedList();
		
		list.insertInLinkedList(30, 3);
		
		System.out.println("\n\nLinked List in order");
		list.traverseLinkedList();
		System.out.println("Linked List in reverse order");
		list.traverseLinkedListInReverseOrder();
		
		System.out.println("*********************************************");
		list.searchNode(20);
		list.searchNode(1111);
		
		System.out.println("\n\nDeleting the node having location = 2: "); //index starting from zero
		System.out.println("List before deletion: ");
		list.traverseLinkedList();
		list.deletionOfNode(2);
		System.out.println("List after deletion: ");
		list.traverseLinkedList();
	}

}
