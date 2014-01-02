/* 
 * Cracking the coding interview (5th edition)
 * Chapter 18 - Hard
 * 
 * Question 18.8
 * Given a string s and an array of smaller strings T, design a method to search s
 * for each small string in T.
 * 
 * Solution - pg 473
 * 
 */
package com.question.hard;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchString {

	// Suffix tree
	private static class SuffixTree {
		SuffixTreeNode root = new SuffixTreeNode();

		public SuffixTree(String s) {
			for (int i = 0; i < s.length(); i++) {
				String suffix = s.substring(i);
				root.insertString(suffix, i);
			}
		}

		public ArrayList<Integer> search(String s) {
			return root.search(s);
		}
	}

	private static class SuffixTreeNode {
		HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
		char value;
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		public void insertString(String s, int index) {
			indexes.add(index);
			if (s != null && s.length() > 0) {
				value = s.charAt(0);
				SuffixTreeNode child = null;
				if (children.containsKey(value)) {
					child = children.get(value);
				} else {
					child = new SuffixTreeNode();
					children.put(value, child);
				}
				String remainder = s.substring(1);
				child.insertString(remainder, index);
			}
		}

		public ArrayList<Integer> search(String s) {
			if (s == null || s.length() == 0) {
				return indexes;
			}
			char first = s.charAt(0);
			if (children.containsKey(first)) {
				String remainder = s.substring(1);
				return children.get(first).search(remainder);
			}
			return null;
		}
	}

	// Naive approach
	public static void searchString(String s, String t, int index,
			ArrayList<Integer> result) {
		if (s == null || s.isEmpty())
			return;
		if (compareString(s, t)) {
			result.add(index);
		}
		searchString(s.substring(1), t, index + 1, result);
	}

	public static boolean compareString(String s, String t) {
		if (t == null || t.length() == 0)
			return true;
		if (s == null || s.length() == 0)
			return false;
		if (s.charAt(0) == t.charAt(0)) {
			return compareString(s.substring(1), t.substring(1));
		}
		return false;
	}

	public static void main(String[] args) {
		// Suffix tree test
		SuffixTree suf = new SuffixTree("banana");
		System.out.println(suf.search("na"));

		// Naive approach test
		ArrayList<Integer> list = new ArrayList<Integer>();
		searchString("banana", "na", 0, list);
		System.out.println(list);
	}

}
