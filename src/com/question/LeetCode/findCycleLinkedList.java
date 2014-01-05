package com.question.LeetCode;

/*
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */

public class findCycleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = new ListNode(2);
		ListNode next = new ListNode(3);
		ListNode prev = new ListNode(3);

		prev.setNext(next);
		next.setNext(prev);
		list.setNext(next);

		findCycleLinkedList linkedList = new findCycleLinkedList();

		System.out.print(linkedList.hasCycle(list));
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

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode runner = head;

		if (head == null) {
			return false;
		}

		while (true) {
			slow = slow.next;

			if (runner.next != null) {
				runner = runner.next.next;
			} else {
				return false;
			}

			if (slow == null || runner == null) {
				return false;
			}
			
			if (slow == runner) {
				return true;
			}
		}
	}
}
