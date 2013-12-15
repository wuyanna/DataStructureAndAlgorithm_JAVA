/* 
 * Cracking the coding interview (5th edition)
 * Chapter 2 - Linked Lists
 * 
 * Question 2.5
 * You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order,
 * such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers 
 * and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order.
 * Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 * 
 * Solution - pg 190
 * 
 */
package com.question.linkedlists;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyLinkedListNode;

public class LLDigitSum {
	
	public SinglyLinkedListNode<Integer> digitSum(
			SinglyLinkedListNode<Integer> l1, 
			SinglyLinkedListNode<Integer> l2) {
		SinglyLinkedListNode<Integer> result = new SinglyLinkedListNode<Integer>(null,0);
		SinglyLinkedListNode<Integer> resultp = result;
		while (l1 != null || l2 != null) {
			Integer d1 = l1 == null ? 0 : l1.getData();
			Integer d2 = l2 == null ? 0 : l2.getData();
			resultp.setNext(new SinglyLinkedListNode<Integer>(null,d1+d2));
			l1 = l1 == null ? l1 : l1.getNext();
			l2 = l2 == null ? l2 : l2.getNext();
			resultp = resultp.getNext();
		}
		return result.getNext();
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll1 = new SinglyLinkedList<Integer>();
		Integer[] datalist = { 2, 1, 2, 2};
		SinglyLinkedListNode<Integer> root = ll1.generateList(datalist);
		Integer[] datalist2 = { 2, 1, 2};
		SinglyLinkedListNode<Integer> root2 = ll1.generateList(datalist2);
		
		LLDigitSum dig = new LLDigitSum();
		System.out.println(root);
		System.out.println(root2);
		System.out.println(dig.digitSum(root, root2));

	}

}
