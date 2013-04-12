public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int y = 0;
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        while (x >= y) {
            y *= 10;
            y += x % 10;
            if (x == y) {
                return true;
            }
            x /= 10;
            if (x == y) {
                return true;
            }
        }
        return false;
    }
}