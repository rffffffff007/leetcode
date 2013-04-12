public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length();
        int len2 = s2.length();
        int len = s3.length();
        if (len1 + len2 != len) {
            return false;
        }
        return isInter(s1, 0, s1.length(), s2, 0, s2.length(), s3, 0,
                s3.length(), true);
    }

    private boolean isInter(String s1, int a1, int b1, String s2, int a2,
            int b2, String s3, int a3, int b3, boolean forward) {
        if (a3 == b3)
            return true;
        if (a1 < b1) {
            if (forward) {
                if (s1.charAt(a1) == s3.charAt(a3)) {
                    boolean f = isInter(s1, a1 + 1, b1, s2, a2, b2, s3, a3 + 1,
                            b3, !forward);
                    if (f)
                        return true;
                }
            } else {
                if (s1.charAt(b1 - 1) == s3.charAt(b3 - 1)) {
                    boolean f = isInter(s1, a1, b1 - 1, s2, a2, b2, s3, a3,
                            b3 - 1, !forward);
                    if (f)
                        return true;
                }
            }
        }

        if (a2 < b2) {
            if (forward) {
                if (s2.charAt(a2) == s3.charAt(a3)) {
                    boolean f = isInter(s1, a1, b1, s2, a2 + 1, b2, s3, a3 + 1,
                            b3, !forward);
                    if (f)
                        return true;
                }
            } else {
                if (s2.charAt(b2 - 1) == s3.charAt(b3 - 1)) {
                    boolean f = isInter(s1, a1, b1, s2, a2, b2 - 1, s3, a3,
                            b3 - 1, !forward);
                    if (f)
                        return true;
                }
            }
        }
        return false;
    }
}