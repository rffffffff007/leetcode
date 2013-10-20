public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0)
            return 0;
        int m = matrix[0].length;
        if(m == 0)
            return 0;
            
        int[] height = new int[m];
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0')
                    height[j] = 0;
                else
                    height[j] += 1;
            }
            int area = maxAreaInHistogram(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    
    private int maxAreaInHistogram(int[] height){
        int n = height.length;
        int[] hStack = new int[n];
        int[] wStack = new int[n];
        int top = 0;
        
        int maxArea = 0;
        for(int i = 0; i <= n; i++){
            // when i == n, we just want to clean the stack.
            int widthSum = 0;
            while(top > 0 && (i == n || hStack[top - 1] >= height[i])){
                // pop the stack top to keep the hStack in ascending order.
                top--;
                int h = hStack[top];
                widthSum += wStack[top];
                maxArea = Math.max(maxArea, widthSum * h);
            }
            if(i < n){
                // push to stack.
                hStack[top] = height[i];
                wStack[top++] = widthSum + 1;
            }
        }
        return maxArea;
    }
}