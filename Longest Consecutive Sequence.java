public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }
        int max = 0;
        for (int i : num) {
            max = Math.max(max, getCount(set, i));
        }
        return max;
    }

    private int getCount(Set<Integer> set, int i) {
        int count = 1;
        int k = i;
        while (set.contains(--k)) {
            set.remove(k);
            count++;
        }
        k = i;
        while (set.contains(++k)) {
            set.remove(k);
            count++;
        }
        return count;
    }
}