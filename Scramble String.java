public class Solution {

    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        return isScramble(s1.toCharArray(), 0, n1, s2.toCharArray(), 0, n2);
    }

    private boolean isScramble(char[] s1, int beg1, int end1, char[] s2,
            int beg2, int end2) {
        int n = end1 - beg1;
        if (n == 1) {
            return s1[beg1] == s2[beg2];
        }
        CountMap map1 = new CountMap();
        CountMap map2 = new CountMap();

        for (int i = 0; i < n - 1; i++) {
            map1.add(s1[beg1 + i]);
            map2.add(s2[beg2 + i]);
            if (map1.equals(map2)) {
                boolean a1 = isScramble(s1, beg1, beg1 + i + 1, s2, beg2, beg2
                        + i + 1);
                boolean b1 = isScramble(s1, beg1 + i + 1, end1, s2, beg2 + i
                        + 1, end2);
                if (a1 && b1) {
                    return true;
                }
            }
        }

        map1.clear();
        map2.clear();
        for (int i = 0; i < n - 1; i++) {
            map1.add(s1[beg1 + i]);
            map2.add(s2[end2 - 1 - i]);
            if (map1.equals(map2)) {
                boolean a2 = isScramble(s1, beg1, beg1 + i + 1, s2, end2 - 1
                        - i, end2);
                boolean b2 = isScramble(s1, beg1 + i + 1, end1, s2, beg2, end2
                        - 1 - i);
                if (a2 && b2) {
                    return true;
                }
            }
        }
        return false;
    }

    class CountMap extends HashMap<Character, Integer> {
        public void add(Character c) {
            Integer count = get(c);
            if (count == null) {
                put(c, 1);
            } else {
                put(c, count + 1);
            }
        }
    }
}