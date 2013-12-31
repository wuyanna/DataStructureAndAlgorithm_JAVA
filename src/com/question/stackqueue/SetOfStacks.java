/* 
 * Cracking the coding interview (5th edition)
 * Chapter 3 - Stacks and Queues
 * 
 * Question 3.3
 * Imagine a (literal) stack of plates. 
 * If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack 
 * when the previous stack exceeds some threshold. 
 * Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks and 
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave 
 * identically to a single stack (that is, 
 * pop() should return the same values as it would 
 * if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs 
 * a pop operation on a specific sub-stack.
 * 
 * Solution - pg 208
 * 
 */
package com.question.stackqueue;

import java.util.ArrayList;

import com.ds.stack.ArrayStack;
import com.ds.stack.IStack;

public class SetOfStacks<T> implements IStack<T> {

	private ArrayList<IStack<T>> stacks;
	private Integer threshold;
	private Integer nItems;

	public SetOfStacks(Integer threshold) {
		this.threshold = threshold;
		this.nItems = 0;
		this.stacks = new ArrayList<IStack<T>>();
	}

	private IStack<T> getStackById(int index) {
		int stackId = index / threshold;
		if (stackId >= stacks.size()) {
			stacks.add(new ArrayStack<T>());
		}
		return stacks.get(stackId);
	}

	@Override
	public void push(T obj) {
		getStackById(nItems++).push(obj);
	}

	@Override
	public T pop() {
		IStack<T> stack = getStackById(--nItems);
		if (stack.isEmpty()) {
			return this.pop();
		}
		return stack.pop();
	}

	@Override
	public T peek() {
		return getStackById(nItems - 1).peek();
	}

	@Override
	public boolean isEmpty() {
		return nItems == 0;
	}

	public T popAt(int index) {
		IStack<T> stack = stacks.get(index);
		return stack.pop();
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (IStack<T> s : stacks) {
			buf.append("[" + s.toString() + "]");
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		IStack<Integer> stack = new SetOfStacks<Integer>(5);
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
		stack.push(45);
		stack.push(23);
		stack.push(98);
		stack.push(11);
		stack.push(78);
		stack.push(21);
		stack.push(45);
		stack.push(23);
		stack.push(98);
		System.out.println(stack);
		((SetOfStacks<Integer>)stack).popAt(1);
		System.out.println(stack);
		((SetOfStacks<Integer>)stack).popAt(1);
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
		stack.pop();
		System.out.println(stack);
	}

}
