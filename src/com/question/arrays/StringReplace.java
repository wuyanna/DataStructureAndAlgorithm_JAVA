/* 
 * Cracking the coding interview (5th edition)
 * Chapter 1 - Arrays and Strings
 * 
 * Question 1.4 (pg 73)
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space 
 * at the end of the string to hold the additional characters,
 * and that you are given the 'true' length of the string.
 * (Note: if implementing in Java, please use a character array
 * so that you can perform this operation in place.)
 * EXAMPLE:
 * Input: "Mr John Smith    "
 * Output: "Mr%20John%20Smith"
 * 
 * Solution - pg 175
 * 
 */
package com.question.arrays;

public class StringReplace {
	
	public void replace(char[] str) {
		int fromPointer = str.length - 1;
		int toPointer = fromPointer;
		while (str[fromPointer] == ' ') {
			fromPointer--;
		}
		while (fromPointer >= 0) {
			
			if (str[fromPointer] == ' ') {
				str[toPointer--] = '0';
				str[toPointer--] = '2';
				str[toPointer--] = '%';
				fromPointer--;
			} else {
				str[toPointer] = str[fromPointer];
				toPointer--;
				fromPointer--;
			}
		}
	}

	public static void main(String[] args) {
		StringReplace rep = new StringReplace();
		char[] rstr = "Mr John Smith    ".toCharArray();
		rep.replace(rstr);
		System.out.println(rstr);

	}

}
