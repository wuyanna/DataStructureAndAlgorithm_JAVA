/* 
 * Cracking the coding interview (5th edition)
 * Chapter 5 - Bit Manipulation
 * 
 * Question 5.6
 * Write a program to swap odd and even bits in an integer with as few instructions
 * as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and
 * so on).
 * 
 * Solution - pg 251
 * 
 */
package com.question.bits;

public class BitSwap {

	public static int swapBits(int a) {
		int res = 0;
		for (int i = 0; i < 32; i += 2) {
			int bits = 0;
			switch ((a >> i) & 3) {
			case 0:
				bits = 0;
				break;
			case 1:
				bits = 2;
				break;
			case 2:
				bits = 1;
				break;
			case 3:
				bits = 3;
				break;
			default:
				break;
			}
			res += bits << i;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.print(Integer.toBinaryString(swapBits(0x77)));
	}

}
