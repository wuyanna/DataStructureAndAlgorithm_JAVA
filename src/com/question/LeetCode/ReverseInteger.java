/*
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
package com.question.LeetCode;

public class ReverseInteger {

	public static void main(String[] args) {
		int number = -123;
		ReverseInteger integer = new ReverseInteger();
		System.out.println(integer.reverse(number));
		System.out.println(integer.reverseR(number,0));
	}

	public int reverse(int x) {
		int result = 0;
		while(x != 0) {
			result *= 10;
			result += (x % 10);
			x /= 10;
		}
		return result;
	}

	// recursive
	public int reverseR(int x, int result) {
		if (x == 0)
			return result;
		int a = x % 10;
		int b = x / 10;
		return reverseR(b, a + result * 10);
	}
}
