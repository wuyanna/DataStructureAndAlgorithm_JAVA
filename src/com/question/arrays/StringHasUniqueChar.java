/* 
 * Cracking the coding interview (5th edition)
 * Chapter 1 - Arrays and Strings
 * 
 * Question 1.1 (pg 73)
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 * 
 * Solution - pg 172
 * 
 */
package com.question.arrays;

public class StringHasUniqueChar {
	
	public boolean hasUniqueChar (String str) {
		char[] chars = str.toCharArray();
		// ascii 7bit
		int asciiFlags = 0;
		for (char c : chars) {
			if ((asciiFlags & (1 << c)) != 0) return false;
			asciiFlags |= 1 << c;
		}
		return true;
	}
	
	public static void main(String[] args) {
		StringHasUniqueChar shuc = new StringHasUniqueChar();
		String s = "he3q5nlo";
		if (shuc.hasUniqueChar(s))
			System.out.println(s + " has all unique chars");
		else
			System.out.println(s + " does not have all unique chars");
	}

}
