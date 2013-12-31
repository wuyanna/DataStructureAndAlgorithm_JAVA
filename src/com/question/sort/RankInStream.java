/* 
 * Cracking the coding interview (5th edition)
 * Chapter 11 - Sorting and Searching
 * 
 * Question 11.8
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able
 * to look up the rank of a number x (the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations. That
 * is, implement the method track(int x), which is called when each number is generated,
 * and the method getRankOfNumber(int x), which returns the number of values less
 * than or equal to x (not including x itself).
 * EXAMPLE
 * Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(1) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 * 
 * Solution - pg 374
 * 
 */
package com.question.sort;

import java.util.ArrayList;

public class RankInStream {

	private ArrayList<Integer> stream;

	public RankInStream() {
		stream = new ArrayList<Integer>();
	}

	public void track(int x) {
		stream.add(x);
	}

	public int getRankOfNumber(int x) {
		int count = 0;
		for (int i : stream) {
			if (i <= x) {
				count++;
			}
		}
		return count > 0 ? count - 1 : 0;
	}

	public static void main(String[] args) {
		RankInStream r = new RankInStream();
		r.track(5);
		r.track(1);
		r.track(4);
		r.track(4);
		r.track(5);
		r.track(9);
		r.track(7);
		r.track(13);
		r.track(3);
		System.out.println(r.getRankOfNumber(1));
		System.out.println(r.getRankOfNumber(3));
		System.out.println(r.getRankOfNumber(4));
	}

}
