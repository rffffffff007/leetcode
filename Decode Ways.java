/**
 * @time: 2013-08-27
 */
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs = s.toCharArray();
        int n = cs.length;
        if(n == 0)
            return 0;
        int[] ways = new int[n];
        for(int i = 0; i < n; i++){
            if(isLetter1(cs[i])){
                if(i > 0)
                    ways[i] += ways[i - 1];
                else
                    ways[i] += 1;
            }
            if(i >= 1 && isLetter2(cs[i - 1], cs[i])){
                if(i >= 2)
                    ways[i] += ways[i - 2];
                else
                    ways[i] += 1;
            }
        }
        return ways[n - 1];
    }
    
    private boolean isLetter1(char a){
        return a != '0';
    }
    
    private boolean isLetter2(char a, char b){
        if(a == '0')
            return false;
        if(a == '1')
            return true;
        else if(a == '2')
            return b <= '6';
        return false;
    }
}

public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs = s.toCharArray();
        if (cs.length == 0)
            return 0;
        int[] num = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            if (validChar(cs[i])) {
                num[i] += i > 0 ? num[i - 1] : 1;
            }
            if (valid2Char(cs, i)) {
                num[i] += i > 1 ? num[i - 2] : 1;
            }
        }
        return num[cs.length - 1];
    }

    private boolean validChar(char c) {
        return c >= '1' && c <= '9';
    }

    private boolean valid2Char(char[] c, int i) {
        int len = c.length;
        if (i < 1 || len < 2)
            return false;
        return c[i - 1] == '1' && c[i] >= '0' && c[i] <= '9' || c[i - 1] == '2'
                && c[i] >= '0' && c[i] <= '6';
    }
}