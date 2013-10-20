public class Solution {
    private static int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = n > 0 ? matrix[0].length : 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] border = new int[]{0, m - 1, n - 1, 0};
        int x = 0;
        int y = 0;
        int dir = 0;
        for(int i = 0; i < n * m; i++){
            res.add(matrix[x][y]);
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
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        spiralOutput(matrix, 0, res);
        return res;
    }

    private void spiralOutput(int[][] matrix, int index, ArrayList<Integer> list) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        if (n == 0)
            return;
        if (Math.min(m, n) <= index * 2) {
            return;
        }
        int i, j;
        // (index, index) -> (index, n - index - 1)
        for (i = index, j = index; j < n - index; j++) {
            list.add(matrix[i][j]);
        }
        // (index + 1, n - index - 1) -> (n - index - 1, n - index - 1)
        for (i = index + 1, j = n - index - 1; i < m - index; i++) {
            list.add(matrix[i][j]);
        }
        // (n - index - 1, n - index - 2) -> (n - index - 1, index)
        if (index != m - index - 1) {
            for (i = m - index - 1, j = n - index - 2; j >= index; j--) {
                list.add(matrix[i][j]);
            }
        }
        // (n - index - 1, index) -> (index + 1, index)
        if (index != n - index - 1) {
            for (i = m - index - 2, j = index; i > index; i--) {
                list.add(matrix[i][j]);
            }
        }
        spiralOutput(matrix, index + 1, list);
    }
}