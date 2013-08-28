/**
 * @time: 2013-08-28
 */
public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int steps = 0;
        int maxReach = 0;
        for(int i = 0; i < n; i++){
            if(maxReach >= n - 1)
                break;
            int reach = 0;
            for(int j = i; j <= maxReach; j++){
                reach = Math.max(reach, j + A[j]);
            }
            i = maxReach;
            maxReach = reach;
            steps++;
        }
        return steps;
    }
}

public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if(len == 0)
            return 0;
        int[] n = new int[len];
        n[0] = 0;
        int min;
        int maxL = 0;
        for(int i = 0; i < len; i++){
            for(int j = maxL + 1; j <= i + A[i] && j < len; j++){
                n[j] = n[i] + 1;
            }
            
            maxL = Math.max(maxL, i + A[i]);
        }
        return n[len - 1];
    }
}