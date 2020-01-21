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
			System.out.println("Successfully inserted new node at Root!!!!");
			return;
		}
		
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if(presentNode.getLeft() == null)
			{
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node at left!");
				break;
			}else if(presentNode.getRight() == null)
			{
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node at right!");
				break;
			}else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
		}
	}
}
