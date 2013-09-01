/**
 * @time: 2013-08-31
 */
public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // b[x][y] = a[n-1-y][x]
        int n = matrix.length;
        int ni = n / 2;
        int nj = n / 2;
        if(n % 2 == 1)
            ni++;
        for(int i = 0; i < ni; i++){
            for(int j = 0; j < nj; j++){
                int x = i;
                int y = j;
                int tmp = matrix[y][x];
                for(int k = 0; k < 3; k++){
                    int nx = y;
                    int ny = n - 1 - x;
                    matrix[y][x] = matrix[ny][nx];
                    x = nx;
                    y = ny;
                }
                matrix[y][x] = tmp;
            }
        }
    }
}