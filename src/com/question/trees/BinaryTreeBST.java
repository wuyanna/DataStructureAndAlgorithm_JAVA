package com.question.trees;

import com.ds.tree.BinaryTreeNode;

public class BinaryTreeBST {

	public boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null) return true;
		boolean leftValid = 
				root.getLeft() == null ? true : root.getLeft().getValue() <= root.getValue();
		boolean rightValid = 
				root.getRight() == null ? true : root.getRight().getValue() > root.getValue();
		if (leftValid && rightValid) {
			return isBST(root.getLeft()) && isBST(root.getRight());
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
