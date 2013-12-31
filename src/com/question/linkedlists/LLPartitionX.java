/* 
 * Cracking the coding interview (5th edition)
 * Chapter 2 - Linked Lists
 * 
 * Question 2.4
 * Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * 
 * Solution - pg 188
 * 
 */
package com.question.linkedlists;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyLinkedListNode;

public class LLPartitionX {

	public void partition(Integer x, SinglyLinkedListNode<Integer> root) {
		if (root == null)
			return;
		SinglyLinkedListNode<Integer> last = root;
		while (last.getNext() != null)
			last = last.getNext();
		SinglyLinkedListNode<Integer> temp = root;
		SinglyLinkedListNode<Integer> prev = root;
		SinglyLinkedListNode<Integer> originLast = last;
		while (temp != originLast) {
			if (temp.getData() > x) { // add to tail
				SinglyLinkedListNode<Integer> node = temp;
				prev.setNext(node.getNext());
				temp = temp.getNext();
				node.setNext(null);
				last.setNext(node);
				last = node;
			} else {
				prev = temp;
				temp = temp.getNext();
			}
		}
		if (temp.getData() > x) { // add to tail
			prev.setNext(temp.getNext());
			temp.setNext(null);
			last.setNext(temp);
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		Integer[] datalist = { 2, 1, 2, 3, 4, 3, 5 };
		SinglyLinkedListNode<Integer> root = ll.generateList(datalist);
		LLPartitionX par = new LLPartitionX();
		par.partition(3, root);
		System.out.println(root);

	}

}
