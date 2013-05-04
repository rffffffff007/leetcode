public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return pow(x, (long)n);
    }
    
    private double pow(double x, long n){
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 1 / pow(x, -n);
        }else{
            double p = pow(x, n / 2);
            return p * p * (n % 2 == 0 ? 1 : x);
        }
    }
}