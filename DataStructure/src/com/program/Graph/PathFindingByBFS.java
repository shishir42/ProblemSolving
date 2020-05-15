package com.program.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class PathFindingByBFS {
	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		
		//create 10 nodes: v1-v10
		for(int i=0;i<10; i++) {
			nodeList.add(new GraphNode(""+i));
		}
		
		//Constructor
		PathFindingByBFSSol graph = new PathFindingByBFSSol(nodeList);
		//add edges following graph in graph.docx
		graph.addUndirectedEdge(0,8);
		graph.addUndirectedEdge(8,2);
		graph.addUndirectedEdge(8,9);
		graph.addUndirectedEdge(2,1);
		graph.addUndirectedEdge(9,1);
		graph.addUndirectedEdge(2,4);
		graph.addUndirectedEdge(1,3);
		graph.addUndirectedEdge(1,7);
		graph.addUndirectedEdge(3,4);
		graph.addUndirectedEdge(3,5);
		graph.addUndirectedEdge(7,6);
		graph.addUndirectedEdge(5,6);
		
		System.out.println("Printing BFS from source: 2");
		graph.BFSForSSSP(nodeList.get(2));
	}
}

class PathFindingByBFSSol{
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public PathFindingByBFSSol(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	//Print path of each of the vertex from source
	public void pathPrint(GraphNode node) {
		if(node.getParent()!= null) {
			pathPrint(node.getParent());
			System.out.println(" " + node);
		}
	}

	//BFS Traversal by a source node
	public void BFSForSSSP(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node); //add source node to queue
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.remove(0);
			presentNode.setVisited(true);
			System.out.print("Printing path for node "+presentNode.getName()+": ");
			pathPrint(presentNode);
			System.out.println();
			for(GraphNode neighbor: presentNode.getNeighbours()) {  //for each neighbor of present node
				if(!neighbor.isVisited()) {
					queue.add(neighbor);
					neighbor.setVisited(true);
					neighbor.setParent(presentNode);
				}
			}
		}		
	}

	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
	}
}
