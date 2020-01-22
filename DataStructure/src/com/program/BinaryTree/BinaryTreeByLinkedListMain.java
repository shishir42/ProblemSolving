package com.program.BinaryTree;

public class BinaryTreeByLinkedListMain {

	public static void main(String[] args) {
		//Creating a blank tree
		BinaryTreeByLinkedList tree = new BinaryTreeByLinkedList();
		
		//Insert 10 nodes in the tree
		System.out.println("Inserting 10 nodes to tree...");
		for (int i = 1; i <= 10; i++) {
			tree.insertNode(i * 10);
		}
		
		System.out.println();
		System.out.println("Traverse Level Order Tree");
		tree.levelOrder();
		
		
		System.out.println();
		System.out.println("Print Level Tree");
		tree.printLevelOrder(tree.rootNode);
		
		System.out.println();
		System.out.println("Print Parent of Given Node in a Tree");
		tree.findParent(tree.rootNode, 70, -1);
		
		System.out.println();
		System.out.println("\nPre-order of tree:");
		tree.preOrder(tree.rootNode);
		
		System.out.println();
		System.out.println("\nIn-order of tree:");
		tree.inOrder(tree.rootNode);
		
		System.out.println();
		System.out.println("\nPost-order of tree:");
		tree.postOrder(tree.rootNode);
		
		System.out.println("\nSearching node 50 in the tree...");
		tree.search(50);
		System.out.println();
		tree.search(120);
		
		System.out.println("\nDeleting node having value-50 in the tree...");
		tree.deleteNode(50);
		tree.levelOrder();
		System.out.println();
		
		System.out.println("\n\nDeleting node having value-10 in the tree...");
		tree.deleteNode(10);
		tree.levelOrder();
		
		System.out.println();
		System.out.println();
		
		System.out.println("Deleting the entire Tree");
		tree.deleteTree();
	}
}


//https://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/
//https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/