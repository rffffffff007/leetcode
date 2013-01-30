public class Solution {
    public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] min = new int[prices.length];
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				min[i] = prices[i];
			} else {
				min[i] = prices[i] < min[i - 1] ? prices[i] : min[i - 1];
			}
			int profit = prices[i] - min[i];
			max = profit > max ? profit : max;
		}
		return max;
	}
}