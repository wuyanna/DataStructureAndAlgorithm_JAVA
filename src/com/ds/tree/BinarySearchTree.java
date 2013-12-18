package com.ds.tree;

public class BinarySearchTree implements IBinarySearchTree {

	private Node root;

	@Override
	public boolean find(int key) {
		if (root == null) {
			return false;
		}
		Node current = root;

		while (current.key != key) {
			if (current.key < key) {
				current = current.right;
			} else {
				current = current.left;
			}
			if (current == null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void insert(int key, double value) {
		Node newNode = new Node(key, value);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (current.key < key) {
					current = current.right;
					if (current == null) {
						parent.right = current;
						return;
					}
				} else {
					current = current.left;
					if (current == null) {
						parent.left = current;
						return;
					}
				}
			}
		}
	}

	@Override
	public void delete(int key) {
		if (root == null)
			return;
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		// case 1 - not found
		while (current.key != key) {
			parent = current;
			if (current.key < key) {
				isLeftChild = false;
				current = current.right;
			} else {
				isLeftChild = true;
				current = current.left;
			}
			if (current == null)
				return;
		}

		// case 2 - leaf
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// case 3 - has one child
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		}
		// case 4 - two children
		else {
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
	}

	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.right;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if (successor != delNode.right) {
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}

	@Override
	public void traverse() {
		inOrderHelper(root);

	}

	private void inOrderHelper(Node nodeToVisit) {
		if (nodeToVisit != null) {
			inOrderHelper(nodeToVisit.left);
			System.out.println("[" + nodeToVisit.key + ", " + nodeToVisit.value
					+ "]");
			inOrderHelper(nodeToVisit.right);
		}
	}

	private static class Node {
		private int key;
		private double value;
		private Node left, right;

		public Node(int key, double value) {
			this.key = key;
			this.value = value;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
