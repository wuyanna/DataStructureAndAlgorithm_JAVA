/* 
 * Cracking the coding interview (5th edition)
 * Chapter 18 - Hard
 * 
 * Question 18.2
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle - in other
 * words, each of the 52! permutations of the deck has to be equally likely. Assume
 * that you are given a random number generator which is perfect.
 * 
 * Solution - pg 463
 * 
 */
package com.question.hard;

import java.util.ArrayList;

public class ShuffleCards {

	public static void shuffle(ArrayList<Integer> cards, int index) {
		if (index == 52)
			return;
		int i = (int) Math.floor(Math.random() * (52.0 - index));
		Integer card = cards.remove(i + index);
		cards.add(index, card);
		shuffle(cards, index + 1);
	}

	public static void main(String[] args) {
		ArrayList<Integer> cards = new ArrayList<Integer>();
		for (Integer i = 0; i < 52; i++) {
			cards.add(i);
		}
		shuffle(cards, 0);
		System.out.print(cards);
	}

}
