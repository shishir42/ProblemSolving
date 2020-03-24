package com.program.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import com.program.Node.BinaryNode;

public class BinarySearchTreeByLinkedList {
	BinaryNode root;

	// Constructor
	public BinarySearchTreeByLinkedList() {
		root = null;
	}

	public BinaryNode createNewNode(int nodeValue) {
		BinaryNode node = new BinaryNode();
		node.setValue(nodeValue);
		return node;
	}

	// Search a node in BST
	public void searchForValue(int value) {
		BSTSearch(root, value);
	}

	public BinaryNode BSTSearch(BinaryNode node, int nodeValue) {
		if(node == null) {
			System.out.println("Value not found");
			return null;
		}

		if(node.getValue() == nodeValue){
			System.out.println("Value found");
			return node;
		}

		if(nodeValue < node.getValue()) {
			return BSTSearch(node.getLeft(), nodeValue);
		}else {
			return BSTSearch(node.getRight(), nodeValue);
		}
	}

	public void LevelOrderTraversal() {
		Queue<BinaryNode> node = new LinkedList<BinaryNode>();
		node.add(root);

		if(root == null)
		{
			System.out.println("Tree does not exist");
			return;
		}

		while(!node.isEmpty()) {
			BinaryNode presentNode = node.remove();
			System.out.print(presentNode.getValue() + " ");
			if(presentNode.getLeft() != null)
			{
				node.add(presentNode.getLeft());
			}

			if(presentNode.getRight() != null)
			{
				node.add(presentNode.getRight());
			}
		}
	}

	// Insert values in BST
	public	void insert(int value) {
		root = InsertNode(root, value);
	}

	public BinaryNode InsertNode(BinaryNode currentNode, int nodeValue) {
		if(currentNode == null) {
			return this.createNewNode(nodeValue);
		}else if(nodeValue <= currentNode.getValue()) {
			currentNode.setLeft(InsertNode(currentNode.getLeft(), nodeValue));
			return currentNode;
		}else {
			currentNode.setRight(InsertNode(currentNode.getRight(), nodeValue));
			return currentNode;
		}
	}

	// Deleting a node from BST
	public void deleteNodeOfBST(int value) {
		System.out.println("\n\nDeleting " + value + " from BST...");
		DeleteNode(root,value);
	}

	public BinaryNode DeleteNode(BinaryNode node, int nodeValue) {
		if(node == null) {
			System.out.println("Value not found in BST");
			return null;
		}

		if(nodeValue < node.getValue()) {
			node.setLeft(DeleteNode(node.getLeft(), nodeValue));
		}else if(nodeValue > node.getValue()) {
			node.setRight(DeleteNode(node.getRight(), nodeValue));
		}else {  //// If currentNode is the node to be deleted

			// if nodeToBeDeleted have both children
			if(node.getLeft() != null && node.getRight() != null) {
				BinaryNode temp = node;
				BinaryNode minNodeForRight = GetMinimumElement(temp.getRight()); // Finding minimum element from right subtree
				node.setValue(minNodeForRight.getValue());// Replacing current node with minimum node from right subtree
				node.setRight(DeleteNode(node.getRight(), minNodeForRight.getValue()));// Deleting minimum node from right now				
			}else if(node.getLeft() != null) {// if nodeToBeDeleted has only left child
				node = node.getLeft();
			}else if(node.getRight() != null) {// if nodeToBeDeleted has only right child
				node = node.getRight();
			}else {// if nodeToBeDeleted do not have child (Leaf node)
				node = null;
			}
		}
		return node;
	}

	// Get minimum element in binary search tree
	public BinaryNode GetMinimumElement(BinaryNode node) {
		if(node.getLeft() == null) {
			return node;
		}else {
			return GetMinimumElement(node.getLeft());
		}
	}

	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();

		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);

		System.out.println("\nPrinting Level order traversal of Tree...");
		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}

		while (!queue.isEmpty()) {
			if(CurrentLevel == level.peek()) { //if we are in the same level
				if(queue.peek()==null) {
					queue.add(null);level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
					queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;
				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}//end of loop
	}//end of method
}
