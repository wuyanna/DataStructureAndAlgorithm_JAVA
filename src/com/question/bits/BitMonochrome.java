/* 
 * Cracking the coding interview (5th edition)
 * Chapter 5 - Bit Manipulation
 * 
 * Question 5.8
 * A monochrome screen is stored as a single array of bytes, allowing eight 
 * consecutive pixels to be stored in one byte. The screen has width w, where
 * w is divisible by 8 (that is, no byte will be split across rows). The height
 * of the screen, of course, can be derived from the length of the array and
 * the width. Implement a function drawHorizontalLine(byte[] screen, int x1,
 * int x2, int y) which draws a horizontal line from (x1, y) to (x2, y).
 * 
 * Solution - pg 255
 * 
 */
package com.question.bits;

public class BitMonochrome {

	private int width; // divisible by 8

	public BitMonochrome(int width) {
		this.width = width;
	}

	public void drawHorizontalLine(byte[] screen, int x1, int x2, int y) {
		int startByte = y * this.width / 8 + x1 / 8;
		int endByte = y * this.width / 8 + x2 / 8;
		int startOffset = x1 % 8;
		int endOffset = x2 % 8;
		for (int i = startByte; i <= endByte; i++) {
			if (i == startByte) {
				screen[i] |= (byte) ~(~0 << (8 - startOffset));
				if (i == endByte) {
					screen[i] &= (byte) (~0 << (8 - endOffset));
				}
			} else if (i == endByte) {
				screen[i] |= (byte) ~(~0 << (endOffset + 1));
			} else {
				screen[i] = (byte) ~0;
			}
		}
	}

	public static void main(String[] args) {
		byte[] screen = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int width = 24;
		BitMonochrome mono = new BitMonochrome(width);
		mono.drawHorizontalLine(screen, 3, 9, 2);
		int w = width / 8;
		for (int i = 0; i < screen.length; i++) {
			if (i % w == 0) {
				System.out.print("\n");
			}
			System.out.print(Integer.toBinaryString(screen[i]) + " ");
		}
	}

}
