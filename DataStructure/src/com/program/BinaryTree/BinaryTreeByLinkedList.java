package com.program.BinaryTree;

import java.util.*;

import com.program.Node.BinaryNode;

public class BinaryTreeByLinkedList {
	BinaryNode rootNode;

	//Constructor for creating a blank Binary tree
	public BinaryTreeByLinkedList() {
		this.rootNode = null;
	}

	// inserts a new node at deepest place in Tree
	public void insertNode(int nodeValue) {
		BinaryNode node = new BinaryNode();
		node.setValue(nodeValue);		
		if(this.rootNode == null)
		{
			this.rootNode = node;
			System.out.println("Successfully inserted new node "+ nodeValue+  " at Root!!!!");
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(this.rootNode);

		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if(presentNode.getLeft() == null)
			{
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node " + nodeValue+ " at left!");
				break;
			}else if(presentNode.getRight() == null)
			{
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node" + nodeValue +" at right!");
				break;
			}else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
		}
	}

	public void deleteNode(int value) {
		if(this.rootNode == null) {
			System.out.println("No node avaiable...");
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(this.rootNode);

		while(!queue.isEmpty())
		{
			BinaryNode presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getValue() == value) {
				presentNode.setValue(getDeepestNode().getValue());
				DeleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			}else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}
	}

	public void DeleteDeepestNode() {
		if(this.rootNode == null) {
			System.out.println("No node avaiable...");
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(this.rootNode);
		BinaryNode previousNode = null, presentNode = null;
		while(!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if(presentNode.getLeft() == null) {
				previousNode.setLeft(null);
				return;
			}else if(presentNode.getRight() == null) {
				previousNode.setRight(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}		
	}

	// get last node of last level of binary tree
	public BinaryNode getDeepestNode() {
		// make an empty queue. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(this.rootNode);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
		return presentNode;
	}//end of method

	//Search for a given value in binary tree
	public void search(int value) {
		if(this.rootNode == null) {
			System.out.println("No node avaiable...");
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(this.rootNode);

		while (!queue.isEmpty()) 
		{
			BinaryNode presentNode = queue.remove();
			if(presentNode.getValue() == value)
			{
				System.out.println("Value: "+value+" is found in Tree !");
				return;
			}
			else
			{
				if(presentNode.getLeft() != null)
				{
					queue.add(presentNode.getLeft());
				}

				if(presentNode.getRight() != null)
				{
					queue.add(presentNode.getRight());
				}
			}
		}

		System.out.println("Value: " + value + " is not found in tree!!!");
	}

	// level order traversal of binary tree
	public void levelOrder() {
		if(this.rootNode == null) {
			System.out.println("No node avaiable...");
			return;
		}		

		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(this.rootNode);

		while(!queue.isEmpty())
		{
			BinaryNode presentNode = queue.remove();
			System.out.print(" " + presentNode.getValue());

			if(presentNode.getLeft() != null)
			{
				queue.add(presentNode.getLeft());
			}

			if(presentNode.getRight() != null)
			{
				queue.add(presentNode.getRight());
			}
		}
	}

	//pre-order traversal of binary tree
	public void preOrder(BinaryNode node) {
		if(node == null) {
			System.out.println("No node avaiable...");
			return;
		}

		//Root
		//Left Subtree
		//Right Subtree

		System.out.println(node.getValue() + "");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}

	//in-order traversal of binary tree
	public void inOrder(BinaryNode node) {
		if(node == null) {
			System.out.println("No node avaiable...");
			return;
		}

		//Left Subtree
		//Root
		//Right Subtree

		inOrder(node.getLeft());
		System.out.println(node.getValue() + "");
		inOrder(node.getRight());
	}

	//post-order traversal of binary tree
	public void postOrder(BinaryNode node) {
		if(node == null) {
			System.out.println("No node avaiable...");
			return;
		}

		//Left Subtree
		//Right Subtree
		//Root

		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.println(node.getValue() + "");
	}

	// Delete Tree
	public void deleteTree() {
		this.rootNode = null;
		System.out.println("Binary Tree has been deleted successfully");
	}

	// Recursive function to find the 
	// parent of the given node 
	public void findParent(BinaryNode node, int val, int parent) 
	{ 
		if(node == null) {
			//System.out.println("No node avaiable...");
			return;
		}

		// If current node is the required node 
		if (node.getValue() == val)  
		{ 
			// Print its parent 
			System.out.print(parent); 
		} 
		else 
		{ 
			// Recursive calls for the children 
			// of the current node 
			// Current node is now the new parent 
			findParent(node.getLeft(), val, node.getValue()); 
			findParent(node.getRight(), val, node.getValue()); 
		} 
	} 


	// Iterative method to do level order traversal line by line 
	public void printLevelOrder(BinaryNode root) 
	{ 
		//base case
		if(root == null) {
			System.out.println("No node avaiable...");
			return;
		} 

		// Create an empty queue for level order tarversal 
		Queue<BinaryNode> q =new LinkedList<BinaryNode>(); 
		// Enqueue Root and initialize height 
		q.add(root); 

		while(true) 
		{ 
			// nodeCount (queue size) indicates number of nodes 
			// at current level. 
			int nodeCount = q.size(); 
			if(nodeCount == 0) 
				break; 

			// Dequeue all nodes of current level and Enqueue all 
			// nodes of next level 
			while(nodeCount > 0) 
			{ 
				BinaryNode node = q.peek(); 
				System.out.print(node.getValue() + " "); 
				q.remove(); 
				if(node.getLeft() != null) {
					q.add(node.getLeft());
				}

				if(node.getRight() != null) {
					q.add(node.getRight());
				} 

				nodeCount--; 
			} 
			System.out.println(); 
		} 
	} 	
}
