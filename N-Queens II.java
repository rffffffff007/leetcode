public class Solution {
    private int total = 0;

	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		total = 0;
		int[] queens = new int[n];
		Arrays.fill(queens, -1);
		searchQueens(0, queens);
		return total;
	}

	private void searchQueens(int i, int[] queens) {
		int n = queens.length;
		if (i == n) {
			total++;
			return;
		}

		for (int j = 0; j < n; j++) {
			if (couldPlace(i, j, queens)) {
				queens[i] = j;
				searchQueens(i + 1, queens);
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