/*
 * 
 * Q5 : Sum all the elements at a given depth in a tree and return the sum.
 * 									   1
 * 									 2   2
 * test case: at depth 3, nodes are 4,5 6,7
 */
package com.interview.amazon;

import java.util.LinkedList;

import com.ds.tree.BinaryTreeNode;

public class TreeLevelSum {

	// Rescursive
	public static int sum(BinaryTreeNode<Integer> node, int depth) {
		if (node == null)
			return 0;
		if (depth == 0)
			return node.getValue();
		return sum(node.getLeft(), depth - 1) + sum(node.getRight(), depth - 1);
	}

	// BFS
	public static int sum2(BinaryTreeNode<Integer> node, int depth) {
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		int nodeCountLast = 0;
		int nodeCountCurr = 0;
		int curr_depth = 0;
		int sum = 0;
		queue.add(node);
		nodeCountLast++;
		while (!queue.isEmpty()) {

			BinaryTreeNode<Integer> n = queue.poll();
			nodeCountLast--;

			if (curr_depth == depth) {
				sum += n.getValue();
			}
			if (n.getLeft() != null) {
				queue.add(n.getLeft());
				nodeCountCurr++;
			}
			if (n.getRight() != null) {
				queue.add(n.getRight());
				nodeCountCurr++;
			}
			if (nodeCountLast == 0) {
				nodeCountLast = nodeCountCurr;
				nodeCountCurr = 0;
				curr_depth++;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(7);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		System.out.print(sum2(root, 2));

	}

}
