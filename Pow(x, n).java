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

public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0){
            return 1;
        } else if( n == 1){
            return x;
        } else if (n == -1){
            return 1 / x;
        } else{
            double half = pow(x, n / 2);
            return half * half * pow(x, n % 2);
        }
    }
}