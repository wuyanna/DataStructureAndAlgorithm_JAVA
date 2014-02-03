package com.question.LeetCode;

import java.awt.Point;
import java.util.Hashtable;

public class MaxPoints {

	public int maxPoints(Point[] points) {
		return maxPoints(points, 0);
	}

	public int maxPoints(Point[] points, int index) {
		if (index == points.length)
			return 0;
		Point base = points[index];
		int self_count = 1;
		Hashtable<Float, Integer> table = new Hashtable<Float, Integer>();
		for (int i = index + 1; i < points.length; i++) {
			Point temp = points[i];
			if (base.x == temp.x && base.y == temp.y) {
				self_count++;
			} else {
				Float slope = getSlope(base, temp);
				if (table.containsKey(slope)) {
					int freq = table.get(slope);
					table.put(slope, freq + 1);
				} else {
					table.put(slope, 1);
				}
			}

		}

		int max = 0;

		for (Integer i : table.values()) {
			if (i > max)
				max = i;
		}
		return Math.max(max + self_count, maxPoints(points, index + 1));
	}

	public Float getSlope(Point A, Point B) {
		if (A.y == B.y) return 0f;
		if (A.x == B.x) return Float.POSITIVE_INFINITY;
		return (Float) (float) (A.y - B.y) / (Float) (float) (A.x - B.x);
	}
	
	public static void main(String[] args) {
		MaxPoints sol = new MaxPoints();
		Point[] points = {new Point(2,3), new Point(3,3), new Point(-5, 3)};
		System.out.print(sol.maxPoints(points));
	}
}