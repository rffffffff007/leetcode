public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        ArrayList<String[]> res = new ArrayList<String[]>();
        searchQueens(0, queens, res);
        return res;
    }

    private void searchQueens(int i, int[] queens, ArrayList<String[]> res) {
        int n = queens.length;
        if (i == n) {
            String[] strs = new String[n];
            res.add(strs);
            for (int j = 0; j < n; j++) {
                StringBuilder dotsStr = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (queens[j] == k)
                        dotsStr.append('Q');
                    else
                        dotsStr.append('.');
                }
                strs[j] = dotsStr.toString();
            }
            return;
        }

        for (int j = 0; j < n; j++) {
            if (couldPlace(i, j, queens)) {
                queens[i] = j;
                searchQueens(i + 1, queens, res);
                queens[i] = -1;
            }
        }
    }

    private boolean couldPlace(int i, int j, int[] queens) {
        int n = queens.length;
        for (int k = 0; k < i; k++) {
            if (queens[k] == j) {
                return false;
            }
        }
        for (int k = 0; k <= j && k <= i; k++) {
            if (queens[i - k] == j - k) {
                return false;
            }
        }
        for (int k = 0; k < n - j && k <= i; k++) {
            if (queens[i - k] == j + k) {
                return false;
            }
        }
        return true;
    }
}