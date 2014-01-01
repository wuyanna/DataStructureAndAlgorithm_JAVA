/*
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
//time complexity O(N)
package com.question.LeetCode;

public class CompareTwoTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(4);
		root.setLeft(left);
		root.setRight(right);

		TreeNode p = new TreeNode(2);
		TreeNode pLeft = new TreeNode(3);
		TreeNode pRight = new TreeNode(4);
		p.setLeft(pLeft);
		p.setRight(pRight);

		CompareTwoTree tree = new CompareTwoTree();
		System.out.print(tree.isSameTree(root, p));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
