/* 
 * Cracking the coding interview (5th edition)
 * Chapter 4 - Trees and Graphs
 * 
 * Question 4.1
 * Implement a function to check if a binary tree is balanced. For the purpose of
 * this question, a balanced tree is defined to be a tree such that the heights of the
 * two subtrees of any node never differ by more than one.
 * 
 * Solution - pg 220
 * 
 */
package com.question.trees;

import com.ds.tree.BinaryTreeNode;

public class BalancedBinaryTree {
	
	private int getHeight(BinaryTreeNode<Integer> node) {
		if (node == null) return 0;
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}
	
	public boolean isBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) return true;
		int diff = Math.abs(getHeight(root.getLeft()) - getHeight(root.getRight()));
		if (diff > 1) return false;
		return isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(2);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node3.setLeft(node5);
		node2.setLeft(node6);
		BalancedBinaryTree bal = new BalancedBinaryTree();
		System.out.print(bal.isBalanced(root));
	}

}
