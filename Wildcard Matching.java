public class Solution {
    public boolean isMatch(String s, String p) {
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

public class Solution {
	public boolean isMatch(String s, String p) {
		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();
		int lens = cs.length;
		int lenp = cp.length;
		boolean[][] match = new boolean[lens + 1][lenp + 1];
		match[0][0] = true;

		char a, b;
		for (int i = 0; i <= lens; i++) {
			for (int j = 0; j <= lenp; j++) {
				if (j > 0) {
					b = cp[j - 1];
					match[i][j] |= match[i][j - 1] && b == '*';
					if (i > 0) {
						a = cs[i - 1];
						match[i][j] |= match[i - 1][j] && b == '*';
						match[i][j] |= match[i - 1][j - 1] && charMatch(a, b);
					}
				}
			}
		}
		return match[lens][lenp];
	}

	private boolean charMatch(char a, char b) {
		return a == b || b == '?' || b == '*';
	}
}