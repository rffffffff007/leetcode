public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double x0 = 1;
        // Newton's method
        for(int i = 0; i < 100; i++){
            x0 = (x0 + x / x0) / 2;
        }
        return (int)Math.floor(x0);
    }
}