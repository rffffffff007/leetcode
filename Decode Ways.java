public class Solution {
    public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[] cs = s.toCharArray();
		if (cs.length == 0)
			return 0;
		int[] num = new int[cs.length];
		for (int i = 0; i < cs.length; i++) {
			if (validChar(cs[i])) {
				num[i] += i > 0 ? num[i - 1] : 1;
			}
			if (valid2Char(cs, i)) {
				num[i] += i > 1 ? num[i - 2] : 1;
			}
		}
		return num[cs.length - 1];
	}

	private boolean validChar(char c) {
		return c >= '1' && c <= '9';
	}

	private boolean valid2Char(char[] c, int i) {
		int len = c.length;
		if (i < 1 || len < 2)
			return false;
		return c[i - 1] == '1' && c[i] >= '0' && c[i] <= '9' || c[i - 1] == '2'
				&& c[i] >= '0' && c[i] <= '6';
	}
}