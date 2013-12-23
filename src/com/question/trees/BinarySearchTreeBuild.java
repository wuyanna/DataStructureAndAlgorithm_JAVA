/* 
 * Cracking the coding interview (5th edition)
 * Chapter 4 - Trees and Graphs
 * 
 * Question 4.3
 * Given a sorted (increasing order) array with unique integer elements, write an
 * algorithm to create a binary search tree with minimal height.
 * 
 * Solution - pg 222
 * 
 */
package com.question.trees;

import com.ds.tree.BinarySearchTree;
import com.ds.tree.IBinarySearchTree;

public class BinarySearchTreeBuild {
	
	private IBinarySearchTree tree;
	
	public void createMinBST(int[] array) {
		tree = new BinarySearchTree();
		createBST(array,0,array.length-1);
	}
	
	public void createBST(int[] arr, int start, int end) {
		if (start > end) return;
		int mid = start+(end-start)/2;
		int elem = arr[mid];
		tree.insert(elem, 0);
		createBST(arr,start,mid-1);
		createBST(arr,mid+1,end);
	}
	
	@Override
	public String toString() {
		return tree.toString();
	}

	public static void main(String[] args) {
		int[] array = {23,4,15,64,2,55,7,13,5,11,53,90};
		BinarySearchTreeBuild build = new BinarySearchTreeBuild();
		build.createMinBST(array);
		System.out.println(build);
	}

}
