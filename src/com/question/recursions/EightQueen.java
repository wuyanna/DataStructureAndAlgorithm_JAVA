/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.9
 * Write an algorithm to print all ways of arranging eight queens on an 8*8 chess
 * board so that none of them share the same row, column or diagonal. In this case,
 * "diagonal" means all diagonals, not just the two that bisect the board.
 * 
 * Solution - pg 331
 * 
 */
package com.question.recursions;

import java.util.ArrayList;

public class EightQueen {

	int GRID_SIZE = 8;

	public void placeQueens(int row, Integer[] columns,
			ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {
			if (!results.contains(columns))
				results.add(columns);
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}

	public boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			if (column1 == column2) {
				return false;
			}

			int columnDistance = Math.abs(column2 - column1);

			int rowDistance = row1 - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

	public void printQueens() {
		ArrayList<Integer[]> res = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[GRID_SIZE];
		placeQueens(0, columns, res);
		for (Integer[] r : res) {
			for (Integer c : r) {
				System.out.print(c + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {

		EightQueen eq = new EightQueen();
		eq.printQueens();

	}

}
