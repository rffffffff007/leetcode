public class Solution {
    public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[] cs = word.toCharArray();
		if (cs.length == 0) {
			return true;
		}
		int m = board.length;
		if (m == 0) {
			return false;
		}
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == cs[0]) {
					visited[i][j] = true;
					if (search(board, visited, i, j, cs, 1)) {
						return true;
					}
					visited[i][j] = false;
				}
			}
		}
		return false;
	}

	static int[][] DIRECTIONS = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 },
			{ 0, -1 } };

	private boolean search(char[][] board, boolean[][] visited, int x, int y,
			char[] word, int index) {
		if (index == word.length) {
			return true;
		}
		int m = board.length;
		int n = board[0].length;
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + DIRECTIONS[i][0];
			ny = y + DIRECTIONS[i][1];
			if (isValid(nx, ny, m, n) && !visited[nx][ny]
					&& board[nx][ny] == word[index]) {
				visited[nx][ny] = true;
				if (search(board, visited, nx, ny, word, index + 1)) {
					return true;
				}
				visited[nx][ny] = false;
			}
		}
		return false;
	}

	private boolean isValid(int x, int y, int m, int n) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}