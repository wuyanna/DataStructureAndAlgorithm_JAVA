/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.13
 * Consider a simple node-like data-structure called BiNode, which has pointers to
 * two other nodes.
 * public class BiNode {
 * 		public BiNode node1, node2;
 * 		public int data;
 * }
 * The data structure BiNode could be used to represent both a binary tree (where
 * node1 is the left node and node2 is the right node) or a doubly linked list (where
 * node1 is the previous node and node2 is the next node). Implement a method
 * to convert a binary search tree (implemented with BiNode) into a doubly linked
 * list. The values should be kept in order and the operation should be performed
 * in place (that is, on the original data structure).
 * 
 * Solution - pg 451
 * 
 */
package com.question.moderate;

public class BST2LinkedList {

	private static class BiNode {
		public BiNode node1, node2;
		private Integer data;

		public BiNode(int value) {
			this.data = value;
		}

		@Override
		public String toString() {
			if (node2 == null)
				return "end";
			return data.toString() + " -> " + node2.toString();
		}
	}

	public static BiNode[] convert(BiNode root) {
		if (root == null) {
			BiNode[] res = { null, null };
			return res;
		}
		BiNode[] prev = convert(root.node1);
		BiNode[] next = convert(root.node2);
		BiNode prev_head = prev[0];
		BiNode prev_tail = prev[1];
		BiNode next_head = next[0];
		BiNode next_tail = next[1];

		if (prev_tail != null) {
			prev_tail.node2 = root;
		}
		if (next_head != null) {
			next_head.node1 = root;
		}

		root.node1 = prev_tail;
		root.node2 = next_head;
		if (prev_head == null)
			prev_head = root;
		if (next_tail == null)
			next_tail = root;

		BiNode[] res = { prev_head, next_tail };
		return res;
	}

	public static void main(String[] args) {
		BiNode root = new BiNode(5);
		BiNode node1 = new BiNode(3);
		BiNode node2 = new BiNode(7);
		BiNode node3 = new BiNode(2);
		BiNode node4 = new BiNode(4);
		BiNode node5 = new BiNode(6);
		BiNode node6 = new BiNode(9);
		BiNode node7 = new BiNode(1);
		BiNode node8 = new BiNode(8);
		root.node1 = node1;
		root.node2 = node2;
		node1.node1 = node3;
		node1.node2 = node4;
		node2.node1 = node5;
		node2.node2 = node6;
		node3.node1 = node7;
		node6.node1 = node8;

		BiNode[] res = convert(root);
		System.out.print(res[0]);
	}

}
