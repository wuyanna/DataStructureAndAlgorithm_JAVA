/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.5
 * The Game of Master Mind is played as follows:
 * The computer has four slots, and each slot will contain a ball that is red (R),
 * yellow (Y), green (G) or blue (B). For example, the computer might have RGGB
 * (Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
 * You, the user, are trying to guess the solution. You might, for example, guess
 * YRGB.
 * When you guess the correct color for the correct slot, you get a "hit". If you 
 * guess a color that exists but is in the wrong slot, you get a "pseudo-hit". Note
 * that a slot that is a hit can never count as a pseudo-hit.
 * For example, if the actual solution is RGBY and you guess GGRR, you have one hit 
 * and one pseudo-hit.
 * Write a method that, given a guess and a solution, returns the number of hits and
 * pseudo-hits.
 * 
 * Solution - pg 438
 * 
 */
package com.question.moderate;

import java.util.ArrayList;

enum Color {
	Red, Yellow, Green, Blue;
}

public class MasterMind {

	public static void checkResult(Color[] guess, Color[] solution) {
		ArrayList<Color> guessList = new ArrayList<Color>();
		for (int i = 0; i < guess.length; i++) {
			guessList.add(guess[i]);
		}
		int hit = 0;
		int pseudoHit = 0;
		for (int i = 0; i < solution.length; i++) {
			if (guess[i] == solution[i]) {
				hit++;
			} else {
				if (guessList.contains(solution[i])) {
					guessList.remove(solution[i]);
					pseudoHit++;
				}
			}
		}
		System.out.println("Hit: " + hit + "\nPseudo-Hit: " + pseudoHit);
	}

	public static void main(String[] args) {
		Color[] guess = { Color.Green, Color.Green, Color.Red, Color.Red };
		Color[] sol = { Color.Red, Color.Green, Color.Green, Color.Yellow };
		checkResult(guess, sol);
	}

}
