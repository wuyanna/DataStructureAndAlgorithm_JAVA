/* 
 * Cracking the coding interview (5th edition)
 * Chapter 18 - Hard
 * 
 * Question 18.5
 * You have a large text file containing words. Given any two words, find the
 * shortest distance (in terms of number of words) between them in the file.
 * If the operation will be repeated many times for the same file (but different
 * pairs of words), can you optimize your solution?
 * 
 * Solution - pg 468
 * 
 */
package com.question.hard;

import java.util.ArrayList;
import java.util.Hashtable;

public class WordDistance {
	private Hashtable<String, ArrayList<Integer>> table;

	public WordDistance(String[] text) {
		table = new Hashtable<String, ArrayList<Integer>>();
		for (Integer i = 0; i < text.length; i++) {
			String word = text[i];
			ArrayList<Integer> list = table.get(word);
			if (list == null) {
				list = new ArrayList<Integer>();
				table.put(word, list);
			}
			list.add(i);
		}
	}

	public int distance(String s1, String s2) {

		ArrayList<Integer> list1 = table.get(s1);
		ArrayList<Integer> list2 = table.get(s2);
		if (list1 == null || list2 == null)
			return -1;
		int min = Integer.MAX_VALUE;
		for (Integer i : list1) {
			for (Integer j : list2) {
				int dist = Math.abs(i - j);
				if (dist < min)
					min = dist;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String content = "The Career and Professional Development "
				+ "Center encourages employers to fill every slot "
				+ "on their interview schedule while here on campus. "
				+ "Occasionally, organizations who are interviewing "
				+ "on campus have a last-minute cancellation from a "
				+ "student interviewee, or all the students they invite "
				+ "do not sign up for an interview. This creates empty "
				+ "interview slots on their schedules. Because these "
				+ "empty slots are not apparent until approximately "
				+ "24-hours before a company's arrival, we refer to them as "
				+ "Last-minute Interviews";
		String[] book = content.split(" ");
		WordDistance d = new WordDistance(book);
		System.out.print(d.distance("interview", "a"));

	}

}
