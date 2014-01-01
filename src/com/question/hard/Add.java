/* 
 * Cracking the coding interview (5th edition)
 * Chapter 18 - Hard
 * 
 * Question 18.1
 * Write a function that adds two numbers. You should not use + or any arithmetic
 * operators.
 * 
 * Solution - pg 462
 * 
 */
package com.question.hard;

public class Add {
	
	public static int add(int a, int b) {
		if (b == 0) return a;
		int x = a ^ b;
		int c = (a & b) << 1;
		return add(x,c);
	}

	public static void main(String[] args) {
		System.out.print(add(27,65));
	}

}
