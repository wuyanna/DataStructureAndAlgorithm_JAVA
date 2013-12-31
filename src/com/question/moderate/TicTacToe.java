/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.2
 * Design an algorithm to figure out if someone has won a game of tic-tac-toe.
 * 
 * Solution - pg 431
 * 
 */
package com.question.moderate;

public class TicTacToe {

	public static boolean won(int[][] game) {
		for (int i = 0; i < 3; i++) {
			boolean isSame = true;
			int lastDraw = game[i][0];
			for (int j = 0; j < 3; j++) {
				isSame = game[i][j] == lastDraw;
				if (!isSame)
					break;
			}
			if (isSame) {
				return true;
			}
		}

		for (int j = 0; j < 3; j++) {
			boolean isSame = true;
			int lastDraw = game[0][j];
			for (int i = 0; i < 3; i++) {
				isSame = game[i][j] == lastDraw;
				if (!isSame)
					break;
			}
			if (isSame) {
				return true;
			}
		}

		boolean isSame = true;
		int lastDraw = game[1][1];
		for (int d = 0; d < 3; d++) {
			isSame = game[d][d] == lastDraw;
			if (!isSame)
				break;
		}
		if (isSame) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] game = { { 1, 2, 1 }, { 2, 2, 1 }, { 2, 1, 2 } };
		System.out.print(won(game));

	}

}
