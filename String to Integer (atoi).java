public class Solution {
    public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str == null)
			return 0;
		str = str.trim();
		char[] cs = str.toCharArray();
		int n = cs.length;
		int index = 0;
		int flag = 1;
		if (n > 0 && (cs[0] == '-' || cs[0] == '+')) {
			flag = cs[0] == '-' ? -1 : 1;
			index++;
		}
		long val = 0;
		for (; index < n; index++) {
			if (!Character.isDigit(cs[index])) {
				break;
			} else {
				val *= 10;
				val += cs[index] - '0';
				if (flag == 1 && val > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (flag == -1 && val * flag < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
		}
		return (int) (val * flag);
	}
}