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