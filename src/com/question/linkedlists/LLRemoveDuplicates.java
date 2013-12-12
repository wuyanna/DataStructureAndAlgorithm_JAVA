/* 
 * Cracking the coding interview (5th edition)
 * Chapter 2 - Linked Lists
 * 
 * Question 2.1
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * Solution - pg 184
 * 
 */
package com.question.linkedlists;

import java.util.Hashtable;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyLinkedListNode;

public class LLRemoveDuplicates {

	// using buffer
	public void removeDup(SinglyLinkedListNode<Integer> node) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		SinglyLinkedListNode<Integer> prev = node;
		while (node != null) {
			if (table.containsKey(node.getData())) {
				prev.setNext(node.getNext());
			} else {
				table.put(node.getData(), true);
				prev = node;
			}

			node = node.getNext();
		}
	}

	// not using buffer
	public void removeDupNoBuf(SinglyLinkedListNode<Integer> node) {
		SinglyLinkedListNode<Integer> outp = node;
		SinglyLinkedListNode<Integer> inp = node;
		SinglyLinkedListNode<Integer> prev = node;
		while (outp != null) {
			inp = outp.getNext();
			prev = outp;
			while (inp != null) {
				if (outp.getData() == inp.getData()) {
					prev.setNext(inp.getNext());
				} else {
					prev = inp;
				}
				inp = inp.getNext();
			}
			outp = outp.getNext();
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		Integer[] datalist = { 2, 1, 2, 3, 3, 4, 3, 5 };
		SinglyLinkedListNode<Integer> root = ll.generateList(datalist);
		System.out.println(ll);
		LLRemoveDuplicates rv = new LLRemoveDuplicates();
		rv.removeDupNoBuf(root);
		System.out.println(root);
	}

}
