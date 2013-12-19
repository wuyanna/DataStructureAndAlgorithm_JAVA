/* find k largest numbers in an array
 * http://en.wikipedia.org/wiki/Selection_algorithm
 */
package com.question.arrays;

public class ArrayTopN {
	
	public int[] topN(int[] arr, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					swap(arr, i, j);
				}
			}
		}
		return arr;
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		ArrayTopN arrTop = new ArrayTopN();
		int[] arr = {15,2,51,1,6,5,5,667,6,111,46,3,66,32};
		arrTop.topN(arr, 10);
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
