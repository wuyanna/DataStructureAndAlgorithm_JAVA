package com.question.LeetCode;

import java.util.ArrayList;

public class Combinations {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		if (k == 0) {
			ArrayList<Integer> empty = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
			r.add(empty);
			return r;
		}
		ArrayList<ArrayList<Integer>> last = combine(n - 1, k - 1);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> list : last) {
			for (int i = (list.size() == 0 ? 0 : list.get(list.size() - 1)) + 1; i <= n; i++) {
				ArrayList<Integer> newlist = new ArrayList<Integer>(list);
				newlist.add(i);
				res.add(newlist);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Combinations com = new Combinations();
		System.out.print(com.combine(4, 2));

	}

}
