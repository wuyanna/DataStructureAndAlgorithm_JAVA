/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.6
 * Given an array of integers, write a method to find indices m and n such that if you
 * sorted elements m through n, the entire array would be sorted. Minimize n - m
 * (that is, find the smallest such sequence).
 * EXAMPLE
 * Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
 * Output: (3, 9)
 * 
 * Solution - pg 439
 * 
 */
package com.question.moderate;

public class SortSequence {

	public int findEndOfLeftSubsequence(int[] array) {
		for (int i = 1; i < array.length; i++) { // Careful, start from 1
			if (array[i] < array[i - 1])
				return i - 1;
		}
		return array.length - 1;
	}

	public int findStartOfRightSubsequence(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) { // start from length - 2
			if (array[i] > array[i + 1])
				return i + 1;
		}
		return 0;
	}

	public int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for (int i = start; i >= 0; i--) {
			if (array[i] <= comp)
				return i + 1; // careful, this is i + 1, not i
		}
		return 0;
	}

	public int shrinkRight(int[] array, int max_index, int start) {
		int comp = array[max_index];
		for (int i = start; i < array.length; i++) {
			if (array[i] >= comp)
				return i - 1;
		}
		return array.length - 1;
	}

	public void findUnsortedSequence(int[] array) {
		int end_left = findEndOfLeftSubsequence(array);
		if (end_left >= array.length - 1)
			return;
		int start_right = findStartOfRightSubsequence(array);

		int min_index = end_left + 1;
		int max_index = min_index;
		for (int i = end_left; i <= start_right; i++) {
			if (array[i] < array[min_index])
				min_index = i;
			if (array[i] > array[max_index])
				max_index = i;
		}
		int left_index = shrinkLeft(array, min_index, end_left);
		int right_index = shrinkRight(array, max_index, start_right);
		System.out.print("(" + left_index + ", " + right_index + ")");
	}

	public static void main(String[] args) {
		SortSequence seq = new SortSequence();
		int[] arr = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		seq.findUnsortedSequence(arr);

	}

}
