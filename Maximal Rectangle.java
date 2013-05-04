public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;
        int[] histogram = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                } else {
                    histogram[j]++;
                }
            }
            int area = maxRectInHistogram(histogram);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int maxRectInHistogram(int[] h) {
        int n = h.length;
        int[] hStack = new int[n];
        int[] leftWidth = new int[n];
        int top = 0;
        int maxRect = 0;
        int widthSum = 0;
        for (int i = 0; i < n; i++) {
            if (top == 0 || h[i] > hStack[top - 1]) {
                hStack[top] = h[i];
                leftWidth[top] = 1;
                top++;
            } else {
                widthSum = 0;
                while (top > 0 && hStack[top - 1] >= h[i]) {
                    widthSum += leftWidth[top - 1];
                    maxRect = Math.max(maxRect, hStack[top - 1] * widthSum);
                    top--;
                }
                hStack[top] = h[i];
                leftWidth[top] = widthSum + 1;
                top++;
            }
        }
        widthSum = 0;
        while (top > 0) {
            widthSum += leftWidth[top - 1];
            maxRect = Math.max(maxRect, hStack[top - 1] * widthSum);
            top--;
        }

        return maxRect;
    }
}


public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;
        int[] histogram = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                } else {
                    histogram[j]++;
                }
            }
            int area = maxRectInHistogram(histogram);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int maxRectInHistogram(int[] histogram) {
        Stack<WH> stack = new Stack<WH>();
        int maxRect = 0;
        for (int height : histogram) {
            if (stack.isEmpty() || height > stack.peek().height) {
                stack.push(new WH(height, 1));
            } else {
                maxRect = Math.max(maxRect, maxRectInStack(stack, height));
            }
        }
        // empty the stack.
        maxRect = Math.max(maxRect, maxRectInStack(stack, 0));
        return maxRect;
    }

    private int maxRectInStack(Stack<WH> stack, int popHeight) {
        int widthSum = 0;
        int maxRect = 0;
        while (!stack.isEmpty() && stack.peek().height >= popHeight) {
            WH wh = stack.pop();
            widthSum += wh.width;
            maxRect = Math.max(maxRect, wh.height * widthSum);
        }
        stack.push(new WH(popHeight, widthSum + 1));
        return maxRect;
    }

    class WH {
        int width;
        int height;

        public WH(int h, int w) {
            width = w;
            height = h;
        }
    }
}