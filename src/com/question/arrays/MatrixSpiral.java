package com.question.arrays;


public class MatrixSpiral {
	
	public void spiralPrint(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) return;
		int columns = matrix[0].length;
		
		int level = (Math.min(rows, columns)+1)/2;
		for (int lv = 0; lv < level; lv++) {
			for (int i = lv; i < columns-1-lv; i++) {
				System.out.print(matrix[lv][i]+", ");
			}
			for (int j = lv; j < rows-1-lv; j++) {
				System.out.print(matrix[j][columns-1-lv]+", ");
			}
			for (int k = columns-1-lv; k > lv; k--) {
				System.out.print(matrix[rows-1-lv][k]+", ");
			}
			for (int l = rows-1-lv; l > lv; l--) {
				System.out.print(matrix[l][lv]+", ");
			}
		}
	}

	public static void main(String[] args) {
		MatrixSpiral spr = new MatrixSpiral();
		int[][] m = {{12,4,0},{2,4,5},{1,3,4},{4,5,6}};
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + ", ");
			}
			System.out.print("\n");
		}
		spr.spiralPrint(m);
	}

}
