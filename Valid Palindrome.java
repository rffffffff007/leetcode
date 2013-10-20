public class Solution {
    public boolean isPalindrome(String s) {
        char[] cs = s.toLowerCase().toCharArray();
        int a = 0;
        int b = cs.length - 1;
        while(a < b){
            while(a < b && !isLetter(cs[a]))
                a++;
            while(a < b && !isLetter(cs[b]))
                b--;
            if(cs[a] != cs[b])
                return false;
            a++;
            b--;
        }
        return true;
    }
    
    private boolean isLetter(char c){
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
}