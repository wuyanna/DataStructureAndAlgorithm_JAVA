package com.question.careercup;
/*Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures
 * Time Complexity O(n)
 * Space Complexity O(1)*/
public class UniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueCharacter character = new UniqueCharacter();
		System.out.print(character.checkUnique("aab"));
	}

	public boolean checkUnique(String s) {
		boolean[] character = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			int value = s.charAt(i);
			
			if (character[value]) {
				return false;
			}
			character[value] = true;
		}
		return true;
	}
}
