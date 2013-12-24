/* 
 * Cracking the coding interview (5th edition)
 * Chapter 5 - Bit Manipulation
 * 
 * Question 5.1
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write
 * a method to insert M into N such that M starts at bit j and ends at bit i. You can
 * assume that the bits j through i have enough space to fit all of M. That is, if
 * M = 10011, you can assume that there are at least 5 bits between j and i. You
 * would not, for example, have j = 3 and i = 2, because M could not fully fit
 * between bit 3 and bit 2.
 * EXAMPLE
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 * 
 * Solution - pg 242
 * 
 */
package com.question.bits;

public class BitInsert {
	
	public int bitInsert(int N, int M, int i, int j) {
		int Mm = M << i;
		int mask = (-1 << j) | ~(-1 << i);
		return N & mask | Mm;
	}

	public static void main(String[] args) {
		BitInsert ins = new BitInsert();
		System.out.print(Integer.toBinaryString(ins.bitInsert(0x400, 0x13, 2, 6)));

	}

}
