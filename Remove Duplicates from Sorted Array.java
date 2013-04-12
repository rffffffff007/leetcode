public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int lasti = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || A[i] != A[lasti]) {
                int step = i - lasti - 1;
                move(A, n, i, step);
                n -= step;
                i -= step;
                lasti = i;
            }
        }
        return n;
    }
    
    private void move(int[] a, int n, int index, int moveStep){
        for(int i = index; i < n; i++){
            a[i - moveStep] = a[i];
        }
    }
}