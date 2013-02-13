public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        if(n == 0){
            return;
        }
        int tmp;
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < n / 2; j++){
                // (i, j) -> (j, n - i) -> (n - i, n - j) -> (n - j, i)
                swap(matrix, i, j);
            }
        }
        if(n % 2 != 0){
            for(int i = 0; i <= n / 2; i++){
                swap(matrix, i, n / 2);
            }
        }
    }
    
    private void swap(int[][] matrix, int i, int j){
        int n = matrix.length;
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = tmp;
    }
}