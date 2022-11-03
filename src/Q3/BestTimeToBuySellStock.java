package Q3;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {
        // get length of the price list.
        int n = prices.length;
        // if there are less that 2 price we can not perform buy and sell.
        if(n < 2) return 0;

        // initialize max with last price.
        int max = prices[n-1];
        // initialize max profit to 0.
        int maxProfit = 0;

        // iterate from n-1 th price to 1st price.
        for(int i=n-2;i>=0;i--) {

            // check if max profit is maximized.
            if(max-prices[i] > maxProfit) maxProfit = max-prices[i];
            // check if larger sell price present.
            if(prices[i] > max) {
                // update max sell price.
                max = prices[i];
            }
        }

        // return max profit.
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
