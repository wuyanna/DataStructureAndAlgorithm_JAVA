/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.6
 * Implement an algorithm to print all valid (e.g., properly opened and closed)
 * combinations of n-pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 * 
 * Solution - pg 325
 * 
 */
package com.question.recursions;

import java.util.ArrayList;

public class PrintParentheses {

	public static ArrayList<String> printParentheses(int num) {
		if (num == 0) {
			ArrayList<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}
		ArrayList<String> res = printParentheses(num - 1);
		ArrayList<String> nres = new ArrayList<String>();
		for (String s : res) {
			String ns = s + "()";
			if (!nres.contains(ns)) {
				nres.add(ns);
			}
		}
		for (String s : res) {
			String ns = "()" + s;
			if (!nres.contains(ns)) {
				nres.add(ns);
			}
		}
		for (String s : res) {
			String ns = "(" + s + ")";
			if (!nres.contains(ns)) {
				nres.add(ns);
			}
		}
		return nres;

	}

	public static void main(String[] args) {
		System.out.print(printParentheses(3));
	}

}
