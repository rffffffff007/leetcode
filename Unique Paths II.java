public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] grid = obstacleGrid;
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;
        int[][] sum = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    if(i == 0 && j == 0){
                        sum[i][j] = 1;
                    }else{
                        sum[i][j] = (i > 0 ? sum[i - 1][j] : 0) + (j > 0 ? sum[i][j - 1] : 0);
                    }
                }
            }
        }
        if(m == 0 || n == 0){
            return 0;
        }else{
            return sum[m - 1][n - 1];
        }
    }
    
}