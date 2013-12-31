/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.1
 * Write a function to swap a number in place (that is, without temporary variables).
 * 
 * Solution - pg 430
 * 
 */
package com.question.moderate;

public class SwapInPlace {

	public static void swap(int a, int b) {
		System.out.println("Origin: (" + a + ", " + b + ")");
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("Swapped: (" + a + ", " + b + ")");
	}

	public static void main(String[] args) {
		swap(3, 4);
	}

}
