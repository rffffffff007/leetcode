public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[n][n];
        fillSpiral(matrix, 0, 1);
        return matrix;
    }

    private void fillSpiral(int[][] matrix, int index, int val) {
        int n = matrix.length;
        if (index * 2 >= n) {
            return;
        }
        int i, j;
        for (i = index, j = index; j < n - index; j++) {
            matrix[i][j] = val++;
        }
        for (i = index + 1, j = n - 1 - index; i < n - index; i++) {
            matrix[i][j] = val++;
        }
        if (index != n - 1 - index) {
            for (i = n - 1 - index, j = n - 2 - index; j >= index; j--) {
                matrix[i][j] = val++;
            }
            for (i = n - 2 - index, j = index; i > index; i--) {
                matrix[i][j] = val++;
            }
        }
        fillSpiral(matrix, index + 1, val);
    }

}