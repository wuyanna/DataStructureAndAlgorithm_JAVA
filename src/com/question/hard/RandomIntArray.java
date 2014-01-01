/* 
 * Cracking the coding interview (5th edition)
 * Chapter 18 - Hard
 * 
 * Question 18.3
 * Write a method to randomly generate a set of m integers from an array of size n.
 * Each element must have equal probability of being chosen.
 * 
 * Solution - pg 464
 * 
 */
package com.question.hard;

public class RandomIntArray {

	public static int[] generate(int[] arr, int m) {
		int[] arrM = new int[m];
		for (int i = 0; i < m; i++) {
			int j = (int) Math.floor(Math.random() * (arr.length - i));
			int num = arr[j];
			arrM[i] = num;
			swap(arr, j, arr.length - 1 - i);
		}
		return arrM;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 451, 62, 66, 1, 6, 11, 56, 9 };
		int m = 1;
		int[] arrM = generate(arr, m);
		for (int i = 0; i < m; i++) {
			System.out.print(arrM[i] + " ");
		}
	}

}
