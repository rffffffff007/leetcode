public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                sum[i] += sum[j] * sum[i - 1 - j];
            }
        }
        return sum[n];
    }
}