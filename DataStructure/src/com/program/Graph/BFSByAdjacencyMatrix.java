package com.program.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSByAdjacencyMatrix {
	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

		//Create 10 nodes: V1-V10
		for (int i = 1; i < 11; i++) {
			nodeList.add(new GraphNode("V"+i, i-1));
		}

		//Pass Graph arraylist for further processing
		BFSByAdjacencyMatrixSol graph = new BFSByAdjacencyMatrixSol(nodeList);

		graph.addUndirectedEdge(1,2);
		graph.addUndirectedEdge(1,4);
		graph.addUndirectedEdge(2,3);
		graph.addUndirectedEdge(2,5);
		graph.addUndirectedEdge(3,6);
		graph.addUndirectedEdge(3,10);
		graph.addUndirectedEdge(4,7);
		graph.addUndirectedEdge(5,8);
		graph.addUndirectedEdge(6,9);
		graph.addUndirectedEdge(7,8);
		graph.addUndirectedEdge(8,9);
		graph.addUndirectedEdge(9,10);

		//bfs from v1
		System.out.println("Printing BFS from source: V1");
		graph.bfs();
	}
}

class BFSByAdjacencyMatrixSol{
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int [][] adjacencyMatrix;

	public BFSByAdjacencyMatrixSol(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		int size = this.nodeList.size();
		adjacencyMatrix = new int[size][size];
	}

	//BFS Algorithm
	public void bfs() {
		for(GraphNode node: nodeList) {
			if(!node.isVisited()) {
				bfsVisit(node);
			}
		}
	}

	public void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.remove(0);
			presentNode.setVisited(true);
			System.out.println(" " + presentNode.getName());

			ArrayList<GraphNode> neighbors = getNeighbors(presentNode);
			for(GraphNode neighbor: neighbors) {
				if(!neighbor.isVisited()) {
					queue.add(neighbor);
					neighbor.setVisited(true);
				}
			}			
		}		
	}

	public ArrayList<GraphNode> getNeighbors(GraphNode node){
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

		//gets row# to search in node index
		int nodeIndex = node.getIndex();

		for (int i = 0; i < adjacencyMatrix.length; i++) {
			//if a column has 1 in that row then there is a neighbor and add it to list
			if(adjacencyMatrix[nodeIndex][i] == 1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;
	}

	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		//decrement i, j for array indexes
		i--;
		j--;
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;

	}
}












