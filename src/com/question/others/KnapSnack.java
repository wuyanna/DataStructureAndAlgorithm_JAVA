/*
 * KnapSnack
 * Given a set of items, each with a mass and a value, 
 * determine the number of each item to include in a 
 * collection so that the total weight is less than or 
 * equal to a given limit and the total value is as 
 * large as possible.
 * 
 */
package com.question.others;

public class KnapSnack {
	/*
	 * 1kg : $2
	 * 2kg : $3
	 * 3kg : $7
	 *
	 */
	public static int placeSnack(int limit) {
		if (limit <= 0) return 0;
		int a = placeSnack(limit-1) + 2;
		int b = placeSnack(limit-2) + 3;
		int c = placeSnack(limit-3) + 7;
		return Math.max(Math.max(a, b),c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
