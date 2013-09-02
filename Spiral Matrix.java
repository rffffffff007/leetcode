public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        spiralOutput(matrix, 0, res);
        return res;
    }

    private void spiralOutput(int[][] matrix, int index, ArrayList<Integer> list) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        if (n == 0)
            return;
        if (Math.min(m, n) <= index * 2) {
            return;
        }
        int i, j;
        // (index, index) -> (index, n - index - 1)
        for (i = index, j = index; j < n - index; j++) {
            list.add(matrix[i][j]);
        }
        // (index + 1, n - index - 1) -> (n - index - 1, n - index - 1)
        for (i = index + 1, j = n - index - 1; i < m - index; i++) {
            list.add(matrix[i][j]);
        }
        // (n - index - 1, n - index - 2) -> (n - index - 1, index)
        if (index != m - index - 1) {
            for (i = m - index - 1, j = n - index - 2; j >= index; j--) {
                list.add(matrix[i][j]);
            }
        }
        // (n - index - 1, index) -> (index + 1, index)
        if (index != n - index - 1) {
            for (i = m - index - 2, j = index; i > index; i--) {
                list.add(matrix[i][j]);
            }
        }
        spiralOutput(matrix, index + 1, list);

    }
}

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return spiralOrder(matrix, 0, new ArrayList<Integer>());
    }

    private static final int[][] DIRS = new int[][] { { 0, 1 }, { 1, 0 },
            { 0, -1 }, { -1, 0 } };

    private ArrayList<Integer> spiralOrder(int[][] matrix, int k,
            ArrayList<Integer> order) {
        int n = matrix.length;
        int m = n > 0 ? matrix[0].length : 0;
        int subn = n - 2 * k;
        int subm = m - 2 * k;
        if (subn <= 0 || subm <= 0)
            return order;
        int x = k;
        int y = k;
        int numCount = 2 * subn + 2 * subm - 4;
        if(subn + subm == 2){
            numCount = subn + subm - 1;
        } else if(subn == 1 || subm == 1){
            numCount = subn + subm - 1 + (subn > 1 ? subm - 1 : 0) + (subm > 1 ? subn - 1 : 0);
        }
        int dirI = 0;
        for (int i = 0; i < numCount; i++) {
            order.add(matrix[x][y]);
            if (i == subm - 1 || i == subm + subn - 2
                    || i == subm + subn + subm - 3)
                dirI++;
            int[] dir = DIRS[dirI];
            x += dir[0];
            y += dir[1];
        }
        return spiralOrder(matrix, k + 1, order);
    }

}