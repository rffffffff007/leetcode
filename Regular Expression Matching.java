/**
 * @time: 2013-08-31
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs = s.toCharArray();
        char[] ps = p.toCharArray();
        int lens = cs.length;
        int lenp = ps.length;
        boolean[] isStar = new boolean[lenp];
        int pi = 0;
        for (int i = 0; i < lenp; i++, pi++) {
            ps[pi] = ps[i];
            if (isStar(ps, i)) {
                isStar[pi] = true;
                i++;
            }
        }
        lenp = pi;
        // match[i][j] == isMatch(s[0:i], p[0:j])
        boolean[][] match = new boolean[lens + 1][lenp + 1];
        for (int i = 0; i <= lens; i++) {
            for (int j = 0; j <= lenp; j++) {
                if (i + j == 0) {
                    match[i][j] = true;
                    continue;
                }
                if (i * j > 0 && (cs[i - 1] == ps[j - 1] || ps[j - 1] == '.')) {
                    match[i][j] |= match[i - 1][j - 1];
                    if (isStar[j - 1]) {
                        match[i][j] |= match[i - 1][j];
                        match[i][j] |= match[i][j - 1];
                    }
                } else if (j > 0 && isStar[j - 1]) {
                    match[i][j] |= match[i][j - 1];
                }
            }
        }
        return match[lens][lenp];
    }

    private boolean isStar(char[] a, int i) {
        return i + 1 < a.length && a[i + 1] == '*';
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] as = s.toCharArray();
        char[] bs = p.toCharArray();
        for (int i = 0; i < bs.length; i++) {
            if (Character.isLetter(bs[i]) && !isStarLetter(bs, i)) {
                boolean contain = false;
                for (int j = 0; j < as.length; j++) {
                    if (bs[i] == as[j]) {
                        contain = true;
                        break;
                    }
                }
                if (!contain)
                    return false;
            }
        }
        return match(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean match(char[] as, int ai, char[] bs, int bi) {
        int an = as.length;
        int bn = bs.length;

        if ((bn - bi) * (an - ai) == 0) {
            while (bi < bn && isStarLetter(bs, bi)) {
                bi += 2;
            }
            return bn - bi + an - ai == 0;
        }

        if (as[ai] == bs[bi] || bs[bi] == '.') {
            if (isStarLetter(bs, bi)) {
                return match(as, ai + 1, bs, bi)
                        || match(as, ai + 1, bs, bi + 2)
                        || match(as, ai, bs, bi + 2);
            } else {
                return match(as, ai + 1, bs, bi + 1);
            }
        } else {
            if (isStarLetter(bs, bi)) {
                return match(as, ai, bs, bi + 2);
            } else {
                return false;
            }
        }
    }

    private boolean isStarLetter(char[] a, int i) {
        return i + 1 < a.length && a[i + 1] == '*';
    }
}