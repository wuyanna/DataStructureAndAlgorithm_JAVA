package com.question.LeetCode;

public class String2Integer {

	public int atoi(String str) {
		int res = 0;
		int sign = 1;
		boolean discard = true;
		for (int i = 0; i < str.length(); i++) {
			char n = str.charAt(i);
			if (n >= '0' && n <= '9') {
				int num = n - '0';
				if ((res > Integer.MAX_VALUE / 10)
						|| (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				res = res * 10 + num;
				discard = false;
			} else if (n == '-' && discard) {
				sign = -1;
				discard = false;
			} else if (n == '+' && discard) {
				sign = 1;
				discard = false;
			} else if (n == ' ' && discard) {
				continue;
			} else {
				if (res != 0) {
					break;
				}
				res = 0;
				break;
			}
		}
		return res * sign;
	}

	public static void main(String[] args) {
		String2Integer str2int = new String2Integer();
		System.out.print(str2int.atoi("1 a"));

	}

}
