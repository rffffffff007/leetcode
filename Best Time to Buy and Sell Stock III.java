
/**
 * @time: 2013-08-13
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        List<Integer> ps = new ArrayList<Integer>();
        int last = Integer.MIN_VALUE;
        // remove duplicate prices.
        for(int p : prices){
            if(p != last){
                ps.add(p);
            }
            last = p;
        }
        int n = ps.size();
        prices = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = ps.get(i);
        }
        
        int[] minLeft = new int[n];
        int[] maxRight = new int[n];
        Arrays.fill(minLeft, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++){
            if(i > 0)
                minLeft[i] = minLeft[i - 1];
            minLeft[i] = Math.min(minLeft[i], prices[i]);
        }
        Arrays.fill(maxRight, Integer.MIN_VALUE);
        for(int i = n - 1; i >= 0; i--){
            if(i < n - 1)
                maxRight[i] = maxRight[i + 1];
            maxRight[i] = Math.max(maxRight[i], prices[i]);
        }
        
        // First round, sell on ith day.
        // Second round, buy on jth day. 
        int profit = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int firstProfit = prices[i] - minLeft[i];
                int secondProfit = maxRight[j] - prices[j];
                profit = Math.max(profit, firstProfit + secondProfit);
            }
        }
        return profit;
    }
}


public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        // only record the header and footer of acsending sequence.
        List<Integer> pList = new ArrayList<Integer>();
        int lastIndex = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[i - 1]){
                if(i - lastIndex > 1){
                    pList.add(prices[lastIndex]);
                    pList.add(prices[i - 1]);
                }
                lastIndex = i;
            }
        }
        if(prices.length - lastIndex > 1){
            pList.add(prices[lastIndex]);
            pList.add(prices[prices.length - 1]);
        }
        
        Integer[] pricesInt = pList.toArray(new Integer[] {});
        int len = pricesInt.length;
        int[][] min = new int[len][len];
        for (int i = 0; i < len; i++) {
            min[i][i] = pricesInt[i];
            for (int j = i + 1; j < len; j++) {
                min[i][j] = pricesInt[j] < min[i][j - 1] ? pricesInt[j]
                        : min[i][j - 1];
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            int value = pricesInt[i] - min[0][i];
            max = value > max ? value : max;
            for (int j = i + 1; j < len; j++) {
                int value2 = value + pricesInt[j] - min[i + 1][j];
                max = value2 > max ? value2 : max;
            }
        }
        return max;
    }
}
