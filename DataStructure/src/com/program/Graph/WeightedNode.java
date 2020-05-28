package com.program.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode>{

	public String name;
	private ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
	private HashMap<WeightedNode, Integer> weightMap = new HashMap<WeightedNode, Integer>();
	private boolean isVisited = false;
	private WeightedNode parent = null;
	private int distance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WeightedNode(String name) {
		this.name = name;
		this.distance = Integer.MAX_VALUE;
	}
		
	public ArrayList<WeightedNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<WeightedNode> neighbors) {
		this.neighbors = neighbors;
	}

	public HashMap<WeightedNode, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<WeightedNode, Integer> weightMap) {
		this.weightMap = weightMap;
	}
	
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public WeightedNode getParent() {
		return parent;
	}

	public void setParent(WeightedNode parent) {
		this.parent = parent;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return this.name;
	}
	@Override
	public int compareTo(WeightedNode o) {
		return this.distance - o.distance;
	}
}
