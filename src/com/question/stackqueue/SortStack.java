/* 
 * Cracking the coding interview (5th edition)
 * Chapter 3 - Stacks and Queues
 * 
 * Question 3.6
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy
 * the elements into any other data structure (such as an array). The stack supports
 * the following operations: push, pop, peek, and isEmpty.
 * 
 * Solution - pg 215
 * 
 */
package com.question.stackqueue;

import com.ds.stack.ArrayStack;
import com.ds.stack.IStack;


public class SortStack<T extends Comparable<T>> {

	public IStack<T> sort(IStack<T> stackSrc) {
		IStack<T> result = new ArrayStack<T>();
		while (!stackSrc.isEmpty()) {
			T obj = stackSrc.pop();
			int popCount = 0;
			while (!result.isEmpty() && obj.compareTo(result.peek()) < 0) {
				stackSrc.push(result.pop());
				popCount++;
			}
			result.push(obj);
			for (int i = 0; i < popCount; i++) {
				result.push(stackSrc.pop());
			}
		}
		return result;
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
		SortStack<Integer> sortstack = new SortStack<Integer>();
		System.out.println(sortstack.sort(stack));

	}

}
