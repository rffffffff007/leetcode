public class Solution {
    public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[] cs = s.toCharArray();
		int n = cs.length;
		int[] max = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				max[i] = 1;
			} else {
				int index;
				int lastIndex = i - max[i - 1];
				for (index = i - 1; index >= lastIndex && cs[i] != cs[index]; index--)
					;
				max[i] = i - index;
			}
		}
		int maxLen = 0;
		for (int m : max) {
			maxLen = Math.max(maxLen, m);
		}
		return maxLen;
	}

}