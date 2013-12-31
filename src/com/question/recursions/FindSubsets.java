/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.4
 * Write a method to return all subsets of a set.
 * 
 * Solution - pg 321
 * 
 */
package com.question.recursions;

import java.util.ArrayList;
import java.util.List;

public class FindSubsets {

	public static ArrayList<ArrayList<Integer>> getSubsets(List<Integer> set,
			int index) {
		if (index >= set.size()) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			res.add(new ArrayList<Integer>());
			return res;
		}
		ArrayList<ArrayList<Integer>> res = getSubsets(set, index + 1);
		ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();
		Integer elem = set.get(index);
		for (ArrayList<Integer> sub : res) {
			ArrayList<Integer> newSub = new ArrayList<Integer>();
			newSub.addAll(sub);
			newSub.add(elem);
			newRes.add(newSub);
		}
		res.addAll(newRes);
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>(6);
		set.add(2);
		set.add(4);
		set.add(3);
		set.add(45);
		set.add(9);
		set.add(43);
		set.add(5);
		set.add(6);
		set.add(22);
		set.add(11);
		System.out.print(getSubsets(set, 0));

	}

}
