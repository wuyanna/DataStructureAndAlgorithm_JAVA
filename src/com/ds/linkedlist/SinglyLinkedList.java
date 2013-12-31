package com.ds.linkedlist;

public class SinglyLinkedList<T> {

	private SinglyLinkedListNode<T> head;

	public SinglyLinkedList() {
		head = null;
	}

	public void addFirst(T element) {

		SinglyLinkedListNode<T> node = new SinglyLinkedListNode<T>(head, element);
		this.head = node;
	}

	public void addLast(T element) {
		SinglyLinkedListNode<T> node = new SinglyLinkedListNode<T>(null, element);
		if (this.head == null) {
			this.head = node;
		} else {
			SinglyLinkedListNode<T> temp = this.head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
	}

	public T getFirst() {
		return this.head.getData();
	}

	public T getLast() {
		if (this.head == null) return null;
		SinglyLinkedListNode<T> temp = this.head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp.getData();
	}

	public T removeFirst() {
		if (this.head == null) return null;
		SinglyLinkedListNode<T> node = this.head;
		this.head = node.getNext();
		return node.getData();

	}

	public T removeLast() {
		if (this.head == null) return null;
		SinglyLinkedListNode<T> temp = this.head;
		SinglyLinkedListNode<T> prev = temp;
		while (temp.getNext() != null) {
			prev = temp;
			temp = temp.getNext();
		}
		prev.setNext(null);
		return temp.getData();
	}
	
	public SinglyLinkedListNode<T> generateList(T[] datalist) {
		SinglyLinkedList<T> ll = new SinglyLinkedList<T>();
		for (T d : datalist) {
			ll.addLast(d);
		}
		return ll.head;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		if (this.head == null) return "-";
		SinglyLinkedListNode<T> temp = this.head;
		while (temp.getNext() != null) {
			buf.append(temp.getData().toString() + "->");
			temp = temp.getNext();
		}
		buf.append(temp.getData().toString());
		return buf.toString();
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addFirst(1);
		list.addFirst(3);
		list.addLast(5);
		list.addFirst(7);
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		
		Integer[] ds = {2,34,2,55};
		SinglyLinkedListNode<Integer> root = list.generateList(ds);
		System.out.println(root);
	}
}
