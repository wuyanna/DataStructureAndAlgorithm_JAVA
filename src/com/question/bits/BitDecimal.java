/* 
 * Cracking the coding interview (5th edition)
 * Chapter 5 - Bit Manipulation
 * 
 * Question 5.2
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
 * print the binary representation. If the number cannot be represented accurately
 * in binary with at most 32 characters, print "ERROR".
 * 
 * Solution - pg 243
 * 
 */
package com.question.bits;

public class BitDecimal {
	
	public static String bitDecimal(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuffer buf = new StringBuffer();
		buf.append("0.");
		while (num > 0) {
			if (buf.length() >= 32) {
				return "ERROR";
			}
			num = num * 2;
			if (num >= 1) {
				buf.append("1");
				num -= 1;
			} else {
				buf.append("0");
			}
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		System.out.print(bitDecimal(0.625));
	}

}
