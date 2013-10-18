public class Solution {
    public int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int lastSpace = -1;
        int len = cs.length;
        for(; len > 0 && cs[len - 1] == ' '; len--);
        for(int i = 0; i < len; i++)
            if(cs[i] == ' ')
                lastSpace = i;
        return len - lastSpace - 1;
    }
}