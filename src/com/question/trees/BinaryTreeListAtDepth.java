/* 
 * Cracking the coding interview (5th edition)
 * Chapter 4 - Trees and Graphs
 * 
 * Question 4.4
 * Given a binary tree, design an algorithm which creates a linked list of all the
 * nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked
 * lists).
 * 
 * Solution - pg 222
 * 
 */
package com.question.trees;

import java.util.ArrayList;
import java.util.LinkedList;

import com.ds.tree.BinaryTreeNode;

public class BinaryTreeListAtDepth {
	
	public ArrayList<LinkedList<BinaryTreeNode<Integer>>> getLists(BinaryTreeNode<Integer> root) {
		ArrayList<LinkedList<BinaryTreeNode<Integer>>> result = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();
		LinkedList<BinaryTreeNode<Integer>> current = new LinkedList<BinaryTreeNode<Integer>>();
		if (root != null) {
			current.add(root);
		}
		
		while(current.size()>0) {
			result.add(current);
			LinkedList<BinaryTreeNode<Integer>> parent = current;
			current = new LinkedList<BinaryTreeNode<Integer>>();
			for (BinaryTreeNode<Integer> node : parent) {
				if (node.getLeft() != null) {
					current.add(node.getLeft());
				}
				if (node.getRight() != null) {
					current.add(node.getRight());
				}
			}
		}
		return result;
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
		BinaryTreeListAtDepth listd = new BinaryTreeListAtDepth();
		System.out.println(listd.getLists(root));
	}

}
