package com.program.HashMap;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

public class C1_VerticalOrderTree {
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        VerticalOrderTree v = new VerticalOrderTree();
        v.printVerticalOrder(root);
	}
}

class Node{
	Node left;
	Node right;
	int key;
	
	public Node(int data) {
		this.key = data;
	}
}

class VerticalOrderTree{
	public void printVerticalOrder(Node root) {
		TreeMap<Integer, Vector<Integer>> m = new TreeMap<Integer, Vector<Integer>>();
		int hd = 0;
		this.getVerticalOrder(root, hd, m);
		
		for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	
	// hd - horizontal distance
	public void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m) {
		
		//Base case 
		if(root == null) {
			return;
		}
		
		//get the vector list at hd
		Vector<Integer> get = m.get(hd);
		
		if(get == null)
		{
			get = new Vector<Integer>();
			get.add(root.key);
		}
		else
		{
			get.add(root.key);
		}
		
		m.put(hd, get);
		
		// Store nodes in left subtree
        getVerticalOrder(root.left, hd-1, m);
         
        // Store nodes in right subtree
        getVerticalOrder(root.right, hd+1, m);
	}
}



















