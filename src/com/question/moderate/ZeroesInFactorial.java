/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.3
 * Write an algorithm which computes the number of trailing zeroes in n factorial.
 * 
 * Solution - pg 434
 * 
 */
package com.question.moderate;

public class ZeroesInFactorial {

	public static int numberOfTrailingZeroes(long n) {
		int count = 0;
		long temp = n / 10 * 10;
		while (n == temp) {
			count++;
			for (int i = 0; i <= count; i++) {
				temp /= 10;
			}
			for (int i = 0; i <= count; i++) {
				temp *= 10;
			}
		}
		return count;
	}

	public static long factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		long n = factorial(9);
		System.out.print(n + " ");
		System.out.print(numberOfTrailingZeroes(n));
	}

}
