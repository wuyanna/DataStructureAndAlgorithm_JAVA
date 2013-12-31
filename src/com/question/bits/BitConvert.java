/* 
 * Cracking the coding interview (5th edition)
 * Chapter 5 - Bit Manipulation
 * 
 * Question 5.5
 * Write a function to determine the number of bits required to convert integer A
 * to integer B.
 * EXAMPLE
 * Input: 31, 14
 * Output: 2
 * 
 * Solution - pg 250
 * 
 */
package com.question.bits;

public class BitConvert {

	public static int convertBits(int a, int b) {
		int bits = a ^ b;
		int sum = 0;
		for (int i = 0; i < 32; i++) {
			sum += (bits >> i) & 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.print(convertBits(31, 14));
	}

}
