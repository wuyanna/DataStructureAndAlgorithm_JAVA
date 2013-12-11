package com.ds.linkedlist;

public class SinglyLinkedList<T> {

	private Node<T> head;

	public SinglyLinkedList() {
		head = null;
	}

	public void addFirst(T element) {

		Node<T> node = new Node<T>(element, head);
		this.head = node;
	}

	public void addLast(T element) {
		Node<T> node = new Node<T>(element, null);
		Node<T> temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	public T getFirst() {
		return this.head.data;
	}

	public T getLast() {
		if (this.head == null) return null;
		Node<T> temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

	public T removeFirst() {
		if (this.head == null) return null;
		Node<T> node = this.head;
		this.head = node.next;
		return node.data;

	}

	public T removeLast() {
		if (this.head == null) return null;
		Node<T> temp = this.head;
		Node<T> prev = temp;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
		return temp.data;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		if (this.head == null) return "-";
		Node<T> temp = this.head;
		while (temp.next != null) {
			buf.append(temp.data.toString() + "->");
			temp = temp.next;
		}
		buf.append(temp.data.toString());
		return buf.toString();
	}

	private static class Node<T> {
		private Node<T> next;
		private T data;

		public Node(T data, Node<T> next) {
			this.next = next;
			this.data = data;
		}
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
	}
}
