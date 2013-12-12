/* 
 * Cracking the coding interview (5th edition)
 * Chapter 2 - Linked Lists
 * 
 * Question 2.2
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * 
 * Solution - pg 185
 * 
 */
package com.question.linkedlists;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyLinkedListNode;

public class LLFindLastKth {

	public Integer kthToLast(SinglyLinkedListNode<Integer> root, int k) {
		int length = 0;
		SinglyLinkedListNode<Integer> temp = root;
		while (temp != null) {
			temp = temp.getNext();
			length++;
		}

		int index = length - k;
		temp = root;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.getData();
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		Integer[] datalist = { 2, 1, 2, 3, 3, 4, 3, 5 };
		SinglyLinkedListNode<Integer> root = ll.generateList(datalist);
		LLFindLastKth last = new LLFindLastKth();

		System.out.println(last.kthToLast(root, 3));

	}

}
