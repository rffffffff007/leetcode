/**
 * @time: 2013-08-29
 * time complexity: O(n)
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> posMap = new HashMap<Character, Integer>();
        // subStart[i] = the start pos of longest substring end at i
        int[] subStart = new int[n];
        
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(!posMap.containsKey(c)){
                subStart[i] = i > 0 ? subStart[i - 1] : 0;
            } else {
                int lastPos = posMap.get(c);
                subStart[i] = lastPos + 1;
                
                // Clear removed character.
                for(int j = subStart[i - 1]; j < subStart[i]; j++){
                    posMap.remove(s.charAt(j));
                }
            }
            posMap.put(c, i);
            maxLen = Math.max(maxLen, i - subStart[i] + 1);
        }
        return maxLen;
    }   
}

/**
 * O(n^2)
 */
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