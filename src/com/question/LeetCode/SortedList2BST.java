package com.question.LeetCode;

public class SortedList2BST {

	/**
	 * Definition for singly-linked list.
	 */
	 private static class ListNode {
	 	int val;
	 	ListNode next;
	 	ListNode(int x) { val = x; next = null; }
	 }

	/**
	 * Definition for binary tree
	 */
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode midNode = partitionList(head);
        TreeNode treeNode = new TreeNode(midNode.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(midNode.next);
        return treeNode;
    }
    
    // return middle node
    public ListNode partitionList(ListNode head) {
        if (head == null) return null;
        ListNode runner = head;
        ListNode last = null;
        while (runner != null && runner.next != null) {
        	last = head;
            head = head.next;
            runner = runner.next.next;
            
        }
        if (last != null) {
            last.next = null;
        }
        return head;
    }
    
	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		
		ListNode node1 = new ListNode(3);
		node.next = node1;
		SortedList2BST sol = new SortedList2BST();
		sol.sortedListToBST(node);
		
	}

}
