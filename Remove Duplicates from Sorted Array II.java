public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        int distinctCount = 0;
        for(int i = 0; i < n; i++)
            if(distinctCount == 0 || A[i] != A[distinctCount - 1] || distinctCount == 1 || A[i] != A[distinctCount - 2])
                A[distinctCount++] = A[i];
        return distinctCount;
    }   
}