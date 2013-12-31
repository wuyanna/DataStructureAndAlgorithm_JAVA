package com.algo.sort;

public class SimpleSort {
	
	private int[] array;
	
	public int[] getArray() {
		return this.array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}
	
	// compare two and swap the bigger to latter
	// compares: (n-1) + (n-2) + ... + 2 + 1 = n(n-1)/2  ----> O(n^2)
	// swaps: worst case: n(n-1)/2 ----> O(n^2)
	public void bubbleSort() {
		for (int out = array.length - 1; out > 0; out--) {
			for (int in = 0; in < out; in++) {	
				// in cannot equal to out, in+1 causing out of bound
				if (array[in] > array[in+1]) {
					swap(in,in+1);
				}
			}
		}
	}
	
	// swap the smallest with the first
	// compares: (n-1) + (n-2) + ... + 2 + 1 = n(n-1)/2  ----> O(n^2)
	// swaps: worst case: n-1 ---> O(n)
	public void selectionSort() {
		int min;
		for (int out = 0; out < array.length - 1; out++) {
			min = out;
			for (int in = out + 1; in < array.length; in++) {
				if (array[in] < array[min]) {
					min = in;	// do not just swap here. swap costs 3 moves
				}
			}
			swap(min,out);
		}
	}
	
	// compare and shift
	// shift costs only one move
	// compares: average case:(n-1)n/4; worst case:(n-1)n/2; best case: (n-1)
	public void insertionSort() {	
		for (int out = 1; out < array.length; out++) {
			int in = out;
			int temp = array[in];
			// different from bubble sort and selection sort, this can stop in the middle
			while (in > 0 && array[in - 1] > temp ) {
				array[in] = array[in - 1];
				in--;
			}
			array[in] = temp;
		}
	}
	
	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	@Override
	public String toString() {
		String a = "";
		for (Integer i : array) {
			a += i.toString()+",";
		}
		return a;
	}

	public static void main(String[] args) {
		SimpleSort sort = new SimpleSort();
		int a[] = {100,-1,8,3,25,6,2,7,56,2,6,3,6,0};
		sort.setArray(a);
//		sort.bubbleSort();
//		sort.selectionSort();
		sort.insertionSort();
		System.out.println(sort);
	}

}
