/* 
 * Cracking the coding interview (5th edition)
 * Chapter 3 - Stacks and Queues
 * 
 * Question 3.2
 * How would you design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 * 
 * Solution - pg 206
 * 
 */
package com.question.stackqueue;

import com.ds.stack.ArrayStack;
import com.ds.stack.IStack;

public class StackWithMin<T extends Comparable<T>> implements IStack<T> {

	private IStack<T> stack;
	private IStack<T> compare;

	public StackWithMin() {
		this.stack = new ArrayStack<T>();
		this.compare = new ArrayStack<T>();
	}

	@Override
	public void push(T obj) {
		this.stack.push(obj);
		if (this.compare.isEmpty() || this.compare.peek().compareTo(obj) >= 0) {
			this.compare.push(obj);
		}
	}

	@Override
	public T pop() {
		T obj = this.stack.pop();
		if (!this.compare.isEmpty() && this.compare.peek().compareTo(obj) == 0) {
			this.compare.pop();
		}
		return obj;
	}

	@Override
	public T peek() {
		return this.stack.peek();
	}

	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	public T getMin() {
		return compare.peek();
	}

	@Override
	public String toString() {
		return stack.toString() + ": " + getMin().toString();
	}

	public static void main(String[] args) {
		IStack<Integer> stack = new StackWithMin<Integer>();
		stack.push(45);
		stack.push(23);
		stack.push(98);
		stack.push(11);
		stack.push(78);
		stack.push(21);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}

}
