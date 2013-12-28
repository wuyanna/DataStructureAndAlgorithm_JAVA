/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.7
 * Implement the "paint fill" function that one might see on many image editing
 * programs. That is, given a screen (represented by a two-dimensional array of
 * colors), a point, and a new color, fill in the surrounding area until the color
 * changes from the original color.
 * 
 * Solution - pg 327
 * 
 */
package com.question.recursions;

enum Color {
	Black, White, Green, Blue, Red;

	@Override
	public String toString() {
		if (this == Black)
			return "black";
		if (this == White)
			return "white";
		if (this == Green)
			return "green";
		if (this == Blue)
			return "blue";
		if (this == Red)
			return "red";
		return "unknown";
	}
}

public class PaintFill {

	public static void fillPaint(Color[][] screen, int x, int y, Color ncolor,
			Color ocolor) {
		if (x < 0 || y < 0 || x >= screen.length || y >= screen[0].length) {
			return;
		}

		if (ocolor == screen[y][x]) {
			screen[y][x] = ncolor;
			fillPaint(screen, x - 1, y, ncolor, ocolor);
			fillPaint(screen, x, y - 1, ncolor, ocolor);
			fillPaint(screen, x + 1, y, ncolor, ocolor);
			fillPaint(screen, x, y + 1, ncolor, ocolor);
		}
		return;
	}

	public static void fillPaint(Color[][] screen, int x, int y, Color ncolor) {
		fillPaint(screen, x, y, ncolor, screen[x][y]);
	}

	public static Color[][] setupScreen(Color color, int width, int height) {
		Color[][] screen = new Color[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				screen[i][j] = color;
			}
		}
		return screen;
	}

	public static void addColor(Color[][] screen, Color color, int x1, int y1,
			int x2, int y2) {
		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				screen[i][j] = color;
			}
		}
		return;
	}

	public static void main(String[] args) {
		int height = 10;
		int width = 10;
		Color[][] screen = setupScreen(Color.Black, width, height);
		addColor(screen, Color.Blue, 3, 5, 6, 9);
		fillPaint(screen, 2, 2, Color.Green);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(screen[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
