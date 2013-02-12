public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int leni = grid.length;
        if(leni == 0){
            return 0;
        }
        int lenj = grid[0].length;
        int[][] min = new int[leni][lenj];
        
        int left;
        int top;
        for(int i = 0; i < leni; i++){
            for(int j = 0; j < lenj; j++){
                if(i == 0 && j == 0){
                     min[i][j] = grid[i][j];
                }else{
                    left = i > 0 ? min[i - 1][j] : Integer.MAX_VALUE;
                    top = j > 0 ? min[i][j - 1] : Integer.MAX_VALUE;
                    min[i][j] = Math.min(left, top) + grid[i][j];
                }
            }
        }
        return min[leni - 1][lenj - 1];
    }
}