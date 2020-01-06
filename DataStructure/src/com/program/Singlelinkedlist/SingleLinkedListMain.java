package com.program.Singlelinkedlist;

public class SingleLinkedListMain {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.createSingleLinkedList(5);		
		list.traverseLinkedList();
		
		System.out.println("************************************************");
		
		list.insertInLinkedList(10, 1);
		list.traverseLinkedList();
		
		System.out.println("************************************************");
		
		list.insertInLinkedList(20, 2);
		list.traverseLinkedList();
		
		System.out.println("************************************************");
		
		list.insertInLinkedList(30, 2);
		list.traverseLinkedList();
		
		System.out.println("************************************************");
		
		list.insertInLinkedList(40, 1);
		list.traverseLinkedList();
	
		System.out.println("********************Insert Final****************************");
		
		list.traverseLinkedList();
		System.out.println();
				
		System.out.println("\nSearching the node having value 40...");
		list.searchNode(40);
		
		System.out.println("\nSearching the node having value 80...");
		list.searchNode(80);
		
		System.out.println("********************Delete Final****************************");
		//list.deletionOfNode(6);
		//list.traverseLinkedList();
		
		System.out.println("\n\nDeleting the node having location = 2: ");
		System.out.println("Before Deletion:");
		list.traverseLinkedList();
		list.deletionOfNode(2);
		System.out.println("After Deletion:");
		list.traverseLinkedList();
		System.out.println();
		
		System.out.println("*********************End*********************");
//		list.deleteAllNodeFromLinkedList();
//		list.createSingleLinkedList(100);
//		list.traverseLinkedList();
//		list.deletionOfNode(1);
//		System.out.println("Delete After Node Creation");
//		list.traverseLinkedList();
	}
}
