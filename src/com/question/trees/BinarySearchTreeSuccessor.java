/* 
 * Cracking the coding interview (5th edition)
 * Chapter 4 - Trees and Graphs
 * 
 * Question 4.6
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node
 * in a binary search tree. You may assume the each node has a link to its parent.
 * 
 * Solution - pg 229
 * 
 */
package com.question.trees;

import com.ds.tree.BinaryTreeNode;

public class BinarySearchTreeSuccessor {

	public Node<Integer> getSuccessor(Node<Integer> node) {
		if (node == null)
			return null;
		Node<Integer> next = node;
		if (next.getRight() != null) { // if node has right child
			next = (Node<Integer>) node.getRight();
			while (next.getLeft() != null) {
				next = (Node<Integer>) next.getLeft();
			}
			return next;
		}
		next = node.getParent();
		while (next != null && next.getLeft() != node) {
			next = next.getParent();
			node = next;
		}
		return next;
	}

	private static class Node<T> extends BinaryTreeNode<T> {
		private Node<T> parent;

		public Node(T value) {
			super(value);
		}

		public Node<T> getParent() {
			return parent;
		}

		public void setParent(Node<T> parent) {
			this.parent = parent;
		}

		public void setLeft(Node<T> left) {
			super.setLeft(left);
			left.setParent(this);
		}

		public void setRight(Node<T> right) {
			super.setRight(right);
			right.setParent(this);
		}
	}

	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(3);
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(5);
		Node<Integer> node3 = new Node<Integer>(0);
		Node<Integer> node4 = new Node<Integer>(2);
		Node<Integer> node5 = new Node<Integer>(-1);
		Node<Integer> node6 = new Node<Integer>(4);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node3.setLeft(node5);
		node2.setLeft(node6);
		BinarySearchTreeSuccessor succ = new BinarySearchTreeSuccessor();
		System.out.print(node1.getValue() + "->" + succ.getSuccessor(node1).getValue());
	}

}
