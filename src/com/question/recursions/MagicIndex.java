/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.3
 * A magic index in an array A[1...n-1] is defined to be an index such that A[i] =
 * i. Given a sorted array of distinct integers, write a method to find a magic index,
 * if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 * 
 * Solution - pg 319
 * 
 */
package com.question.recursions;

public class MagicIndex {

	public static int getMagic(int arr[], int i) {
		if (i >= arr.length)
			return -1;
		if (arr[i] == i)
			return i;
		return getMagic(arr, i + 1);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 2, 5 };
		System.out.print(getMagic(arr, 0));

	}

}
