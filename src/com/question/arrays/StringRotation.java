/* 
 * Cracking the coding interview (5th edition)
 * Chapter 1 - Arrays and Strings
 * 
 * Question 1.8
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, 
 * write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g., "waterbottle" is a rotation of "erbottlewat").
 * 
 * Solution - pg 181
 * 
 */
package com.question.arrays;

public class StringRotation {
	
	public boolean isRotation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		String strn = str1.concat(str1);
		return strn.contains(str2);
	}

	public static void main(String[] args) {
		StringRotation rot = new StringRotation();
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		if (rot.isRotation(str1, str2)) {
			System.out.println(str1 + " is a rotation of " + str2);
		} else {
			System.out.println(str1 + " is not a rotation of " + str2);
		}
		
	}

}
