/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.14
 * Oh, no! You have just completed a lengthy document when you have an unfortunate
 * Find/Replace mishap. You have accidentally removed all spaces, punctuation,
 * and capitalization in the document. A sentence like "I reset the computer. It
 * still didn't boot!" would become "iresetthecomputeritstilldidntboot". You figure
 * that you can add back in the punctuation and capitalization later, once you get
 * the individual words properly separated. Most of the words will be in a dictionary, 
 * but some strings, like proper names, will not.
 * 
 * Given a dictionary (a list of words), design an algorithm to find the optimal way
 * of "unconcatenating" a sequence of words. In this case, "optimal" is defined to be
 * the parsing which minimizes the number of unrecognized sequence of characters.
 * 
 * For example, the string "jesslookedjustliketimherbrother" would be optimally parsed
 * as "JESS looked just like TIM her brother". This parsing has seven unrecognized 
 * characters, which we have capitalized for clarity.
 * 
 * Solution - pg 455
 * 
 */
package com.question.moderate;

import java.util.Hashtable;

public class ParseDoc {
	Hashtable<String,Boolean> dictionary;
	Hashtable<String,Integer> cache;
	
	public ParseDoc(Hashtable<String,Boolean> dict) {
		this.dictionary = dict;
		cache = new Hashtable<String,Integer>();
	}
	
	public int parseString(String str) {
		if (str.length() == 0) return 0;
		if (str.length() == 1) {
			if (dictionary.containsKey(str)) {
				return 0;
			}
			return 1;
		}
		if (cache.containsKey(str)) {
			return cache.get(str);
		}
		int minUnrecog = Integer.MAX_VALUE;
		int words = 0;
		for (int i = 1; i <= str.length(); i++) {
			words = 0;
			if (!dictionary.containsKey(str.substring(0, i))) {
				words = i;
			}
			
			int unrecog = parseString(str.substring(i));
			if (unrecog + words < minUnrecog) {
				minUnrecog = unrecog + words;
			}
		}
		cache.put(str, minUnrecog);
		return minUnrecog;
	}

	public static void main(String[] args) {
		Hashtable<String,Boolean> dict = new Hashtable<String,Boolean>();
		dict.put("looked", true);
		dict.put("just", true);
		dict.put("like", true);
		dict.put("her", true);
		dict.put("brother", true);
		ParseDoc parse = new ParseDoc(dict);
		System.out.println(parse.parseString("jesslookedjustliketimherbrother"));
	}

}
