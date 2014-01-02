/* 
 * Cracking the coding interview (5th edition)
 * Chapter 18 - Hard
 * 
 * Question 18.4
 * Write a method to count the number of 2s that appear in all the numbers
 * between 0 and n (inclusive).
 * EXAMPLE
 * Input: 25
 * Output: 9 (2, 12, 20, 21, 22, 23, 24 and 25. Note that 22 counts for two 2s.)
 * 
 * Solution - pg 465
 * 
 */
package com.question.hard;

public class Count2s {

	public static int count(int n) {
		int count = 0;
		for (Integer i = 0; i <= n; i++) {
			char[] digits = i.toString().toCharArray();
			for (char c : digits) {
				if (c == '2')
					count++;
			}
		}
		return count;
	}

	public static int count(int n, int lv) {
		int nt = n / (10 * lv);
		int ns = n - nt * 10 * lv;
		int addition = 0;
		if (ns / lv > 2) {
			addition = lv;
		} else if (ns / lv == 2) {
			addition = n - n / lv * lv + 1;
		}
		int num = nt * lv + addition;
		if (nt == 0)
			return num;
		return num + count(n, 10 * lv);
	}

	public static void main(String[] args) {
		int n = 598;
		System.out.println("Solution: " + count(n));
		System.out.println("Test: " + count(n, 1));
	}

}
