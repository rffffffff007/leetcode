public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length;
    	int profit = 0;
        for(int i = 0; i < len - 1; i++){
        	if(prices[i + 1] > prices[i]){
        		profit += prices[i + 1] - prices[i];
        	}
        }
        return profit;
    }
}