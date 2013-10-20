public class Solution {
    public int jump(int[] A) {
        int n = A.length;
        int start = 0;
        int end = 0;
        int step = 0;
        while(start <= end){
            if(end >= n - 1)
                break;
            step++;
            int maxReach = 0;
            for(int i = start; i <= end; i++)
                maxReach = Math.max(maxReach, i + A[i]);
            start = end + 1;
            end = maxReach;
        }
        return step;
    }
}

public class Solution {
    public int jump(int[] A) {
        int len = A.length;
        if(len == 0)
            return 0;
        int[] n = new int[len];
        n[0] = 0;
        int min;
        int maxL = 0;
        for(int i = 0; i < len; i++){
            for(int j = maxL + 1; j <= i + A[i] && j < len; j++)
                n[j] = n[i] + 1;
            maxL = Math.max(maxL, i + A[i]);
        }
        return n[len - 1];
    }
}