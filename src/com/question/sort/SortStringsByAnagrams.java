/* 
 * Cracking the coding interview (5th edition)
 * Chapter 11 - Sorting and Searching
 * 
 * Question 11.2
 * Write a method to sort an array of strings so that all the anagrams are next to
 * each other.
 * 
 * Solution - pg 361
 * 
 */
package com.question.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;

public class SortStringsByAnagrams {

	public static class AnagramComparator implements Comparator<String> {

		@Override
		public int compare(String str1, String str2) {
			Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
			for (Character c : str1.toCharArray()) {
				Integer num = table.get(c);
				if (num != null) {
					table.put(c, num + 1);
				} else {
					table.put(c, 1);
				}
			}
			for (Character c : str2.toCharArray()) {
				Integer num = table.get(c);
				if (num != null) {
					table.put(c, num - 1);
				} else {
					table.put(c, -1);
					break;
				}
			}
			Enumeration<Character> iter = table.keys();
			while (iter.hasMoreElements()) {
				Character c = iter.nextElement();
				if (table.get(c) != 0) {
					return str1.compareTo(str2);
				}
			}
			return 0;
		}

	}

	public static void main(String[] args) {
		String[] list = { "iam", "kk", "ami" };
		Arrays.sort(list, new AnagramComparator());
		for (String str : list) {
			System.out.print(str + ", ");
		}
	}

}
