/*
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence 
 * from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
package com.question.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

	public int ladderLength(String start, String end, HashSet<String> dict) {
		int length = dict.size();
		String[] strs = new String[length];
		strs = dict.toArray(strs);
		String[] totalStrs = new String[length+2];
		System.arraycopy(strs, 0, totalStrs, 0, length);
		totalStrs[length] = start;
		totalStrs[length+1] = end;
		int[][] matrix = new int[length+2][length+2];
		for (int i = 0; i < length + 2; i++) {
			for (int j = i + 1; j < length + 2; j++) {
				if (isSimilar(totalStrs[i],totalStrs[j])) {
					matrix[i][j] = 1;
					matrix[j][i] = 1;
				}
			}
		}
		HashSet<String> visited = new HashSet<String>();
		visited.add(start);
		Queue<String> q = new LinkedList<String>();
		q.add(start);
		int curLevelCount = 1;
		int distance = 0;
		while (q.size() > 0) {
			String cur = q.poll();
			curLevelCount--;
			if (cur.equals(end)) return ++distance;
			for (String s : getNeighbors(matrix, cur, totalStrs)) {
				if (!visited.contains(s)) {
					q.add(s);
				}
				
			}
			if (curLevelCount == 0) {
				curLevelCount = q.size();
				distance++;
			}
		}
		return distance;
	}
	
	public String[] getNeighbors(int[][] matrix, String src, String[] strs) {
		int length = matrix.length;
		String[] ne = new String[length];
		int c = 0;
		int i = 0;
		for (i = 0; i < strs.length; i++) {
			if ( src.equals(strs[i])) {
				break;
			}
		}
		for (int j = 0; j < length; j++) {
			if (matrix[i][j] == 1) {
				ne[c++] = strs[j];
			}
		}
		String[] res = new String[c];
		System.arraycopy(ne, 0, res, 0, c);
		return res;
	}
	
	public boolean isSimilar(String a, String b) {
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		if (ac.length != bc.length) return false;
		boolean diff = false;
		for (int i = 0; i < ac.length; i++) {
			if (ac[i] != bc[i]) {
				if (!diff) 
					diff = true;
				else 
					return false;
			}
		}
		return diff;
	}
	
	
	public static void main(String[] args) {
		WordLadder lad = new WordLadder();
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.print(lad.ladderLength("hit", "cog", set));

	}

}
