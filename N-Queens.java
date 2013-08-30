/**
 * @time: 2013-08-30
 */
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res = new ArrayList<String[]>();
        solveNQ(n, 0, new int[n], res);
        return res;
    }
    
    private void solveNQ(int n, int row, int[] queens, ArrayList<String[]> res){
        if(row == n){
            String[] strs = new String[n];
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            for(int i = 0; i < n; i++){
                arr[queens[i]] = 'Q';
                strs[i] = new String(arr);
                arr[queens[i]] = '.';
            }
            res.add(strs);
            return;
        }
        for(int col = 0; col < n; col++){
            if(fit(n, queens, row, col)){
                queens[row] = col;
                solveNQ(n, row + 1, queens, res);
            }
        }
    }
    
    private boolean fit(int n, int[] queens, int row, int col){
        int leftTop = col;
        int rightTop = col;
        for(int i = row - 1; i >= 0; i--){
            leftTop--;
            rightTop++;
            if(queens[i] == col || queens[i] == leftTop || queens[i] == rightTop)
                return false;
        }
        return true;
    }
}