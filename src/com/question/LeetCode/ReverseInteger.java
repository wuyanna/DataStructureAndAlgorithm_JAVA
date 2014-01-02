/*
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */

package com.question.LeetCode;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = -123;
		ReverseInteger integer = new ReverseInteger();
		System.out.print(integer.reverse(number));
	}

	public int reverse(int x) {
		int result = 0;
		int num;
		// 12
		while (x != 0) {
			num = x % 10;// 2
			x = x / 10;// 1
			result = result * 10 + num;
		}
		return result;
	}
}
