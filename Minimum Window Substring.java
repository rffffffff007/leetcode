public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (T.length() == 0) {
            return "";
        }
        char[] ss = S.toCharArray();
        char[] ts = T.toCharArray();
        int[] sf = new int[26 * 2];
        int[] tf = new int[26 * 2];

        for (char c : ts) {
            if (isValid(c)) {
                tf[toIndex(c)] += 1;
            }
        }

        int minLen = Integer.MAX_VALUE;
        int minStart = -1;
        int start = 0;
        int index;

        for (int i = 0; i < ss.length; i++) {
            if (isValid(ss[i])) {
                sf[toIndex(ss[i])] += 1;
            }
            for (; start < i; start++) {
                if (!isValid(ss[start])) {
                    continue;
                }
                index = toIndex(ss[start]);
                if (sf[index] <= tf[index] && sf[index] + tf[index] != 0) {
                    break;
                }
                if (sf[index] > tf[index])
                    sf[index]--;
            }

            if (containsAll(sf, tf) && i - start + 1 < minLen) {
                minLen = i - start + 1;
                minStart = start;
            }
        }
        if (minStart < 0) {
            return "";
        } else {
            return S.substring(minStart, minStart + minLen);
        }
    }

    private int toIndex(char c) {
        if (c >= 'a' && c <= 'z')
            return c - 'a';
        else if (c >= 'A' && c <= 'Z')
            return c - 'A' + 26;
        else
            return -1;
    }

    private boolean isValid(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private boolean containsAll(int[] sf, int[] tf) {
        for (int i = 0; i < 52; i++) {
            if (sf[i] < tf[i]) {
                return false;
            }
        }
        return true;
    }
}