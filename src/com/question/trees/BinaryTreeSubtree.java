/* 
 * Cracking the coding interview (5th edition)
 * Chapter 4 - Trees and Graphs
 * 
 * Question 4.8
 * You have two very large binary trees: T1, with million of nodes, and T2, with
 * hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of
 * n is identical to T2. That is, if you cut off the tree at node n, the two trees would
 * be identical.
 * 
 * Solution - pg 235
 * 
 */
package com.question.trees;

import com.ds.tree.BinaryTreeNode;

public class BinaryTreeSubtree {

	private boolean isLeaf(BinaryTreeNode<Integer> t) {
		if (t == null)
			return false;
		return t.getLeft() == null && t.getRight() == null;
	}

	private boolean isIdentical(BinaryTreeNode<Integer> t1,
			BinaryTreeNode<Integer> t2) {
		if (t1 == null && t2 == null) {
			return true;
		} else if (t1 == null) {
			return false;
		} else if (t2 == null) {
			return false;
		}
		if (isLeaf(t1) && isLeaf(t2)) {
			if (t1.getValue() == t2.getValue()) {
				return true;
			}
			return false;
		} else if (isLeaf(t1)) {
			return false;
		} else if (isLeaf(t2)) {
			return false;
		}
		if (t1.getValue() == t2.getValue()) {
			return isIdentical(t1.getLeft(), t2.getLeft())
					&& isIdentical(t1.getRight(), t2.getRight());
		}
		return false;
	}

	public boolean isSubtree(BinaryTreeNode<Integer> t1,
			BinaryTreeNode<Integer> t2) {
		if (t2 == null)
			return true;
		if (t1 == null)
			return false;
		if (isIdentical(t1, t2)) {
			return true;
		}
		return isSubtree(t1.getLeft(), t2) || isSubtree(t1.getRight(), t2);
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
		BinaryTreeNode<Integer> node11 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> node31 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> node41 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> node51 = new BinaryTreeNode<Integer>(5);
		node11.setLeft(node31);
		node11.setRight(node41);
		node31.setLeft(node51);
		BinaryTreeSubtree sub = new BinaryTreeSubtree();
		System.out.print(sub.isSubtree(root, node11));

	}

}
