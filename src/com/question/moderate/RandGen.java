/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.11
 * Implement a method rand7() given rand5(). That is, given a method 
 * that generates a random number between 0 and 4 (inclusive), write
 * a method that generates a random number between 0 and 6 (inclusive).
 * 
 * Solution - pg 447
 * 
 */
package com.question.moderate;

public class RandGen {

	public static int rand7() {
		while (true) {
			int num = 5 * rand5() + rand5();
			if (num < 21) {
				return num % 7;
			}
		}
	}

	public static int rand5() {
		return (int) Math.floor(Math.random() * 5);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.print(rand7() + " ");
		}
	}

}
