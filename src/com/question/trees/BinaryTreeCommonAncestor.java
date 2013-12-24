/* 
 * Cracking the coding interview (5th edition)
 * Chapter 4 - Trees and Graphs
 * 
 * Question 4.7
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 * 
 * Solution - pg 230
 * 
 */
package com.question.trees;

import com.ds.tree.BinaryTreeNode;

public class BinaryTreeCommonAncestor {

	private BinaryTreeNode<Integer> ancestor;

	public boolean findCommonAncestor(BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
		// post-order traversal
		if (root == null)
			return false;
		boolean anc1 = findCommonAncestor(root.getLeft(), node1, node2);
		boolean anc2 = findCommonAncestor(root.getRight(), node1, node2);

		if (root == node1 || root == node2) {
			if (anc1 == true) {
				anc2 = true;
			} else if (anc2 == true) {
				anc1 = true;
			} else {
				return true;
			}
		}
		if (anc1 && anc2) {
			this.ancestor = root;
		}
		
		return anc1 || anc2;
	}

	public BinaryTreeNode<Integer> getAncestor() {
		return ancestor;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(0);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(6);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node3.setLeft(node5);
		node2.setLeft(node6);
		BinaryTreeCommonAncestor anc = new BinaryTreeCommonAncestor();
		anc.findCommonAncestor(root, node1, node5);
		System.out.print(anc.getAncestor().getValue());
	}

}
