package com.question.linkedlists;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyLinkedListNode;

public class LLDeleteMiddleNode {
	
	public void deleteMiddleNode(SinglyLinkedListNode<Integer> middle) {
		SinglyLinkedListNode<Integer> temp = middle.getNext();
		if (temp != null) {
			middle.setNext(temp.getNext());
			middle.setData(temp.getData());
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		Integer[] datalist = { 2, 1, 2, 3, 4, 3, 5 };
		SinglyLinkedListNode<Integer> root = ll.generateList(datalist);
		LLDeleteMiddleNode del = new LLDeleteMiddleNode();
		del.deleteMiddleNode(root.getNext().getNext().getNext());
		System.out.println(root);
	}

}
