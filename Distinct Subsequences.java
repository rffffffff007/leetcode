/**
 * @time: 2013-08-27
 */
public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs = S.toCharArray();
        char[] ct = T.toCharArray();
        int lens = cs.length;
        int lent = ct.length;
        if(lent == 0)
            return 1;
        if(lens == 0)
            return 0;
        int[][] count = new int[lens][lent];
        for(int i = 0; i < lens; i++){
            for(int j = 0; j < lent; j++){
                if(cs[i] == ct[j]){
                    if(i > 0 && j > 0)
                        count[i][j] += count[i - 1][j - 1];
                    else if(j == 0)
                        count[i][j] += 1;
                }
                if(i > 0)
                    count[i][j] += count[i - 1][j];
                    
            }
        }
        return count[lens - 1][lent - 1];
    }
}

public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        Set<Character> tSet = new HashSet<Character>();
        for(char tc : t){
            tSet.add(tc);
        }
        StringBuffer bufS = new StringBuffer();
        for(char sc : s){
            if(tSet.contains(sc)){
                bufS.append(sc);
            }
        }
        s = bufS.toString().toCharArray();
        int lens = s.length;
        int lent = t.length;
        int[][] num = new int[lens][lent];
        for (int i = 0; i < lens; i++) {
            for (int j = 0; j < lent; j++) {
                if (t[j] == s[i]) {
                    if (j == 0) {
                        num[i][j] = 1;
                    } else {
                        for (int k = i - 1; k >= 0; k--) {
                            num[i][j] += num[k][j - 1];
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < lens; i++) {
            sum += num[i][lent - 1];
        }
        return sum;
    }

}