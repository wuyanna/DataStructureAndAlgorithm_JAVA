//1. partition an array into left(smaller) group and right(bigger) group
//2. call itself again to sort left
//3. call itself again to sort right
// quick sort is not stable
// merge sort is stable
// Collection.sort & Array.sort
// on primitive - use quick sort
// on object - use merge sort
// insertion sort
 
// pivot value
// not evenly divided
 
// return pivot value
// O(n)
// if pick pivot smallest - O(n^2) - worst case (depend on pivot value)
// pick pivot - medium (but need to sort first)
// pick random - pick three and pick the middle one
// average nlogn
package com.algo.sort;

public class QuickSort {

	private int partition(int[] array, int left, int right, int pivot) {
		int leftPointer = left - 1;
		int rightPointer = right;
		while (true) {
			while (array[++leftPointer] < pivot)
				;
			while (rightPointer > 0 && array[--rightPointer] > pivot)
				// efficient because do not need to access array memory
				;
			if (leftPointer >= rightPointer) {
				break;
			}
			swap(array, leftPointer, rightPointer);
		}
		swap(array,leftPointer,right);
		return leftPointer;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	private void recQuickSort(int[] unsorted, int left, int right) {
		if (left >= right)
			return;
		int pivot = unsorted[right];
		int partition = partition(unsorted, left, right, pivot);
		recQuickSort(unsorted, left, partition - 1);
		recQuickSort(unsorted, partition + 1, right);
	}

	public void quickSort(int[] unsorted) {
		recQuickSort(unsorted, 0, unsorted.length - 1);
	}

	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int unsorted[] = { 2, 45, 1, 6, 2, 6, 7, 34 };
		sort.quickSort(unsorted);
		for (Integer i : unsorted) {
			System.out.print(i + ",");
		}
	}

}
