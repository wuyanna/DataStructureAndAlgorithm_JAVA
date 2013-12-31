package com.question.LeetCode;
/*Question:
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberSolution {
	public static void main(String[] args) {
		int[] A = { 2, 4, 2, 5, 4, 6, 5 };
		SingleNumberSolution s = new SingleNumberSolution();
		System.out.print(s.singleNumber(A));
	}
 /* since the 1^1^2^1 = 2
  * O(n) time complexity without extra space
  */
	public int singleNumber(int[] A) {
		int x = 0;
		for (int i = 0; i < A.length; i++) {
			x ^= A[i];
		}
		return x;
	}
}

