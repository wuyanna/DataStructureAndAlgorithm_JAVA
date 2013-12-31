/* 
 * Cracking the coding interview (5th edition)
 * Chapter 11 - Sorting and Searching
 * 
 * Question 11.1
 * You are given two sorted array, A and B, where A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 * 
 * Solution - pg 360
 * 
 */
package com.question.sort;

public class MergeSortedArray {

	public static void merge(int[] A, int[] B, int lengthA) {
		int pointA = lengthA - 1;
		int pointB = B.length - 1;
		for (int i = A.length - 1; i >= 0; i--) {
			if (pointB >= 0 && (B[pointB] > A[pointA] || pointA < 0)) {
				A[i] = B[pointB];
				pointB--;
			} else if (pointA >= 0) {
				A[i] = A[pointA];
				pointA--;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 7, 10, 0, 0, 0, 0 };
		int[] b = { 3, 4, 8, 9 };
		merge(a, b, 5);
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

}
