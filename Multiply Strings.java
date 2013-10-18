/**
 * @time: 2013-08-30
 */
public class Solution {
    public String multiply(String num1, String num2) {
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        reverse(cs1);
        reverse(cs2);
        char[] cs = mul(cs1, cs2);
        reverse(cs);
        
        int n = cs.length;
        int start = 0;
        for(;start < n - 1 && cs[start] == '0'; start++)
            ;
        return new String(cs, start, n - start);
    }
    
    private char[] mul(char[] cs1, char[] cs2){
        int n1 = cs1.length;
        int n2 = cs2.length;
        int n = n1 + n2;
        char[] cs = new char[n];
        Arrays.fill(cs, '0');
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                int val = (cs1[i] - '0') * (cs2[j] - '0') + cs[i + j] - '0';
                cs[i + j] = (char) (val % 10 + '0');
                if(i + j + 1 < n)
                    cs[i + j + 1] += val / 10;
            }
        }
        return cs;
    }
    
    private void reverse(char[] cs){
        int i = 0;
        int j = cs.length - 1;
        while(i < j){
            swap(cs, i++, j--);
        }
    }
    
    private void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}

public class Solution {
    public String multiply(String num1, String num2) {
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        offset(cs1, -'0');
        offset(cs2, -'0');
        char[] cs3 = mul(cs1, cs2);
        offset(cs3, '0');
        return getTrimString(cs3);
    }
    
    private String getTrimString(char[] cs){
        int n = cs.length;
        int i = 0;
        while(i < n - 1 && cs[i] == '0'){
            i++;
        }
        return new String(cs, i, n - i);
    }
    
    private char[] mul(char[] cs1, char[] cs2){
        int n1 = cs1.length;
        int n2 = cs2.length;
        char[] cs3 = new char[n1 + n2 + 1];
        reverse(cs1);
        reverse(cs2);
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                cs3[i + j] += cs1[i] * cs2[j];
                cs3[i + j + 1] += (char)(cs3[i + j] / 10);
                cs3[i + j] = (char)(cs3[i + j] % 10);
            }
        }
        reverse(cs3);
        return cs3;
    }
    
    private void reverse(char[] cs){
        int i = 0, j = cs.length - 1;
        while(i < j){
            swap(cs, i++, j--);
        }
    }
    
    private void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
    
    private void offset(char[] cs, int offset){
        for(int i = 0; i < cs.length; i++){
            cs[i] += (char)offset;
        }
    }
}