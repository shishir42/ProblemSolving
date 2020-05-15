package com.program.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class DFSIterative {
	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		
		//create 10 nodes: v1-v10
		for(int i=1;i<11; i++) {
			nodeList.add(new GraphNode("V"+i));
		}
		
		//Constructor
		DFSIterativeSol graph = new DFSIterativeSol(nodeList);
		
		//add edges following graph in graph.docx
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
		
		//dfs from v1
		System.out.println("Printing DFS from source: V1");
		graph.DFS();
	}
}

class DFSIterativeSol{
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	public DFSIterativeSol(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	public void DFS() {
		for(GraphNode node: nodeList) {
			if(!node.isVisited()) {
				dfsVisit(node);
			}
		}
	}

	public void dfsVisit(GraphNode node) {
		//make an empty stack
		Deque<GraphNode> stack = new ArrayDeque<GraphNode>();
		stack.push(node);
		while(!stack.isEmpty()) {
			GraphNode presentNode = stack.pop();
			presentNode.setVisited(true);
			System.out.println(" " + presentNode.getName());
			for(GraphNode neighbor:  presentNode.getNeighbours()) {
				if(!neighbor.isVisited()) {
					stack.add(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}

	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
	}
}