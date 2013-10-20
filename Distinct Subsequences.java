public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] num = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                num[i][j] += getNum(num, i - 1, j);
                if(S.charAt(i) == T.charAt(j))
                    num[i][j] += getNum(num, i - 1, j - 1);
            }
        }
        return getNum(num, m - 1, n - 1);
    }
    
    private int getNum(int[][] num, int i, int j){
        if(j < 0)
            return 1;
        if(i < 0)
            return 0;
        return num[i][j];
    }
}