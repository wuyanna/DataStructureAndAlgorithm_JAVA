/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.4
 * Write a method which finds the maximum of two numbers. You should not use 
 * if-else or any other comparison operator.
 * 
 * Solution - pg 436
 * 
 */
package com.question.moderate;

public class Maximum {

	public static int max(int a, int b) {
		int[] arr = { a, b };
		int diff = a - b;
		return arr[diff >>> 31];
	}

	public static void main(String[] args) {
		System.out.print(max(33, 4));
	}

}
