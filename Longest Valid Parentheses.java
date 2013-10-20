public class Solution {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') {
                stack.push(i);
            } else if (stack.size() > 0) {
                stack.pop();
                size += 2;
                if (stack.size() == 0) 
                    max = Math.max(max, size);
            } else {
                size = 0;
            }
        }
        int last = n;
        while (stack.size() > 0) {
            int pop = stack.pop();
            int interval = last - 1 - pop;
            max = Math.max(max, interval);
            last = pop;
        }
        return max;
    }
}

public class Solution {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') 
                left++;
            else 
                right++;
            if (left == right) 
                max = Math.max(max, left + right);
            else if (right > left) 
                left = right = 0;
        }

        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cs[i] == '(') 
                left++;
            else 
                right++;
            if (left == right) 
                max = Math.max(max, left + right);
            else if (left > right) 
                left = right = 0;
        }
        return max;
    }
}

public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int j = i + 1 + dp[i + 1];
                if (j < n && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    if (j + 1 < n) 
                        dp[i] += dp[j + 1];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}