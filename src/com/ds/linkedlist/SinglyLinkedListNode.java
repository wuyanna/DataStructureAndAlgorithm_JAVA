package com.ds.linkedlist;

public class SinglyLinkedListNode<T> {

	private SinglyLinkedListNode<T> next;
	private T data;

	public SinglyLinkedListNode(SinglyLinkedListNode<T> next, T data) {
		this.next = next;
		this.data = data;
	}

	public SinglyLinkedListNode<T> getNext() {
		return this.next;
	}

	public void setNext(SinglyLinkedListNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		SinglyLinkedListNode<T> temp = this;
		while (temp.getNext() != null) {
			buf.append(temp.getData().toString() + "->");
			temp = temp.getNext();
		}
		buf.append(temp.getData().toString());
		return buf.toString();
	}

}
