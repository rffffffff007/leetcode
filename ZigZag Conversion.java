public class Solution {
    public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		char[] cs = s.toCharArray();
		int m = nRows;
		int n = len / m * 2 + 1;
		char[][] zig = new char[m][n];
		int x = 0;
		int y = 0;
		int dir = 1;
		for (char c : cs) {
			zig[x][y] = c;
			if (dir == 1 && x + dir == m) {
				dir = -1;
				if (x > 0) {
					x += dir;
				}
				y += 1;
				if (x == 0) {
					dir = 1;
				}
			} else if (dir == -1 && x + dir == 0) {
				x += dir;
				y += 1;
				dir = 1;
			} else {
				x += dir;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (zig[i][j] > 0) {
					sb.append(zig[i][j]);
				}
			}
		}
		return sb.toString();
	}
}