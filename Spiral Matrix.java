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