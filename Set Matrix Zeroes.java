public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        // whether the first row/col should be set to zero.
        boolean firstRowZero = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        boolean firstColZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        // use the first row/col to restore which row/col is zero.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                fillZeroCol(matrix, j);
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                fillZeroRow(matrix, i);
            }
        }

        if (firstRowZero) {
            fillZeroRow(matrix, 0);
        }
        if (firstColZero) {
            fillZeroCol(matrix, 0);
        }
    }

    private void fillZeroRow(int[][] matrix, int i) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            matrix[i][j] = 0;
        }
    }

    private void fillZeroCol(int[][] matrix, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            matrix[i][j] = 0;
        }
    }
}