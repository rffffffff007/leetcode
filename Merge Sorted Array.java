/**
 * @time: 2013-08-30
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = m - 1; i >= 0; i--){
            A[i + n] = A[i];            
        }
        int pa = n;
        int pb = 0;
        int pc = 0;
        
        while(pb < n || pa < n + m){
            if(pa < n + m && (pb == n || A[pa] < B[pb])){
                A[pc++] = A[pa++];
            } else {
                A[pc++] = B[pb++];
            }
                
        }
    }
}