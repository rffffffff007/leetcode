/**
 * @time:2013-08-28
 */
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int maxStep = 0;
        for(int i = 0; i < n; i++){
            if(maxStep >= n - 1)
                return true;
            if(i > maxStep)
                return false;
            maxStep = Math.max(i + A[i], maxStep);
        }
        return true;
    }
}

public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        int minJump = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] >= minJump - i) {
                minJump = i;
            }
        }
        return minJump == 0;
    }
}