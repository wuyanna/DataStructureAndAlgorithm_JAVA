/*
 * Given an array of integers, every element appears three times 
 * except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could 
 * you implement it without using extra memory?
 * 
 */
package com.question.LeetCode;

public class SingleNumber {

	public int singleNumber(int[] A) {
		int res = 0;
		int bit = 0;
		for (int i = 0; i < 32; i++) {
			bit = 0;
			for (int n : A) {
				bit += ((n >> i) & 1);
			}
			bit = bit % 3;
			res |= bit << i;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1 };
		SingleNumber s = new SingleNumber();
		System.out.print(s.singleNumber(A));

	}

}
