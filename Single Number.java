public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int xor = 0;
        for(int a : A)
            xor ^= a;
        return xor;
    }
}

public class Solution {
    private static final int DUPLICATE_SIZE = 2;
    public int singleNumber(int[] A) {
        return singleNumber(A, 0, A.length);
    }
    
    // 3-way partition
    private int[] partition(int[] A, int start, int end){
        int pval = A[start];
        int s = start;
        int p = start;
        int q = end - 1;
        while(p <= q){
            if(A[p] == pval){
                p++;
            } else if(A[p] > pval){
                swap(A, p, q);
                q--;
            } else {
                swap(A, p, s);
                s++;
                p++;
            }
        }
        int[] res = new int[2];
        res[0] = s;
        res[1] = p;
        return res;
    }
    
    private void swap(int[] A, int x, int y){
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }
    
    private int singleNumber(int[] A, int start, int end){
        if(start == end)
            return 0;
        int[] pivots = partition(A, start, end);
        if(pivots[1] - pivots[0] < DUPLICATE_SIZE){
            // middle val is the single val.
            return A[pivots[0]];
        } else if((pivots[0] - start) % DUPLICATE_SIZE == 0){
            // single number located in right part
            return singleNumber(A, pivots[1], end);
        } else{
            // single number located in left part
            return singleNumber(A, start, pivots[0]);
        }
    }
}