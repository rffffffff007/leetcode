public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        return searchMatrix(matrix, 0, m * n, target);
    }

    public boolean searchMatrix(int[][] matrix, int start, int end, int target) {
        if (start == end) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int mid = (start + end) / 2;

        int i = mid / n;
        int j = mid % n;
        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] > target) {
            return searchMatrix(matrix, start, mid, target);
        } else {
            return searchMatrix(matrix, mid + 1, end, target);
        }
    }
}