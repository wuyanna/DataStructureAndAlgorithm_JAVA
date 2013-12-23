package com.ds.graph;

import java.util.ArrayList;

public class GraphNode<T> {
	private T data;
	private ArrayList<GraphNode<T>> pred;
	private ArrayList<GraphNode<T>> succ;

	private boolean visited;

	public GraphNode(T data) {
		pred = new ArrayList<GraphNode<T>>();
		succ = new ArrayList<GraphNode<T>>();
		this.setData(data);
		this.visited = false;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void mkEdge(GraphNode<T> node) {
		fromEdge(node);
		toEdge(node);
	}

	public void fromEdge(GraphNode<T> node) {
		pred.add(node);
		node.succ.add(this);
	}

	public void toEdge(GraphNode<T> node) {
		succ.add(node);
		node.pred.add(this);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public GraphNode<T>[] getAdjacent() {
		GraphNode<T>[] preds = pred.toArray(new GraphNode[pred.size()]);
		GraphNode<T>[] succs = succ.toArray(new GraphNode[succ.size()]);
		GraphNode<T>[] adj = new GraphNode[preds.length + succs.length];
		System.arraycopy(pred.toArray(), 0, adj, 0, preds.length);
		System.arraycopy(succs, 0, adj, preds.length, succs.length);
		return adj;
	}

	public ArrayList<GraphNode<T>> getPred() {
		return pred;
	}

	public ArrayList<GraphNode<T>> getSucc() {
		return succ;
	}

}
