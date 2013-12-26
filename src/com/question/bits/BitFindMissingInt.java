/* 
 * Cracking the coding interview (5th edition)
 * Chapter 5 - Bit Manipulation
 * 
 * Question 5.7
 * An array A contains all the integers from 0 to n, except for one number which is
 * missing. In this problem, we cannot access an entire integer in A with a single 
 * operation. The elements of A are represented in binary, and the only operation 
 * we can use to access them is "fetch the jth bit of A[i]", which takes constant
 * time. Write code to find the missing integer. Can you do it in O(n) time?
 * 
 * Solution - pg 252
 * 
 */
package com.question.bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitFindMissingInt {

	public static int findMissingInt(BitInteger[] arr) {
		int res = 0;
		List<BitInteger> currentBits = new ArrayList<BitInteger>();
		currentBits = Arrays.asList(arr);
		int j = 0;
		while (currentBits.size() > 0) {
			ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>();
			ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>();
			for (int i = 0; i < currentBits.size(); i++) {
				BitInteger num = currentBits.get(i);
				if (num.fetchjth(j) == 1) {
					oneBits.add(currentBits.get(i));
				} else {
					zeroBits.add(currentBits.get(i));
				}
			}
			if (zeroBits.size() <= oneBits.size()) {
				currentBits = zeroBits;
			} else {
				res += (1 << j);
				currentBits = oneBits;
			}
			j++;
		}
		return res;
	}

	private static class BitInteger {
		private Integer value;

		public BitInteger(Integer value) {
			this.value = value;
		}

		public int fetchjth(Integer j) {
			return (value >> j) & 1;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

	public static void main(String[] args) {
		BitInteger i0 = new BitInteger(0);
		BitInteger i1 = new BitInteger(1);
		BitInteger i2 = new BitInteger(2);
		BitInteger i3 = new BitInteger(3);
		BitInteger i4 = new BitInteger(4);
		BitInteger i5 = new BitInteger(5);
		BitInteger i6 = new BitInteger(6);
		BitInteger i7 = new BitInteger(7);
		BitInteger i9 = new BitInteger(9);
		BitInteger i10 = new BitInteger(10);

		BitInteger[] arr = { i0, i1, i2, i3, i4, i5, i6, i7, i9, i10 };
		System.out.print(findMissingInt(arr));

	}

}
