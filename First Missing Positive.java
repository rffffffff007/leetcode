public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        // similar with count sort, use A as the hash table.
        for(int i = 0; i < n; i++){
            int val = A[i];
            while(val > 0 && val <= n && val != A[val - 1]){
                int tmp = A[val - 1];
                A[val - 1] = val;
                val = tmp;
            }
        }
        int i;
        for(i = 0; i < n; i++){
            if(A[i] != i + 1){
                break;
            }
        }
        return i + 1;
    }
}