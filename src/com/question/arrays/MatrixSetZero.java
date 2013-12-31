/* 
 * Cracking the coding interview (5th edition)
 * Chapter 1 - Arrays and Strings
 * 
 * Question 1.7
 * Write an algorithm such that if an element in an M*N matrix is 0,
 * its entire row and column are set to 0.
 * 
 * Solution - pg 180
 * 
 */

package com.question.arrays;

public class MatrixSetZero {
	
	/* recursive version that sets in place */
	public void recSetZero(int[][] image, int points) {
		int rows = image.length;
		if (rows == 0) return;
		int columns = image[0].length;
		
		int r = points / columns;
		int c = points % columns;
		boolean isZero = image[r][c] == 0;
		if (points < rows * columns - 1) {
			recSetZero(image, ++points);
			
		}
		if (isZero) {
			for (int a = 0; a < rows; a++) {
				image[a][c] = 0;
			}
			for (int b = 0; b < columns; b++) {
				image[r][b] = 0;
			}
		}
	}
	
	/* loop version that needs an additional array */
	public void setZero(int[][] image) {
		int rows = image.length;
		if (rows == 0) return;
		int columns = image[0].length;
		int[][] zeroPoints = new int[rows*columns][2];
		int zeroCount = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (image[i][j] == 0) {
					zeroPoints[zeroCount][0] = i;
					zeroPoints[zeroCount][1] = j;
					zeroCount++;
				}
				
			}
		}
		
		for (int z = 0; z < zeroCount; z++) {
			int r = zeroPoints[z][0];
			int c = zeroPoints[z][1];
			for (int a = 0; a < rows; a++) {
				image[a][c] = 0;
			}
			for (int b = 0; b < columns; b++) {
				image[r][b] = 0;
			}
		}
	}

	public static void main(String[] args) {
		MatrixSetZero mz = new MatrixSetZero();
		int[][] m = {{12,4,0,6},{2,4,5,7},{1,3,4,6}};
//		mz.setZero(m);
		mz.recSetZero(m, 0);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + ", ");
			}
			System.out.print("\n");
		}

	}

}
