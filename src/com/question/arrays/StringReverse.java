/* 
 * Cracking the coding interview (5th edition)
 * Chapter 1 - Arrays and Strings
 * 
 * Question 1.2 (pg 73)
 * Implement a function void reverse(char* str) in C or C++ 
 * which reverses a null-terminated string.
 * 
 * Solution - pg 173
 * 
 */
package com.question.arrays;

public class StringReverse {
	
	public void reverse(char[] chars) {
		int length = chars.length;
		for (int i = 0; i < length / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[length-i-1];
			chars[length-i-1] = temp;
		}
	}

	public static void main(String[] args) {
		StringReverse rev = new StringReverse();
		char[] str = "hello world".toCharArray();
		rev.reverse(str);
		System.out.print(str);

	}

}
