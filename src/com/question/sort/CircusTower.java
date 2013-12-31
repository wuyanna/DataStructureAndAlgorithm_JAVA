/* 
 * Cracking the coding interview (5th edition)
 * Chapter 11 - Sorting and Searching
 * 
 * Question 11.7
 * A Circus is designing a tower routine consisting of people standing atop one
 * another's shoulders. For practical and aesthetic reasons, each person must be
 * both shorter and lighter than the person below him or her. Given the heights 
 * and weights of each person in the circus, write a method to compute the largest
 * possible number of people in such a tower.
 * EXAMPLE:
 * Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * Output: The longest tower is length 6 and includes from top to bottom:
 *  (56, 90) (60, 95) (65, 100) (68, 110) (70, 150) (75, 190)
 * 
 * Solution - pg 371
 * 
 */
package com.question.sort;

import java.util.ArrayList;
import java.util.Collections;

public class CircusTower {

	public static ArrayList<Person> getIncreasingSequence(
			ArrayList<Person> people) {
		Collections.sort(people);
		ArrayList<Person>[] solutions = new ArrayList[people.size()];
		longestIncreasingSequence(people, solutions, 0);
		ArrayList<Person> longest = null;
		for (int i = 0; i < people.size(); i++) {
			longest = longerSequence(longest, solutions[i]);
		}
		return longest;
	}

	public static void longestIncreasingSequence(ArrayList<Person> people,
			ArrayList<Person>[] solutions, int index) {
		if (index >= people.size())
			return;
		Person current_person = people.get(index);
		ArrayList<Person> longest = null;
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).canBeAbove(current_person)) {
				longest = longerSequence(longest, solutions[i]);
			}
		}
		if (longest == null)
			longest = new ArrayList<Person>();
		ArrayList<Person> new_solution = new ArrayList<Person>(longest);
		new_solution.add(current_person);
		solutions[index] = new_solution;
		longestIncreasingSequence(people, solutions, index + 1);
	}

	public static ArrayList<Person> longerSequence(ArrayList<Person> people1,
			ArrayList<Person> people2) {
		if (people1 == null)
			return people2;
		if (people2 == null)
			return people1;
		return people1.size() > people2.size() ? people1 : people2;
	}

	private static class Person implements Comparable<Person> {
		private int weight;
		private int height;

		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}

		public boolean canBeAbove(Person p) {
			return this.weight < p.weight && this.height < p.height;
		}

		@Override
		public String toString() {
			return "(" + this.height + ", " + this.weight + ")";
		}

		@Override
		public int compareTo(Person p) {
			if (p.height == this.height) {
				return ((Integer) this.weight).compareTo(p.weight);
			}
			return ((Integer) this.height).compareTo(p.height);
		}
	}

	public static void main(String[] args) {
		// Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68,
		// 110)
		Person p0 = new Person(100, 65);
		Person p1 = new Person(150, 70);
		Person p2 = new Person(90, 56);
		Person p3 = new Person(190, 75);
		Person p4 = new Person(95, 60);
		Person p5 = new Person(110, 68);
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(p0);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		people.add(p5);
		System.out.print(getIncreasingSequence(people));
	}

}
