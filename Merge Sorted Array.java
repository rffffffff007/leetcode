public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = m - 1; i >= 0; i--){
            A[n + i] = A[i];
        }
        
        int c = 0;
        int a = n;
        int b = 0;
        int mn = m + n;
        for(; c < mn; c++){
            if(a == mn){
                A[c] = B[b++];
            }else if(b == n){
                A[c] = A[a++];
            }else if(A[a] < B[b]){
                A[c] = A[a++];
            }else{
                A[c] = B[b++];
            }
        }
        
    }
}