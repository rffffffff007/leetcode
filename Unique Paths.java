/**
 * @time: 2013-09-02
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long x = Math.min(m, n) - 1;
        long y = Math.max(m, n) - 1;
        
        long ways = 1;
        // return (x+y)! / x! / y!
        for(long i = y + 1; i <= x + y; i++){
            ways *= i;
        }
        for(long i = 1; i <= x; i++){
            ways /= i;
        }
        return (int)ways;
    }
}

public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] sum = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    sum[i][j] = 1;
                }else{
                    sum[i][j] = (i > 0 ? sum[i - 1][j] : 0) + (j > 0 ? sum[i][j - 1] : 0);
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