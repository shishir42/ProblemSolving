package com.program.Graph;

import java.util.ArrayList;

public class FloydWarshall {
	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		//Create 4 Vertices: A,B,C,D
		for (int i = 0; i < 4; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		FloydWarshallMain graph = new FloydWarshallMain(nodeList);
		graph.addWeightedEdge(1, 4, 1);// Add A-> D , weight 1
		graph.addWeightedEdge(1, 2, 8);// Add A-> B , weight 8
		graph.addWeightedEdge(2, 3, 1);// Add B-> C , weight 1
		graph.addWeightedEdge(3, 1, 4);// Add C-> A , weight 4
		graph.addWeightedEdge(4, 2, 2);// Add D-> B , weight 2
		graph.addWeightedEdge(4, 3, 9);// Add D-> C , weight 9

		System.out.println("Printing Floyd-Warshall from each source:");
		graph.floydWarshall();
	}
}

class FloydWarshallMain{
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	public FloydWarshallMain(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	public void floydWarshall() {
		int size = nodeList.size();
		int [][]v = new int[size][size];

		// Initializing Distance table from adjacency list
		for (int i = 0; i < size; i++) {
			WeightedNode first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				WeightedNode second = nodeList.get(j);
				if(i == j) {
					v[i][j] = 0;
				}
				else if(first.getWeightMap().containsKey(second)) {  ////we have direct edge between i & j
					v[i][j] = first.getWeightMap().get(second);
				}else { //no direct edge between i & j, so mark it as infinity [divided by 10 to avoid arithmetic overflow]
					v[i][j] = Integer.MAX_VALUE/10;
				}
			}
		}

		// Floyd Warshall's Algorithm
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(v[i][j] > v[i][k] + v[k][j]) {// if update possible, then update path
						v[i][j] = v[i][k] + v[k][j];// this will keep a track on path
					}
				}
			}
		}

		// Print table of node with minimum distance and shortest path from each source
		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node "+nodeList.get(i)+": ");
			for (int j = 0; j < size; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
	}

	// add a weighted edge between two nodes
	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i - 1);
		WeightedNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second, d);
	}
}
