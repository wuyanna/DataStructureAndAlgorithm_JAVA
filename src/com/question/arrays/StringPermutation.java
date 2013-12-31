/* 
 * Cracking the coding interview (5th edition)
 * Chapter 1 - Arrays and Strings
 * 
 * Question 1.3 (pg 73)
 * Given two strings, write a method to decide if one is a permutation of the other.
 * 
 * Solution - pg 174
 * 
 */
package com.question.arrays;

public class StringPermutation {
	
	/* TODO:
	 * 1. try using loop
	 * 2. sort first
	 */
	
	public boolean isPermutation(char[] str1, char[] str2) {
		
		if (str1.length != str2.length) return false;
		if (str1.length == 0) {
			return true;
		}
		char hd = str1[0];
		if (str1.length == 1) {
			return hd == str2[0];
		}
		char[] newstr1 = new char[str1.length-1];
		char[] newstr2 = new char[str2.length-1];
		for (int i = 0; i < str2.length; i++) {
			if (hd == str2[i]) {
				System.arraycopy(str2, 0, newstr2, 0, i);
				System.arraycopy(str2, i+1, newstr2, i, str2.length-1-i);
				System.arraycopy(str1, 1, newstr1, 0, str1.length-1);
				return isPermutation(newstr1,newstr2);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		StringPermutation perm = new StringPermutation();
		String str1 = "";
		String str2 = "";
		if(perm.isPermutation(str1.toCharArray(), str2.toCharArray()))
			System.out.println(str2 + " is permutation of " + str1);
		else 
			System.out.println(str2 + " is not permutation of " + str1);

	}

}
