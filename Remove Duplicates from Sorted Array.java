public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lastI = 0;
        int realI = 0;
        for(int i = 0; i <= A.length; i++){
            if(i > lastI && (i == A.length || A[i] != A[lastI])){
                A[realI++] = A[lastI];
                lastI = i;
            }
        }
        return realI;
    }
}

/**
 * @time: 2013-08-31
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        int distinctCount = 0;
        
        for(int i = 0; i < n; i++){
            if(distinctCount == 0 || A[i] != A[distinctCount - 1]){
                A[distinctCount++] = A[i];
            }
        }
        return distinctCount;
    }   
}