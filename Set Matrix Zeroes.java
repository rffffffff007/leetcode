public class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = n > 0 ? matrix[0].length : 0;
        // whether the first row/col should be set to zero.
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for(int i = 0; i < n; i++)
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        for(int j = 0; j < m; j++)
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        // use the first row/col to restore which row/col is zero.
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < n; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < m; j++)
                    matrix[i][j] = 0;
            }
        }
        for(int j = 1; j < m; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < n; i++)
                    matrix[i][j] = 0;
            }
        }
        if(firstRowZero)
            for(int j = 0; j < m; j++)
                matrix[0][j] = 0;
        if(firstColZero)
            for(int i = 0; i < n; i++)
                matrix[i][0] = 0;
    }
}