public class Solution {
    public String strStr(String haystack, String needle) {
        int index = 0;
        String s1 = haystack;
        String s2 = needle;
        int len1 = s1.length();
        int len2 = s2.length();
        int p = 0;
        int q = 0;
        boolean founded = false;
        while(index <= len1 - len2 && q < len2){
            if(s1.charAt(p) != s2.charAt(q)){
                p = ++index;
                q = 0;
            }else{
                p++;
                q++;
            }
        }
        if(index >= 0 && q == len2)
            return haystack.substring(index);
        return null;
    }
}