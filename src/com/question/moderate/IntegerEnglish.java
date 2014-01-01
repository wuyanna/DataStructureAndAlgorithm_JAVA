/* 
 * Cracking the coding interview (5th edition)
 * Chapter 17 - Moderate
 * 
 * Question 17.7
 * Given any integer, print an English phrase that describes the integer (e.g.,
 * "One Thousand, Two Hundred Thirty Four").
 * 
 * Solution - pg 442
 * 
 */
package com.question.moderate;

public class IntegerEnglish {

	public static void printNumber(int n) {
		if (n <= 10) {
			switch (n) {
			case 1:
				System.out.print("One ");
				break;
			case 2:
				System.out.print("Two ");
				break;
			case 3:
				System.out.print("Three ");
				break;
			case 4:
				System.out.print("Four ");
				break;
			case 5:
				System.out.print("Five ");
				break;
			case 6:
				System.out.print("Six ");
				break;
			case 7:
				System.out.print("Seven ");
				break;
			case 8:
				System.out.print("Eight ");
				break;
			case 9:
				System.out.print("Nine ");
				break;
			case 10:
				System.out.print("Ten ");
				break;
			default:
				break;
			}
		} else if (n > 10 && n < 20) {
			switch (n) {
			case 11:
				System.out.print("Eleven ");
				break;
			case 12:
				System.out.print("Twelve ");
				break;
			case 13:
				System.out.print("Thirteen ");
				break;
			case 14:
				System.out.print("Fourteen ");
				break;
			case 15:
				System.out.print("Fifteen ");
				break;
			case 16:
				System.out.print("Sixteen ");
				break;
			case 17:
				System.out.print("Seventeen ");
				break;
			case 18:
				System.out.print("Eighteen ");
				break;
			case 19:
				System.out.print("Nineteen ");
				break;
			default:
				break;
			}
		} else {
			int t = n / 10;
			int s = n - 10 * t;
			switch (t) {
			case 2:
				System.out.print("Twenty ");
				break;
			case 3:
				System.out.print("Thirty ");
				break;
			case 4:
				System.out.print("Forty ");
				break;
			case 5:
				System.out.print("Fifty ");
				break;
			case 6:
				System.out.print("Sixty ");
				break;
			case 7:
				System.out.print("Seventy ");
				break;
			case 8:
				System.out.print("Eighty ");
				break;
			case 9:
				System.out.print("Ninty ");
				break;
			default:
				break;
			}
			printNumber(s);
		}
	}

	public static void printHundred(int nh) {
		if (nh >= 100) {
			printNumber(nh / 100);
			System.out.print("Hundred ");
			printNumber(nh - nh / 100 * 100);
		} else {
			printNumber(nh);
		}
	}

	public static void printEnglish(int n, int lv) {
		int ni = n / 1000;
		int noffset = n - ni * 1000;
		if (ni > 0) {
			printEnglish(ni, lv + 1);
		}
		printHundred(noffset);
		switch (lv) {
		case 1:
			System.out.print("Thousand ");
			break;
		case 2:
			System.out.print("Million ");
			break;
		case 3:
			System.out.print("Billion ");
			break;
		case 4:
			System.out.print("Trillion ");
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		printEnglish(111123845, 0);
	}

}
