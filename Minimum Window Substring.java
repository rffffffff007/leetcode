/**
 * @time: 2013-08-30
 * O(n)
 */
public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lens = S.length();
        int lent = T.length();

        Map<Character, Integer> freqT = new HashMap<Character, Integer>();
        Map<Character, Integer> freqS = new HashMap<Character, Integer>();
        Set<Character> unmatchSet = new HashSet<Character>();

        for (int i = 0; i < lent; i++) {
            char ct = T.charAt(i);
            increase(freqT, ct);
            unmatchSet.add(ct);
        }

        int minWinStart = -1;
        int minWinLen = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < lens; i++) {
            char cs = S.charAt(i);
            increase(freqS, cs);
            if (unmatchSet.contains(cs) && valDiff(freqS, freqT, cs) >= 0) {
                unmatchSet.remove(cs);
            }
            while (start <= i && unmatchSet.size() == 0) {
                int len = i - start + 1;
                if (len < minWinLen) {
                    minWinLen = len;
                    minWinStart = start;
                }
                char cstart = S.charAt(start);
                decrease(freqS, cstart);
                if (valDiff(freqS, freqT, cstart) < 0) {
                    unmatchSet.add(cstart);
                }
                start++;
            }
        }
        if (minWinStart == -1)
            return "";
        return S.substring(minWinStart, minWinStart + minWinLen);
    }

    private int valDiff(Map<Character, Integer> map1,
            Map<Character, Integer> map2, char c) {
        int v1 = 0;
        if (map1.containsKey(c))
            v1 = map1.get(c);
        int v2 = 0;
        if (map2.containsKey(c))
            v2 = map2.get(c);
        return v1 - v2;
    }

    private void increase(Map<Character, Integer> map, char c) {
        if (map.containsKey(c))
            map.put(c, map.get(c) + 1);
        else
            map.put(c, 1);
    }

    private void decrease(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            int val = map.get(c);
            if (val <= 1)
                map.remove(c);
            else
                map.put(c, val - 1);
        }
    }
}