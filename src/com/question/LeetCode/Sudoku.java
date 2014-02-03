package com.question.LeetCode;

public class Sudoku {

	private final int SUDOKU_NUM = 9;

	public boolean solveSudoku(char[][] board) {
		for (int i = 0; i < SUDOKU_NUM; i++) {
			for (int j = 0; j < SUDOKU_NUM; j++) {
				if (board[i][j] == '.') {
					for (char a = 0x31; a <= 0x39; a++) {
						board[i][j] = a;
						for (int ii = 0; ii < 9; ii++) {
							for (int jj = 0; jj < 9; jj++) {
								System.out.print(board[ii][jj] + " ");
							}
							System.out.println();
						}
						if (checkValid(board)) {
							if (solveSudoku(board)) {
								return true;
							}
						}
					}
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkValid(char[][] board) {
		return checkRowValid(board) && checkColValid(board)
				&& checkSplitValid(board);
	}

	public boolean checkRowValid(char[][] board) {
		int check = 0;
		for (int i = 0; i < SUDOKU_NUM; i++) {
			check = 0;
			for (int j = 0; j < SUDOKU_NUM; j++) {
				char num = board[i][j];
				if (num >= 0x31 && num <= 0x39) {
					num -= 0x30;
					if (((check >> num) & 1) == 1) {
						return false;
					}
					check |= (1 << num);
				}
			}
		}
		return true;
	}

	public boolean checkColValid(char[][] board) {
		int check = 0;
		for (int j = 0; j < SUDOKU_NUM; j++) {
			check = 0;
			for (int i = 0; i < SUDOKU_NUM; i++) {
				char num = board[i][j];
				if (num >= 0x31 && num <= 0x39) {
					num -= 0x30;
					if (((check >> num) & 1) == 1) {
						return false;
					}
					check |= (1 << num);
				}
			}
		}
		return true;
	}

	public boolean checkSplitValid(char[][] board) {
		int check = 0;
		for (int a = 0; a < 3; a++) {
			check = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					char num = board[i + 3 * a][j];
					if (num >= 0x31 && num <= 0x39) {
						num -= 0x30;
						if (((check >> num) & 1) == 1) {
							return false;
						}
						check |= (1 << num);
					}
				}
			}
		}

		for (int a = 0; a < 3; a++) {
			check = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 3; j < 6; j++) {
					char num = board[i + 3 * a][j];
					if (num >= 0x31 && num <= 0x39) {
						num -= 0x30;
						if (((check >> num) & 1) == 1) {
							return false;
						}
						check |= (1 << num);
					}
				}
			}
		}

		for (int a = 0; a < 3; a++) {
			check = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 6; j < 9; j++) {
					char num = board[i + 3 * a][j];
					if (num >= 0x31 && num <= 0x39) {
						num -= 0x30;
						if (((check >> num) & 1) == 1) {
							return false;
						}
						check |= (1 << num);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] s = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		Sudoku sudoku = new Sudoku();
		sudoku.solveSudoku(s);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
	}

}
