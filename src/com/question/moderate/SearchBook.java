/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.9
 * Design a method to find the frequency of occurrences of any given word in a 
 * book.
 * 
 * Solution - pg 445
 * 
 */
package com.question.moderate;

import java.util.Hashtable;

public class SearchBook {

	public static int searchBook(String[] book, String word) {
		Hashtable<String, Integer> dict = new Hashtable<String, Integer>();
		for (String w : book) {
			String ww = w.toLowerCase().replaceAll("[.|,|:|;]", "").trim();
			if (ww != null && ww != "") {
				Integer freq = dict.get(ww);
				if (freq == null)
					freq = 0;
				dict.put(ww, freq + 1);
			}
		}
		Integer freq = dict.get(word.toLowerCase());
		return freq == null ? 0 : freq;
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
		System.out.print(searchBook(book, "interview"));
	}
}
