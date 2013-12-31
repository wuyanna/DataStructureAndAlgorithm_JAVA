/* 
 * Cracking the coding interview (5th edition)
 * Chapter 4 - Trees and Graphs
 * 
 * Question 4.2
 * Given a directed graph, design an algorithm to find out whether there is a route
 * between two nodes.
 * 
 * Solution - pg 221
 * 
 */
package com.question.graphs;

import com.ds.graph.GraphNode;

public class GraphFindRoute {
	
	public boolean findRouteDFS(GraphNode<Integer> n1, GraphNode<Integer> n2) {
		n1.setVisited(true);
		for (GraphNode<Integer> node : n1.getSucc()) {
			if (node == n2) {
				return true;
			}
			if (node.isVisited() == false) {
				return findRouteDFS(node,n2);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		GraphNode<Integer> node01 = new GraphNode<Integer>(1);
		GraphNode<Integer> node02 = new GraphNode<Integer>(2);
		GraphNode<Integer> node03 = new GraphNode<Integer>(3);
		GraphNode<Integer> node11 = new GraphNode<Integer>(4);
		node01.mkEdge(node11);
		node01.mkEdge(node02);
		node02.mkEdge(node11);
		node03.toEdge(node02);
		GraphFindRoute rout = new GraphFindRoute();
		System.out.print(rout.findRouteDFS(node01,node03));

	}

}
