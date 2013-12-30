/* 
 * Cracking the coding interview (5th edition)
 * Chapter 11 - Sorting and Searching
 * 
 * Question 11.6
 * Given an M x N matrix in which each row and each column is sorted in ascending
 * order, write a method to find an element.
 * 
 * Solution - pg 365
 * 
 */
package com.question.sort;

public class SortedMatrix {

	public static int binarySearch(int[] array, int left, int right, int elem) {
		if (right < left)
			return -1;
		if (elem < array[left] || elem > array[right])
			return -1;
		int mid = (left + right) / 2;
		if (elem == array[mid]) {
			return mid;
		} else if (elem < array[mid]) {
			return binarySearch(array, left, mid - 1, elem);
		} else {
			return binarySearch(array, mid + 1, right, elem);
		}
	}

	public static void searchRow(int[][] matrix, int row, int elem) {

		if (row >= matrix.length) {
			System.out.println("Not found");
			return;
		}

		int index = binarySearch(matrix[row], 0, matrix[0].length - 1, elem);
		if (index >= 0) {
			System.out.println(row + ", " + index);
			return;
		}
		searchRow(matrix, row + 1, elem);
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5 }, { 2, 4, 7 }, { 3, 6, 8 } };
		searchRow(m, 0, 4);
	}

}
