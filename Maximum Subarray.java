public class Solution {
    public int maxSubArray(int[] A) {
        int n = A.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            sum += A[i];
            max = Math.max(max, sum);
            if(sum < 0)
                sum = 0;
        }
        return max;
    }
}