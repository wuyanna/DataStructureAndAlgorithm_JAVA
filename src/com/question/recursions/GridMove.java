/* 
 * Cracking the coding interview (5th edition)
 * Chapter 9 - Recursion and Dynamic Programming
 * 
 * Question 9.2
 * Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can
 * only move in two directions: right and down. How many possible paths are there
 * for the robot to go from (0,0) to (X,Y)?
 * FOLLOW UP
 * Imagine certain spots are "off limits", such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom
 * right.
 * 
 * Solution - pg 317
 * 
 */
package com.question.recursions;

import java.awt.Point;
import java.util.ArrayList;

public class GridMove {

	public static int moves(int sx, int sy, int dx, int dy) {
		if (dx <= sx && dy <= sy)
			return 0;
		if (dy == sy)
			return 1;
		if (dx == sx)
			return 1;
		return moves(sx, sy, dx, dy - 1) + moves(sx, sy, dx - 1, dy);
	}

	// TODO: do again later
	public static boolean getPaths(int x, int y, ArrayList<Point> path) {
		Point point = new Point(x, y);
		// path.add(point);
		if (x == 0 && y == 0) {
			return true;
		}
		boolean success = false;
		if (x >= 1 && isFree(x - 1, y)) { // left
			success = getPaths(x - 1, y, path);
		}
		if (!success && y >= 1 && isFree(x, y - 1)) { // right
			success = getPaths(x, y - 1, path);
		}
		if (success) {
			path.add(point);
		}
		return success;
	}

	// customize limits
	public static boolean isFree(int x, int y) {
		if (x == y)
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.print(moves(0, 0, 1, 1));
	}

}
