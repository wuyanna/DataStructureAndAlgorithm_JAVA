package com.ds.graph;

import java.util.ArrayList;

public class GraphNode<T> {
	private T data;
	private ArrayList<GraphNode<T>> adjacent;
	private boolean visited;

	public GraphNode(T data) {
		this.setData(data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public void mkEdge(GraphNode<T> node) {
		adjacent.add(node);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
