package com.question.LeetCode;
/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * (1,2,2) ->(1,2)
 */
//o(n)
public class DeleteDuplicateLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = new ListNode(2);
		ListNode next = new ListNode(3);
		ListNode prev = new ListNode(3);
		
		prev.setNext(null);
		next.setNext(prev);
		list.setNext(next);
		
		DeleteDuplicateLinkedList linkedlist = new DeleteDuplicateLinkedList();
		System.out.print(linkedlist.deleteDuplicates(list).toString());
		
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
		
		public void setNext(ListNode next) {
			this.next = next;
		}
		public String toString() {
		    String result = val + " ";
		    if (next != null) {
		        result += next.toString();
		    }
		    return result;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode cur = head;
		ListNode prev = head;

		while (cur != null) {
			if (prev.val == cur.val) {
				prev.next = cur.next;
				cur = prev;
			}
			prev = cur;
			cur = cur.next;
		}
		return head;
	}
}
