/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.5
 * Write a method to compute all permutations of a string.
 * 
 * Solution - pg 324
 * 
 */
package com.question.recursions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {
	
	public static ArrayList<ArrayList<Character>> permutation(List<Character> str) {
		if (str.size() <= 0) {
			ArrayList<ArrayList<Character>> nres = new ArrayList<ArrayList<Character>>();
			nres.add(new ArrayList<Character>());
			return nres;
		}
		Character c = str.get(0);
		ArrayList<ArrayList<Character>> res = permutation(str.subList(1, str.size()));
		ArrayList<ArrayList<Character>> nres = new ArrayList<ArrayList<Character>>();
		for (ArrayList<Character> r : res) {
			for (int i = 0; i <= r.size(); i++) {	// careful, not i < r.size()
				ArrayList<Character> nr = new ArrayList<Character>(r);
				nr.add(i, c);
				nres.add(nr);
			}
		}
		return nres;
	}

	public static void main(String[] args) {
		Character[] cs = {'a','f','d'};
		List<Character> str = Arrays.asList(cs);
		System.out.print(permutation(str));
	}

}
