/* 
 * Cracking the coding interview (5th edition)
 * Chapter 4 - Trees and Graphs
 * 
 * Question 4.9
 * You are given a binary tree in which each node contains a value. Design an
 * algorithm to print all paths which sum to a given value. The path does not
 * need to start or end at the root or a leaf.
 * 
 * Solution - pg 237
 * 
 */
package com.question.trees;

import java.util.ArrayList;

import com.ds.tree.BinaryTreeNode;

public class BinaryTreeSumPath {

	public void findSum(BinaryTreeNode<Integer> node, int sum,
			ArrayList<Integer> path, int level) {
		if (node == null)
			return;
		path.add(level, node.getValue());
		int s = 0;
		for (int i = level; i >= 0; i--) {
			s += path.get(i);
			if (s == sum) {
				System.out.println(path.subList(i, level+1));
			}
		}

		findSum(node.getLeft(), sum, path, level + 1);
		findSum(node.getRight(), sum, path, level + 1);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(0);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(-1);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> node7 = new BinaryTreeNode<Integer>(0);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node3.setLeft(node5);
		node2.setLeft(node6);
		node4.setRight(node7);
		BinaryTreeSumPath sump = new BinaryTreeSumPath();
		sump.findSum(root, 6, new ArrayList<Integer>(), 0);
	}

}
