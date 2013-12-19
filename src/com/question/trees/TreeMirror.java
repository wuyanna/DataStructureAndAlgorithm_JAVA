package com.question.trees;

import com.ds.tree.BinaryTreeNode;

public class TreeMirror {
	
	public void mirror(BinaryTreeNode<Integer> root) {
		if (root == null) return;
		mirror(root.getLeft());
		mirror(root.getRight());
		BinaryTreeNode<Integer> temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
