public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        ArrayList<HashSet<Integer>> dpList = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < n; i++) {
            HashSet<Integer> lastSet = i > 0 ? dpList.get(i - 1) : null;
            HashSet<Integer> curSet = new HashSet<Integer>();
            dpList.add(curSet);
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (i - j <= 1 || lastSet != null
                            && lastSet.contains(j + 1)) {
                        curSet.add(j);
                    }
                }
            }
        }
        int[] minCuts = new int[n];
        int min;
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int prevIndex : dpList.get(i)) {
                if (prevIndex > 0) {
                    min = Math.min(min, minCuts[prevIndex - 1] + 1);
                } else {
                    min = 0;
                }
            }
            minCuts[i] = min;
        }
        return minCuts[n - 1];
    }
}