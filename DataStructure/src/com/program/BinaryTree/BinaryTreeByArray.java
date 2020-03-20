package com.program.BinaryTree;

public class BinaryTreeByArray {
	int []arr;
	int lastUsedIndex;

	public BinaryTreeByArray(int size) {
		this.arr = new int[size + 1];
		this.lastUsedIndex = 0;
		System.out.println("Blank Tree of size " +size+ " has been created !\n");
	}

	//Check if array is full
	public boolean isTreeFull() {
		if(this.arr.length - 1 == this.lastUsedIndex) {
			return true;
		}

		return false;
	}

	// New node should be inserted at the first empty place in the array
	public void insert(int value) {
		if(this.isTreeFull()) {
			System.out.println("Could not insert value in the Tree as it is full !");
		}else {
			this.arr[this.lastUsedIndex+1] = value;
			this.lastUsedIndex++;
		}
	}

	//level-Order traversal of binary tree
	public void levelOrder() {
		for(int i=1;i<=lastUsedIndex;i++ ) {
			System.out.print(arr[i]+" ");
		}
	}

	// Pre-Order traversal of binary tree
	public void preOrder(int index) {
		if(index > this.lastUsedIndex) {
			return;
		}

		System.out.print(arr[index] + " ");
		preOrder(index * 2);
		preOrder(index * 2 + 1);
	}

	// Post-Order Traversal of binary tree
	public void postOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		postOrder(index * 2);
		postOrder(index * 2 + 1);
		System.out.print(arr[index] + " ");
	}//end of method


	// In-Order Traversal of binary tree
	public void inOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		inOrder(index * 2);
		System.out.print(arr[index] + " ");
		inOrder(index * 2 + 1);
	}//end of method

	public int search(int value) {
		for (int i = 0; i <= this.lastUsedIndex; i++) {
			if(arr[i] == value) {
				System.out.print(value +" exists in the Tree! ");
				System.out.println("It is at the location: " + i);
				return i;
			}
		}
		System.out.println(value + " does not exists in Tree !");
		System.out.println();
		return -1;
	}

	// delete operation of binary tree
	public void delete(int value) {
		int location = search(value);
		//If Value does not exists in Array
		if (location == -1) {
			return;
		}else {
			//insert last element of the Tree into current location
			arr[location] = arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("Successfully deleted " + value + " from the Tree !");
		}	
	}//end of method


	public void deleteTree(){
		try {
			arr = null;
			System.out.println("Tree has been deleted successfully !");
		}catch(Exception e){
			System.out.println("There was an error deleting the tree.");
		}
	}//end of method
}













