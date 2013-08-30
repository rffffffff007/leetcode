/**
 * @time: 2013-08-30
 */
public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return solveNQ(n, 0, new int[n]);
    }

    private int solveNQ(int n, int row, int[] queens) {
        if (row == n) {
            return 1;
        }
        int sum = 0;
        for (int col = 0; col < n; col++) {
            if (fit(n, queens, row, col)) {
                queens[row] = col;
                sum += solveNQ(n, row + 1, queens);
            }
        }
        return sum;
    }

    private boolean fit(int n, int[] queens, int row, int col) {
        int leftTop = col;
        int rightTop = col;
        for (int i = row - 1; i >= 0; i--) {
            leftTop--;
            rightTop++;
            if (queens[i] == col || queens[i] == leftTop
                    || queens[i] == rightTop)
                return false;
        }
        return true;
    }
}