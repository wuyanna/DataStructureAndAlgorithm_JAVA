/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.12
 * Design an algorithm to find all pairs of integers within an array which sum to a
 * specified value.
 * 
 * Solution - pg 450
 * 
 */
package com.question.moderate;

import java.util.Arrays;
import java.util.Hashtable;

public class FindSumPairs {

	public static void printSumPairs(int[] array, int sum) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		for (Integer i : array) {
			if (table.containsKey(sum - i)) {
				System.out.print("{" + i + ", " + (sum - i) + "}, ");
			} else {
				table.put(i, true);
			}
		}
	}

	public static void printSumPairs2(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (sum == s) {
				System.out.print("{" + array[first] + ", " + array[last] + "}, ");
				first++;
				last--;
			} else if (sum < s) {
				last--;
			} else {
				first++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] test = {9, 3, 6, 5, 7, -1, 13, 14, -2, 12, 0};
		printSumPairs(test, 12);
		System.out.println();
		printSumPairs2(test, 12);
	}

}
