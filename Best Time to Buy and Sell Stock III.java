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