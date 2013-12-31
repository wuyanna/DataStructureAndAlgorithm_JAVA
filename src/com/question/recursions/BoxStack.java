/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.10
 * You have a stack of n boxes, with widths wi, heights hi, and depths di. The boxes
 * cannot be rotated and can only be stacked on top of one another if each box in the
 * stack is strictly larger than the box above it in width, height, and depth. Implement
 * a method to build the tallest stack possible, where the height of a stack is the sum
 * of the heights of each box.
 * 
 * Solution - pg 333
 * 
 */
package com.question.recursions;

import java.util.ArrayList;

public class BoxStack {

	// not always the highest is the bottom
	public ArrayList<Box> createStack(Box[] boxes, Box bottom) {
		ArrayList<Box> max_stack = null;
		int max_height = 0;
		int new_height = 0;
		for (Box b : boxes) {
			if (b.canBeAbove(bottom)) {
				ArrayList<Box> stack = createStack(boxes, b);
				new_height = stack.size();
				if (new_height > max_height) {
					max_stack = stack;
					max_height = new_height;
				}
			}
		}

		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(bottom);
		}

		return max_stack;
	}

	private static class Box {

		private int width;
		private int height;
		private int depth;

		public Box(int width, int height, int depth) {
			this.width = width;
			this.height = height;
			this.depth = depth;
		}

		public boolean canBeAbove(Box box) {
			if (box == null)
				return true;
			return this.width > box.width && this.height > box.height
					&& this.depth > box.depth;
		}

		@Override
		public String toString() {
			return "Box: " + width + "|" + height + "|" + depth;
		}
	}

	public static void main(String[] args) {
		Box b0 = new Box(10, 20, 10);
		Box b1 = new Box(15, 21, 12);
		Box b2 = new Box(16, 10, 16);
		Box b3 = new Box(18, 26, 30);
		Box[] boxes = { b0, b1, b2, b3 };
		BoxStack bs = new BoxStack();
		System.out.print(bs.createStack(boxes, null));
	}

}
