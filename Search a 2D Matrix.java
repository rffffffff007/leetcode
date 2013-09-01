public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        int m = n > 0 ? matrix[0].length : 0;
        return bsearch(matrix, target, 0, n * m);
    }
    
    private boolean bsearch(int[][] matrix, int target, int s, int e){
        if(s == e){
            return false;
        }
        int n = matrix.length;
        int m = n > 0 ? matrix[0].length : 0;
        int mid = (s + e) / 2;
        int val = matrix[mid / m][mid % m];
        if(target == val)
            return true;
        else if(target > val)
            return bsearch(matrix, target, mid + 1, e);
        else
            return bsearch(matrix, target, s, mid);
    }
}