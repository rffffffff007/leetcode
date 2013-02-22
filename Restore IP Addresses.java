public class Solution {
    static final int IP_COUNT = 4;
	static final int IP_LEN = 3;

	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		char[] cs = s.toCharArray();
		searchIp(cs, 0, new int[4], res);
		return res;
	}

	private void searchIp(char[] cs, int index, int[] ipIndexs,
			ArrayList<String> res) {
		int n = cs.length;
		if (index == IP_COUNT) {
			if (ipIndexs[IP_COUNT - 1] != n)
				return;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < IP_COUNT; i++) {
				int s = i == 0 ? 0 : ipIndexs[i - 1];
				int e = ipIndexs[i];
				sb.append(cs, s, e - s);
				if (i != IP_COUNT - 1) {
					sb.append('.');
				}
			}
			res.add(sb.toString());
			return;
		}

		int start = index == 0 ? 0 : ipIndexs[index - 1];
		for (int i = 0; i < IP_LEN && start + i < n; i++) {
			if (isValid(cs, start, start + i + 1)) {
				ipIndexs[index] = start + i + 1;
				searchIp(cs, index + 1, ipIndexs, res);
			}
		}
	}

    private boolean isValid(char[] cs, int s, int e) {
		int n = e - s;
		if (n == 0 || n > IP_LEN)
			return false;
		if (cs[s] == '0') {
			return n == 1;
		}
		int sum = 0;
		for (int i = s; i < e; i++) {
			sum *= 10;
			sum += cs[i] - '0';
		}
		return sum <= 255;
	}

}