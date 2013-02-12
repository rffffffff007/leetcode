public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = height.length;
        int[] stack = new int[n];
        int[] widths = new int[n];
        int top = 0;
        int max = 0;
        int w = 0;
        for(Integer h : height){
            if(top == 0 || h > stack[top - 1]){
                stack[top] = h;
                widths[top++] = 1;
            }else{
                w = 0;
                while(top > 0 && h <= stack[top - 1]){
                    w += widths[top - 1];
                    max = Math.max(max, stack[top - 1] * w);
                    top--;
                }
                stack[top] = h;
                widths[top++] = w + 1;
            }
        }
        w = 0;
        while(top > 0){
            w += widths[top - 1];
            max = Math.max(max, stack[top - 1] * w);
            top--;
        }
        return max;
        
    }
}