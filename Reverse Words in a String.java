public class Solution {
    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }

    private void reverse(char[] cs, int start, int end) {
        int i = start;
        int j = end - 1;
        for (;i < j; i++, j--) {
            swap(cs, i, j);
        }
    }

    private int removeSpace (char[] cs) {
        int j = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ' && (i == 0 || cs[i - 1] == ' ')) {
                continue;
            } else {
                cs[j] = cs[i];
                j++;
            }
        }
        return j;
    }

    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int len = removeSpace(cs);
        reverse(cs, 0, len);
        int wordStart = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || cs[i] == ' ') {
                reverse(cs, wordStart, i);
                wordStart = i + 1;
            }
        }
        String res = new String(cs, 0, len);
        return res.trim();
    }
}

