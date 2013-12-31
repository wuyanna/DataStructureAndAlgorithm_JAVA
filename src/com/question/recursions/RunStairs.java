/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.1
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps,
 * or 3 steps at a time. Implement a method to count how many possible ways the child
 * can run up the stairs.
 * 
 * Solution - pg 316
 * 
 */
package com.question.recursions;

public class RunStairs {

	public static int hops(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return hops(n - 1) + hops(n - 2) + hops(n - 3);
	}

	public static void main(String[] args) {
		System.out.print(hops(4));
	}

}
