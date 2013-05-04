public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long flaga = dividend > 0 ? 1 : -1;
        long flagb = divisor > 0 ? 1 : -1;
        while ((b << 1) <= a) {
            b <<= 1;
        }
        long c = 0;
        long absDivisor = Math.abs((long) divisor);

        while (b >= absDivisor) {
            c <<= 1;
            while (a >= b) {
                a -= b;
                c += 1;
            }
            b >>= 1;
        }
        return (int) (c * flaga * flagb);
    }



}