package com.program.BinaryHeap;

public class BinaryHeapMain {

	public static void main(String[] args) {
		BinaryHeapByArray heap = new BinaryHeapByArray(10);

		heap.insertHeap(100);
		heap.insertHeap(90);
		heap.insertHeap(80);
		heap.insertHeap(70);
		heap.insertHeap(60);
		heap.insertHeap(50);
		heap.insertHeap(40);
		heap.insertHeap(30);
		heap.insertHeap(20);

		heap.extractHeadofHeap();

		heap.insertHeap(110);
		heap.extractHeadofHeap();
	}
}
