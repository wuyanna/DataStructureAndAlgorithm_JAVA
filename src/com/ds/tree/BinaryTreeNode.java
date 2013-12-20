package com.ds.tree;

public class BinaryTreeNode<T> {
	private BinaryTreeNode<T> left, right;
	private T value;
	
	public BinaryTreeNode(T value) {
		this.value = value;
	}
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
}
