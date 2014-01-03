/* 
 * Cracking the coding interview (5th edition)
 * Chapter 18 - Hard
 * 
 * Question 18.9
 * Numbers are randomly generated and passed to a method. Write a program to
 * find and maintain the median value as new values are generated.
 * 
 * Solution - pg 474
 * 
 */
package com.question.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedian {

	private ArrayList<Integer> numbers;

	public void generateNumber(Integer number) {
		if (numbers == null)
			numbers = new ArrayList<Integer>();
		numbers.add(number);
	}

	public double median() {
		Collections.sort(numbers);
		int i = numbers.size() / 2;
		if (numbers.size() % 2 == 0) {
			return (numbers.get(i) + numbers.get(i - 1)) / 2.0;
		}
		return numbers.get(i);
	}

	private Comparator<Integer> maxHeapComparator;
	private PriorityQueue<Integer> maxHeap, minHeap;

	public FindMedian() {
		maxHeapComparator = new MaxHeapComparator();
		maxHeap = new PriorityQueue<Integer>(11, maxHeapComparator);
		minHeap = new PriorityQueue<Integer>();
	}

	private static class MaxHeapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer t1, Integer t2) {
			return t2.compareTo(t1);
		}

	}

	public void addNewNumber(int randomNumber) {
		/*
		 * Note: addNewNumber maintains a condition that maxHeap.size() >=
		 * minHeap.size()
		 */
		if (maxHeap.size() == minHeap.size()) {
			if (minHeap.peek() != null && randomNumber > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		} else {
			if (randomNumber < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			} else {
				minHeap.offer(randomNumber);
			}
		}
	}

	public double getMedian() {
		/*
		 * maxHeap is always at least as big as minHeap. So if maxHeap is empty,
		 * then minHeap is also.
		 */
		if (maxHeap.isEmpty()) {
			return 0;
		}
		if (maxHeap.size() == minHeap.size()) {
			return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
		}
		/*
		 * If maxHeap and minHeap are of different sizes, then maxHeap must have
		 * one extra element. Return maxHeap's top element.
		 */
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		FindMedian med = new FindMedian();
		med.addNewNumber(10);
		med.addNewNumber(11);
		med.addNewNumber(5);
		med.addNewNumber(45);
		med.addNewNumber(23);
		System.out.println(med.getMedian());

		med.generateNumber(10);
		med.generateNumber(11);
		med.generateNumber(5);
		med.generateNumber(45);
		med.generateNumber(23);
		System.out.println(med.median());

	}

}
