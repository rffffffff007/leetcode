/**
 * @time: 2013-08-29
 * time cost: O(n^2)
 */
public class Solution {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        
        int maxLen = 0;
        int maxI = 0;
        
        for(int i = 0; i < n; i++){
            for(int offset = 0; offset <= 1; offset++){
                int left = i;
                int right = i + offset;
                
                while(left >= 0 && right < n && cs[left] == cs[right]){
                    left--;
                    right++;
                }
                left++;
                right--;
                int len = right - left + 1;
                if(len > maxLen){
                    maxLen = len;
                    maxI = left;
                }
            }
        }
        return s.substring(maxI, maxI + maxLen);
    }
}
