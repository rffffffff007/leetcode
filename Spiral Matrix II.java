public class Solution {
    private static int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] border = new int[]{0, n - 1, n - 1, 0};
        int x = 0;
        int y = 0;
        int dir = 0;
        for(int i = 0; i < n * n; i++){
            res[x][y] = i + 1;
            int nextDir = (dir + 1) % 4;
            if(dir % 2 == 0 && y == border[nextDir] || dir % 2 == 1 && x == border[nextDir]){
                // change direction
                border[dir] += DIRS[nextDir][0] + DIRS[nextDir][1];
                dir = nextDir;
            }
            x += DIRS[dir][0];
            y += DIRS[dir][1];
        }
        return res;
    }
}

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fillSpiral(matrix, 0, 1);
        return matrix;
    }

    private void fillSpiral(int[][] matrix, int index, int val) {
        int n = matrix.length;
        if (index * 2 >= n) 
            return;
        int i, j;
        for (i = index, j = index; j < n - index; j++) 
            matrix[i][j] = val++;
        for (i = index + 1, j = n - 1 - index; i < n - index; i++) 
            matrix[i][j] = val++;
        if (index != n - 1 - index) {
            for (i = n - 1 - index, j = n - 2 - index; j >= index; j--) 
                matrix[i][j] = val++;
            for (i = n - 2 - index, j = index; i > index; i--) 
                matrix[i][j] = val++;
        }
        fillSpiral(matrix, index + 1, val);
    }

}
