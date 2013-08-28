/**
 * @time: 2013-08-28
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = height.length;
        int stackTop = 0;
        int[] hStack = new int[n];
        int[] bStack = new int[n];
        
        int maxArea = 0;
        for(int i = 0; i <= n; i++){
            int bigItemsCount = 0;
            while(stackTop > 0 &&(i == n || hStack[stackTop - 1] >= height[i])){
                // pop the stack top to main the ascending order in hStack.
                stackTop--;
                int h = hStack[stackTop]
                bitItemsCount += bStack[stackTop];
                maxArea = Math.max(maxArea, h * bigItemsCOunt);
            }
            if(i < n){
                // insert the new item to stack
                hStack[stackTop] = height[i];
                bStack[stackTop++] = bigItemsCount + 1;
            }
        }
        
        return maxArea;
    }
}