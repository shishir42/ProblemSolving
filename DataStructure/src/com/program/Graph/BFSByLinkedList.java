package com.program.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSByLinkedList {
	public static void main(String[] args) {
		//Initialize a Arraylist for storing all the graph nodes
		ArrayList<GraphNode> nodeList = new ArrayList<>();

		//create 10 nodes: v1-v10
		for(int i=1;i<11; i++) {
			nodeList.add(new GraphNode("V"+i));
		}

		//Constructor
		BFSByLinkedListSol graph = new BFSByLinkedListSol(nodeList);
		//add edges 
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

class BFSByLinkedListSol{
	
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	
	public BFSByLinkedListSol(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

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
			System.out.println(" "+ presentNode.getName());
			for(GraphNode neighbor: presentNode.getNeighbours()) { //for each neighbor of present node
				if(!neighbor.isVisited()) {
					queue.add(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}

	// Add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbours().add(second);//Neighbour of first is second. Store it.
		second.getNeighbours().add(first);//Neighbour of second is first. Store it.
	}
}
