public class Solution {
    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            sum *= 10;
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}