/* 
 * Cracking the coding interview (5th edition)
 * Chapter 18 - Hard
 * 
 * Question 18.7
 * Given a list of words, write a program to find the longest word made of other
 * words in the list.
 * EXAMPLE
 * Input: cat, banana, dog, nana, walk, walker, dogwalker
 * Output: dogwalker
 * 
 * Solution - pg 471
 * 
 */
package com.question.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;

public class WordCombine {

	private static class LengthComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			return ((Integer) s2.length()).compareTo(s1.length());
		}

	}

	public static String getLongestWord(String[] arr) {
		Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
		for (String s : arr) {
			table.put(s, true);
		}

		Arrays.sort(arr, new LengthComparator());

		for (String s : arr) {
			if (canBuildWord(s, table, true)) {
				return s;
			}
		}
		return null;
	}

	public static boolean canBuildWord(String s,
			Hashtable<String, Boolean> table, boolean isOriginal) {
		if (!isOriginal) {
			if (table.containsKey(s)) {
				return table.get(s);
			}
		}
		for (int i = 1; i < s.length(); i++) {
			String subL = s.substring(0, i);
			String subR = s.substring(i);
			if (table.containsKey(subL) && table.get(subL) == true
					&& canBuildWord(subR, table, false)) {
				return true;
			}
		}
		table.put(s, false);
		return false;
	}

	public static void main(String[] args) {
		String[] arr = { "ba", "cat", "banana", "dog", "nana", "walk",
				"walker", "dogwalker" };
		System.out.print(getLongestWord(arr));

	}

}
