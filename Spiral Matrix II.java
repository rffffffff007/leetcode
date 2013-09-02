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

public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[n][n];
        generate(n, 0, matrix, 1);
        return matrix;
    }

    private static final int[][] DIRS = new int[][] { { 0, 1 }, { 1, 0 },
            { 0, -1 }, { -1, 0 } };

    private void generate(int n, int k, int[][] matrix, int start) {
        if (n == k)
            return;
        int x = k;
        int y = k;
        int subn = n - 2 * k;
        int numCount = 4 * subn - 4;
        if (subn == 1)
            numCount = 1;
        int dirI = 0;
        for (int i = 0; i < numCount; i++) {
            matrix[x][y] = start++;
            if (subn > 1 && i > 0 && i % (subn - 1) == 0)
                dirI++;
            int[] dir = DIRS[dirI];
            x += dir[0];
            y += dir[1];
        }
        generate(n, k + 1, matrix, start);
    }
}