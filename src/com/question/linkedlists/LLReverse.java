package com.question.linkedlists;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyLinkedListNode;

public class LLReverse {

	public SinglyLinkedListNode<Integer> reverse(
			SinglyLinkedListNode<Integer> curr) {
		SinglyLinkedListNode<Integer> prev = null;
		SinglyLinkedListNode<Integer> temp = null;
		while (curr != null) {
			temp = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public SinglyLinkedListNode<Integer> reverse2(
			SinglyLinkedListNode<Integer> head) {
		SinglyLinkedListNode<Integer> next;
		SinglyLinkedListNode<Integer> result = head;
		if (head == null)
			return null;
		if (head.getNext() != null) {
			next = head.getNext();
			result = reverse2(next);
			next.setNext(head);
			head.setNext(null);
		}
		return result;
	}

	public SinglyLinkedListNode<Integer> reverse2(
			SinglyLinkedListNode<Integer> ptr,
			SinglyLinkedListNode<Integer> prev) {
		SinglyLinkedListNode<Integer> temp = ptr;
		if (ptr == null) return null;
		if (ptr.getNext() != null) {
			temp = reverse2(ptr.getNext(),ptr);
		}
		ptr.setNext(prev);
		return temp;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		Integer[] datalist = { 2, 1, 2, 3, 3, 4, 3, 5 };
		SinglyLinkedListNode<Integer> root = ll.generateList(datalist);
		LLReverse rev = new LLReverse();
		System.out.println(rev.reverse2(root,null));

	}

}
