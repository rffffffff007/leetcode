public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int lena = ca.length;
        int lenb = cb.length;
        reverse(ca);
        reverse(cb);
        offset(ca, -'0');
        offset(cb, -'0');
        int lenc = Math.max(lena, lenb) + 1;
        char[] cc = new char[lenc];
        Arrays.fill(cc, '\0');
        add(cc, ca);
        add(cc, cb);
        offset(cc, '0');
        reverse(cc);
        int index = 0;
        while (index < cc.length - 1 && cc[index] == '0') {
            index++;
        }
        return new String(cc, index, cc.length - index);
    }

    private void add(char[] ca, char[] cb) {
        for (int i = 0; i < ca.length - 1; i++) {
            if (i < cb.length) {
                ca[i] += cb[i];
            }
            ca[i + 1] += ca[i] / 2;
            ca[i] %= 2;
        }
    }

    private void offset(char[] c, int value) {
        for (int i = 0; i < c.length; i++) {
            c[i] += value;
        }
    }

    private void reverse(char[] c) {
        int len = c.length;
        char tmp;
        for (int i = 0; i < len / 2; i++) {
            tmp = c[i];
            c[i] = c[len - 1 - i];
            c[len - 1 - i] = tmp;
        }
    }
}