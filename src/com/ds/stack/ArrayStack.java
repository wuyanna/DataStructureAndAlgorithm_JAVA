package com.ds.stack;


public class ArrayStack<T> implements IStack<T> {
	
	private static final Integer INITIAL_CAPACITY = 6;
	private T[] array;
	private Integer nItems;
	
	

	public ArrayStack() {
		this.array = (T[]) new Object[INITIAL_CAPACITY];
		nItems = 0;
	}

	@Override
	public void push(T obj) {
		if (isFull()) {
			T[] newArray = (T[]) new Object[array.length*2];
			System.arraycopy(array, 0, newArray, 0, nItems);
			this.array = newArray;
		}
		this.array[nItems] = obj;
		nItems++;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Cannot pop empty stack");
		}
		return this.array[--nItems];
	}

	@Override
	public T peek() {
		if (!isEmpty()) {
			return this.array[nItems-1];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	private boolean isFull() {
		return nItems >= array.length;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < nItems; i++) {
			buf.append(this.array[i] + " ");
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		IStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(45);
		stack.push(23);
		stack.push(98);
		stack.push(11);
		stack.push(78);
		stack.push(21);
		System.out.println(stack);
	}

}
