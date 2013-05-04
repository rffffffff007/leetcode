public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] ori = new char[] { '1' };
        StringBuffer sb = null;
        for (int i = 1; i < n; i++) {
            sb = new StringBuffer();
            int len = ori.length;
            int begin = 0;
            for (int j = 1; j < len; j++) {
                if (ori[j] != ori[begin]) {
                    sb.append("" + (j - begin));
                    sb.append(ori[begin]);
                    begin = j;
                }
            }
            if (begin < len) {
                sb.append("" + (len - begin));
                sb.append(ori[begin]);
            }
            ori = sb.toString().toCharArray();
        }
        return new String(ori);
    }
}