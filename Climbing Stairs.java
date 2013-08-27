public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 2){
            return 1;
        }
        
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i = 2; i <= n; i++){
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
}
/**
 * @time: 2013-08-27
 */
public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        int a0 = 1;
        int a1 = 1;
        for(int i = 2; i <= n; i++){
            int a = a0 + a1;
            a0 = a1;
            a1 = a;
        }
        return a1;
    }
}