package com.algo.sort;
//Divide and Conquer
//1. Sort the first half
//2. Sort the second half
//3. Merge sorted halves into one array (list)

//1.comparison
//2.copies --> nlogn

//T(n) = O(1) if n<=1
//   | 2T(n/2)+O(n) if n>1
//T(n) = 2[T(n/2)]+n
//   = 2[2T(n/4)+n/2]+n
//   = 4T(n/4)+2n
//   = 4[2T(n/8)+n/4]+2n
//   = 8T(n/8)+3n
//   = 16T(n/16)+4n
//2^k*T(n/2^k)+kn
public class MergeSort {
	
	public int[] mergeSort(int[] unsorted) {
		if (unsorted.length <= 1) {
			return unsorted;
		}
		int lengthLeft = unsorted.length/2;
		int lengthRight = unsorted.length - lengthLeft;
		int[] left = new int[lengthLeft];
		int[] right = new int[lengthRight];
		System.arraycopy(unsorted, 0, left, 0, lengthLeft);
		System.arraycopy(unsorted, lengthLeft, right, 0, lengthRight);
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left,right);
	}

	private int[] merge(int[] left, int[] right) {
		int leftFront = 0;
		int rightFront = 0;
		int mergeFront = 0;
		int[] merged = new int[left.length+right.length];
		while (leftFront < left.length && rightFront < right.length) {
			if (left[leftFront] < right[rightFront]) {
				merged[mergeFront] = left[leftFront];
				leftFront++;
				mergeFront++;
			}
			else {
				merged[mergeFront] = right[rightFront];
				rightFront++;
				mergeFront++;
			}
		}
		while (leftFront < left.length) {
			merged[mergeFront] = left[leftFront];
			leftFront++;
			mergeFront++;
		}
		while (rightFront < right.length) {
			merged[mergeFront] = right[rightFront];
			rightFront++;
			mergeFront++;
		}
		return merged;
	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		int unsorted[] = {2,45,1,6,2,6,7,34};
		int sorted[] = sort.mergeSort(unsorted);
		for (Integer i : sorted) {
			System.out.print(i+",");
		}
	}

}
