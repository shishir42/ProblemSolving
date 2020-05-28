package com.program.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	public static void main(String[] args) {
		//Initialize a Arraylist for storing all the graph nodes
		ArrayList<GraphNode> nodeList = new ArrayList<>();

		//create 10 nodes: v1-v10
		for(int i=1;i<11; i++) {
			nodeList.add(new GraphNode("V"+i));
		}

		//Constructor
		TopologicalSortMain graph = new TopologicalSortMain(nodeList);
		//add edges 
		
		
		graph.addDirectedEdge(1,2);
		graph.addDirectedEdge(1,4);
		graph.addDirectedEdge(2,3);
		graph.addDirectedEdge(2,5);
		graph.addDirectedEdge(3,6);
		graph.addDirectedEdge(3,10);
		graph.addDirectedEdge(4,7);
		graph.addDirectedEdge(5,8);
		graph.addDirectedEdge(6,9);
		graph.addDirectedEdge(7,8);
		graph.addDirectedEdge(8,9);
		graph.addDirectedEdge(9,10);

		//bfs from v1
		System.out.println("Printing BFS from source: V1");
		graph.topologicalSort();
	}
}

class TopologicalSortMain {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public TopologicalSortMain(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	public void topologicalSort() {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		for(GraphNode node : nodeList) {// if a node is unvisited then run topologicalSort on it
			if(!node.isVisited()) {
				topologicalVisit(node,stack);
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getName()+" ");
		}
	}

	private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for(GraphNode neighbor : node.getNeighbours()) { //if neighbor is not visited then recursive call to it
			if(!neighbor.isVisited()) {
				topologicalVisit(neighbor, stack);
			}
		}

		node.setVisited(true);
		stack.push(node);
	}

	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbours().add(second);
	}
}
