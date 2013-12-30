/* 
 * Cracking the coding interview (5th edition)
 * Chapter 11 - Sorting and Searching
 * 
 * Question 11.3
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in the array. You may assume that the array
 * was originally sorted in increasing order.
 * EXAMPLE
 * Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 (the index of 5 in the array)
 * 
 * Solution - pg 362
 * 
 */
package com.question.sort;

public class SortRotated {
	
	// TODO see solution, why search left in the last branch
	public static int search(int[] a, int left, int right, int x) {
		int mid = (left + right) / 2;
		if (x == a[mid]) {
			return mid;
		}
		if (right < left) {
			return -1;
		}
		
		if (a[left] < a[mid]) {
			if (x >= a[left] && x <= a[mid]) {
				return search(a, left, mid - 1, x);
			} else {
				return search(a, mid + 1, right, x);
			}
		} else if (a[mid] < a[left]) {
			if (x >= a[mid] && x <= a[right]) {
				return search(a, mid + 1, right, x);
			} else {
				return search(a, left, mid - 1, x);
			}
		} else if (a[mid] == a[left]) {
//			if (a[mid] != a[right]) {
//				return search(a, mid + 1, right, x);
//			} else {
//				int result = search(a, left, mid-1,x);
//				if (result == -1) {
//					return search(a, mid+1,right,x);
//				} else {
//					return result;
//				}
//			}
			return search(a, mid + 1, right, x);
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[] = {2,2,2,3,4,5};
		System.out.print(search(a,0,a.length-1,2));
	}

}
