/*
 * Say you have an array for which the ith element is the price of 
 * a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete 
 * as many transactions as you like (ie, buy one and sell one share 
 * of the stock multiple times). However, you may not engage in 
 * multiple transactions at the same time (ie, you must sell the 
 * stock before you buy again).
 * 
 */
package com.question.LeetCode;

public class StockProfitII {

	public static void main(String[] args) {
		int[] prices = { 2, 3, 4, 0, 5 };
		StockProfitII stock = new StockProfitII();
		System.out.print(stock.maxProfit(prices));
	}

	// o(N)
	public int maxProfit(int[] prices) {
		int price = 0;
		for (int i = 1; i < prices.length; i++) {
			int difference = prices[i] - prices[i - 1];

			if (difference > 0) {
				price = price + difference;
			}
		}
		return price;
	}
}
