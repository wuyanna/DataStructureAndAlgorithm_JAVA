/*
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
//time complexity O(N)

package com.question.LeetCode;

public class TreeNodeMax {
	TreeNode left;
	TreeNode right;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode tree = new TreeNode(3);
		TreeNode node = new TreeNode(4);
		TreeNode treeNode = new TreeNode(5);
		root.setLeft(tree);
		root.setRight(node);
		root.setRight(treeNode);

		TreeNodeMax max = new TreeNodeMax();
		System.out.print(max.maxDepth(root));
	}

	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

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

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

}
