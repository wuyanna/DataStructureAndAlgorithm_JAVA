/* 
 * Cracking the coding interview (5th edition)
 * Chapter 1 - Arrays and Strings
 * 
 * Question 1.5
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string.
 * 
 * Solution - pg 172
 * 
 */
package com.question.arrays;

public class StringCompression {
	
	public char[] compress(char[] str) {
		if (str.length == 0) return new char[0];
		char lastChar = str[0];
		int count = 1;
		while (count < str.length && str[count] == lastChar) {
			count++;
		}
		char[] remain = new char[str.length - count];
		System.arraycopy(str, count, remain, 0, str.length-count);
		char[] next = compress(remain);
		char[] number = String.valueOf(count).toCharArray();
		char[] result = new char[next.length + number.length + 1];
		result[0] = lastChar;
		
		System.arraycopy(number, 0, result, 1, number.length);
		System.arraycopy(next, 0, result, number.length+1, next.length);
		return result;
	}
	
	public char[] doCompress(char[] str) {
		char[] res = compress(str);
		if (res.length < str.length) return res;
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompression comp = new StringCompression();
		char[] str = "gddddddgc".toCharArray();
		char[] strc = comp.doCompress(str);
		System.out.println(strc);
	}

}
