/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.8
 * You are given an array of integers (both positive and negative). Find the 
 * contiguous sequence with the largest sum. Return the sum.
 * EXAMPLE
 * Input: 2, -8, 3, -2, 4, -10
 * Output: 5 (i.e., {3, -2, 4})
 * 
 * Solution - pg 443
 * 
 */
package com.question.moderate;

public class ContiguousSequence {

	public static int findLargestSum(int[] array) {
		int max_sum = 0;
		for (int i = 0; i < array.length; i++) {
			int curr_max_sum = 0;
			int curr_sum = 0;
			for (int j = i; j < array.length; j++) {
				curr_sum = curr_sum + array[j];
				if (curr_sum > curr_max_sum)
					curr_max_sum = curr_sum;
			}
			if (curr_max_sum > max_sum)
				max_sum = curr_max_sum;
		}
		return max_sum;

	}

	public static void main(String[] args) {
		int[] arr = { 2, -8, 3, -2, 4, -10 };
		System.out.print(findLargestSum(arr));

	}

}
