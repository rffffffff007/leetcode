public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int len1 = cs1.length;
        int len2 = cs2.length;
        // if (len1 * len2 == 0) {
        // return Math.max(len1, len2);
        // }
        int[][] min = new int[len1][len2];
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                m = Integer.MAX_VALUE;
                m = Math.min(getMinDis(min, i, j - 1) + 1, m);
                m = Math.min(getMinDis(min, i - 1, j) + 1, m);
                m = Math.min(getMinDis(min, i - 1, j - 1)
                        + (cs1[i] == cs2[j] ? 0 : 1), m);
                min[i][j] = m;
            }
        }
        return getMinDis(min, len1 - 1, len2 - 1);
    }

    private int getMinDis(int[][] min, int i, int j) {
        if (j < 0)
            return i + 1;
        if (i < 0)
            return j + 1;
        return min[i][j];
    }
}