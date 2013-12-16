/* 
 * Cracking the coding interview (5th edition)
 * Chapter 3 - Stacks and Queues
 * 
 * Question 3.1
 * Describe how you could use a single array to implement three stacks.
 * 
 * Solution - pg 202
 * 
 */
package com.question.stackqueue;


public class ThreeStacksArray<T> {
	private Stack<T> stack1;
	private Stack<T> stack2;
	private Stack<T> stack3;

	public ThreeStacksArray(T[] array) {
		this.stack1 = new Stack<T>(array, 1);
		this.stack2 = new Stack<T>(array, 2);
		this.stack3 = new Stack<T>(array, 3);
	}

	public void push(T obj, Integer stackIdx) throws Exception {
		switch (stackIdx) {
		case 1:
			stack1.push(obj);
			break;
		case 2:
			stack2.push(obj);
			break;
		case 3:
			stack3.push(obj);
			break;
		default:
			break;
		}
	}

	public T pop(Integer stackIdx) throws Exception {
		switch (stackIdx) {
		case 1:
			return stack1.pop();
		case 2:
			return stack2.pop();
		case 3:
			return stack3.pop();
		default:
			break;
		}
		return null;
	}

	public T peek(Integer stackIdx) {
		switch (stackIdx) {
		case 1:
			return stack1.peek();
		case 2:
			return stack2.peek();
		case 3:
			return stack3.peek();
		default:
			break;
		}
		return null;
	}

	public boolean isEmpty(Integer stackIdx) {
		switch (stackIdx) {
		case 1:
			return stack1.isEmpty();
		case 2:
			return stack2.isEmpty();
		case 3:
			return stack3.isEmpty();
		default:
			break;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Stack 1: " + stack1.toString() + "\n"
				+ "Stack 2: " + stack2.toString() + "\n" 
				+ "Stack 3: " + stack3.toString() + "\n";
	}

	private static class Stack<T> {

		private T[] arr;
		private Integer index;
		private Integer bottom;
		private Integer top;
		private Integer brothers;

		public Stack(T[] arr, Integer index) {
			this.arr = arr;
			this.index = index - 1;
			this.bottom = this.index;
			this.top = this.index;
			this.brothers = 3;
		}

		public void push(T obj) throws Exception {			
			if (this.isFull()) {
				throw new Exception("Stack is full");
			}
			this.arr[this.top] = obj;
			this.top += this.brothers;
		}

		public T pop() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("Stack is empty");
			}
			this.top -= this.brothers;
			T obj = this.arr[this.top];
			return obj;
		}

		public T peek() {
			Integer current = this.top - this.brothers;
			T obj = this.arr[current];
			return obj;
		}

		public boolean isEmpty() {
			return this.bottom == this.top;
		}

		private boolean isFull() {
			return this.top > this.arr.length;
		}
		
		@Override
		public String toString() {
			StringBuffer buf = new StringBuffer();
			for (int i = this.bottom; i < this.top; i+=this.brothers) {
				buf.append(this.arr[i] + " ");
			}
			return buf.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		Integer[] arr = new Integer[10];
		ThreeStacksArray<Integer> stacks = new ThreeStacksArray<Integer>(arr);
		stacks.push(1, 1);
		stacks.push(2, 1);
		stacks.push(3, 1);
		stacks.push(1, 2);
		stacks.push(2, 2);
		stacks.push(3, 2);
		stacks.push(1, 3);
		stacks.push(2, 3);
		stacks.push(4, 3);
		System.out.println(stacks);
	}

}
