package leetcode.greedy;

public class BestTimetoBuyandSellStock {
//	Say you have an array for which the ith element is the price of a given stock on day i.
//
//	If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	
//	http://fisherlei.blogspot.com/2013/01/leetcode-best-time-to-buy-and-sell.html
	public int maxProfit(int[] prices) {
        int Min = Integer.MAX_VALUE;
        int Max = 0;
        for(int i = 0; i < prices.length; ++i){
            Min = Math.min(Min, prices[i]);
            Max = Math.max(Max, prices[i]-Min);
        }
        return Max;
    }
}
