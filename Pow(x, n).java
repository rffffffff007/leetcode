public class Solution {
    public double pow(double x, int n) {
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