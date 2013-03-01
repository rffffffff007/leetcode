public class Solution {
    public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() * p.length() < 1000000) {
			matchArray = new short[s.length() + 1][p.length() + 1];
		}
		return match(s, 0, s.length(), p, 0, p.length());
	}

	private short[][] matchArray;

	private boolean match(String a, int as, int ae, String b, int bs, int be) {
		if (matchArray != null && matchArray[as][bs] != 0) {
			return matchArray[as][bs] == 1;
		}
		boolean res = false;
		if (bs == be && as == ae) {
			res = true;
		} else if (bs == be) {
			res = false;
		} else {
			if (as < ae
					&& (a.charAt(as) == b.charAt(bs) || b.charAt(bs) == '?')) {
				res = match(a, as + 1, ae, b, bs + 1, be);
			} else if (b.charAt(bs) == '*') {
				if (match(a, as, ae, b, bs + 1, be)) {
					res = true;
				} else if (as < ae) {
					if (match(a, as + 1, ae, b, bs + 1, be)) {
						res = true;
					} else if (match(a, as + 1, ae, b, bs, be)) {
						res = true;
					}
				}
			}
		}
		if (matchArray != null) {
			matchArray[as][bs] = (short) (res ? 1 : -1);
		}
		return res;
	}
}