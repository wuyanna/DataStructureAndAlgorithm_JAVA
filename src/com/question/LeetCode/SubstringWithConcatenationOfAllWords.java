package com.question.LeetCode;

import java.util.ArrayList;
import java.util.Hashtable;

public class SubstringWithConcatenationOfAllWords {

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		Hashtable<String, Integer> wordmap = new Hashtable<String,Integer>();
		for (String l : L) {
			if (wordmap.containsKey(l)) {
				int value = wordmap.get(l);
				wordmap.put(l, value+1);
			} else {
				wordmap.put(l, 1);
			}
		}
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < S.length(); i++) {
			Hashtable<String, Integer> wordlist = new Hashtable<String,Integer>(wordmap);
			findSubstring(S, i, i, L, wordlist, indices);
		}
		return indices;
	}

	public void findSubstring(String S, int index, int curIdx, String[] L,
			Hashtable<String, Integer> words, ArrayList<Integer> indices) {
		if (words.size() == 0) {
			indices.add(index);
			return;
		}
		if (L.length <= 0)
			return;
		int word_length = L[0].length();
		if (curIdx > S.length() - word_length)
			return;

		String match = S.substring(curIdx, curIdx + word_length);
		if (words.containsKey(match)) {
			Integer num = words.get(match);
			if (num == 1) {
				words.remove(match);
			} else {
				words.put(match, num-1);
			}
			findSubstring(S, index, curIdx + word_length, L, words, indices);
		}
	}

	public static void main(String[] args) {
		String s = "ababababa";
		String[] l = { "a", "b", "a" };
		SubstringWithConcatenationOfAllWords sol = new SubstringWithConcatenationOfAllWords();
		System.out.print(sol.findSubstring(s, l));

	}

}
