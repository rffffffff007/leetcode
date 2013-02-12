public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = digits.length;
        int[] res = new int[len + 1];
        reverse(digits, 0, len - 1);
        int[] one = new int[]{1};
        
        plus(digits, one, res);
        reverse(res, 0, res.length - 1);
        if(res[0] == 0){
            int[] tmp = new int[len];
            System.arraycopy(res, 1, tmp, 0, len);
            res = tmp;
        }
        return res;
    }

    public void plus(int[] a, int[] b, int[] c){
        int lena = a.length;
        int lenb = b.length;
        for(int i = 0; i < lena; i++){
            c[i] += a[i] + (i < lenb ? b[i] : 0);
            c[i + 1] += c[i] / 10;
            c[i] %= 10;
        }
    }
    
    public void reverse(int[] n, int s, int e){
        for(; s < e; s++, e--){
            swap(n, s, e);
        }
    }
    
    public void swap(int[] n, int i, int j){
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }
}