public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        for(int i = m - 1; i >= 0; i--)
            A[i + n] = A[i];            
        
        int pa = n;
        int pb = 0;
        int pc = 0;
        
        while(pb < n || pa < n + m){
            if(pb == n || pa < n + m && A[pa] < B[pb])
                A[pc++] = A[pa++];
            else 
                A[pc++] = B[pb++];
        }
    }
}