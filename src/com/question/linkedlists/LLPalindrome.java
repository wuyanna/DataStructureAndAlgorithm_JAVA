/* 
 * Cracking the coding interview (5th edition)
 * Chapter 2 - Linked Lists
 * 
 * Question 2.7
 * Implement a function to check if a linked list is a palindrome.
 * 
 * Solution - pg 196
 * 
 */
package com.question.linkedlists;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyLinkedListNode;

public class LLPalindrome {
	
	public boolean isPalindrome(SinglyLinkedListNode<Integer> root) {
		Integer length = 0;
		SinglyLinkedListNode<Integer> node = root;
		while (node != null) {
			length++;
			node = node.getNext();
		}
		Integer palinLen = length / 2;
		Integer[] stack = new Integer[palinLen];
		node = root;
		for (int i = 0; i < palinLen; i++) {
			stack[i] = node.getData();
			node = node.getNext();
		}
		if (length % 2 == 1) {
			node = node.getNext();
		}
		for (int i = 0; i < palinLen; i++) {
			if (stack[palinLen-1-i] != node.getData()) {
				return false;
			}
			node = node.getNext();
		}
		return true;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		Integer[] datalist = { 2, 1, 4, 3, 1, 4, 1, 2 };
		SinglyLinkedListNode<Integer> root = ll.generateList(datalist);
		LLPalindrome pal = new LLPalindrome();
		System.out.println(pal.isPalindrome(root));
	}

}
