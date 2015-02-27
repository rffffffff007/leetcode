public class Solution {
    private long negative(long a) {
        return (a ^ -1) + 1;
    }
    
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        while ((b << 1) <= a) 
            b <<= 1;
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
        c = dividend < 0 ? negative(c) : c;
        c = divisor < 0 ? negative(c) : c;
        c = c > Integer.MAX_VALUE ? Integer.MAX_VALUE : c;
        return (int) c;
    }
}
