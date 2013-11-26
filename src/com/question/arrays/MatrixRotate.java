/* 
 * Cracking the coding interview (5th edition)
 * Chapter 1 - Arrays and Strings
 * 
 * Question 1.6
 * Given an image represented by an N*N matrix, 
 * where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 * 
 * Solution - pg 179
 * 
 */
package com.question.arrays;

public class MatrixRotate {
	
	public void rotateImage(int[][] image) {
		int rows = image.length;
		if (rows <= 1) {
			return;
		}
		int columns = image[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = i+1; j < columns; j++) {
				rotatePixel(image, i, j);
			}
		}
	}
	
	public void rotatePixel(int[][] matrix, int row, int column) {
		int temp = matrix[row][column];
		matrix[row][column] = matrix[column][row];
		matrix[column][row] = temp;
	}

	public static void main(String[] args) {
		MatrixRotate rot = new MatrixRotate();
		int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rot.rotateImage(m);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + ", ");
			}
			System.out.print("\n");
		}

	}

}
