public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 0){
            return 1 / pow(x, -n);
        }
        if(n == 0){
            return 1;
        }
        double p = pow(x, n / 2);
        if(n % 2 == 0){
            return p * p;
        }else{
            return p * p * x;
        }
    }
}