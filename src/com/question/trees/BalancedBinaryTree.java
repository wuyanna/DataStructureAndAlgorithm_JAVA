package com.question.trees;

import com.ds.tree.BinaryTreeNode;

public class BalancedBinaryTree {
	
	public boolean isBalanced(BinaryTreeNode root) {
		return isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
