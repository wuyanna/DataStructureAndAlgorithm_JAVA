/* 
 * Cracking the coding interview (5th edition)
 * Chapter 11 - Sorting and Searching
 * 
 * Question 11.5
 * Given a sorted array of strings which is interspersed with empty strings, write a
 * method to find the location of a given string.
 * EXAMPLE
 * Input: find "ball" in {"at", "", "", "", "ball", "", "", "car",
 * 							"", "", "dad", "", ""}
 * Output: 4
 * 
 * Solution - pg 364
 * 
 */
package com.question.sort;

public class SortedStringsInterspersed {

	public static int searchR(String[] list, int left, int right, String elem) {
		if (right < left)
			return -1;
		int mid = (right + left) / 2;
		if (list[mid].isEmpty()) {
			int midL = mid - 1;
			int midR = mid + 1;

			while (true) {
				if (midL < left && midR > right) {
					return -1;
				} else if (midL >= left && !list[midL].isEmpty()) {
					mid = midL;
					break;
				} else if (midR <= right && !list[midR].isEmpty()) {
					mid = midR;
					break;
				}
				midL--;
				midR++;
			}
		}

		if (elem.compareTo(list[mid]) == 0) {
			return mid;
		} else if (elem.compareTo(list[mid]) > 0) {
			return searchR(list, mid + 1, right, elem);
		} else {
			return searchR(list, left, mid - 1, elem);
		}
	}

	public static void main(String[] args) {
		String[] list = { "at", "", "", "", "ball", "", "", "", "", "car", "",
				"", "dad", "", "" };
		System.out.print(searchR(list, 0, list.length, "ball"));
	}

}
