public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] maxLenE = new int[n];
        int[] maxLenI = new int[n];

        for (int i = 0; i < n; i++) {
            maxLenE[i] = getMaxLen(cs, i, false);
            maxLenI[i] = getMaxLen(cs, i, true);
        }

        int max = 0;
        int maxi = 0;
        boolean maxInclude = false;
        for (int i = 0; i < n; i++) {
            if (maxLenE[i] > max) {
                max = maxLenE[i];
                maxi = i;
                maxInclude = false;
            }
            if (maxLenI[i] > max) {
                max = maxLenI[i];
                maxi = i;
                maxInclude = true;
            }
        }

        if (maxInclude) {
            return s.substring(maxi - max / 2 + 1, maxi + max / 2 + 1);
        } else {
            return s.substring(maxi - max / 2, maxi + max / 2 + 1);
        }
    }

    private int getMaxLen(char[] cs, int i, boolean include) {
        int a = i;
        int b = include ? i + 1 : i;
        int len = 0;
        while (a >= 0 && b < cs.length) {
            if (cs[a] == cs[b]){
                len = b - a + 1;
            }else{
                break;   
            }
            a--;
            b++;
        }
        return len;
    }
}