/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.11
 * Given a boolean expression consisting of the symbols 0, 1, &, |, and ^, and a desired
 * boolean result value result, implement a function to count the number of ways of
 * parenthesizing the expression such that it evaluates to result.
 * EXAMPLE
 * Expression: 1^0|0|1
 * Desired result: false (0)
 * Output: 2 ways. 1^((0|0)|1) and 1^(0|(0|1)).
 * 
 * Solution - pg 335
 * 
 */
package com.question.recursions;

public class ExpParenResult {

	public static int countExp(char[] expStr, int result) {
		if (expStr.length <= 0)
			return 0;
		if (expStr.length < 3 && expStr.length > 0) {
			if (expStr[0] == '0' && result == 0) {
				return 1;
			}
			if (expStr[0] == '1' && result == 1) {
				return 1;
			}
			return 0;
		}
		int count = 0;
		for (int i = 1; i < expStr.length; i += 2) {
			char c = expStr[i];
			char[] sub1 = new char[i];
			char[] sub2 = new char[expStr.length - i - 1];
			System.arraycopy(expStr, 0, sub1, 0, i);
			System.arraycopy(expStr, i + 1, sub2, 0, expStr.length - i - 1);
			if (c == '&') {
				if (result == 1) {
					count += (countExp(sub1, 1) * countExp(sub2, 1));
				} else {
					count += (countExp(sub1, 1) * countExp(sub2, 0));
					count += (countExp(sub1, 0) * countExp(sub2, 1));
					count += (countExp(sub1, 0) * countExp(sub2, 0));
				}

			} else if (c == '|') {
				if (result == 1) {
					count += (countExp(sub1, 1) * countExp(sub2, 1));
					count += (countExp(sub1, 1) * countExp(sub2, 0));
					count += (countExp(sub1, 0) * countExp(sub2, 1));
				} else {
					count += (countExp(sub1, 0) * countExp(sub2, 0));
				}
			} else if (c == '^') {
				if (result == 1) {
					count += (countExp(sub1, 1) * countExp(sub2, 0));
					count += (countExp(sub1, 0) * countExp(sub2, 1));
				} else {
					count += (countExp(sub1, 1) * countExp(sub2, 1));
					count += (countExp(sub1, 0) * countExp(sub2, 0));
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String exp = "1^0|0|1";
		System.out.print(countExp(exp.toCharArray(), 0));
	}

}
