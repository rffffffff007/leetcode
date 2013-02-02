public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while(j >= i){
            int area = calArea(height, i, j);
            if(area > max){
                max = area;
            }
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
    
    private int calArea(int[] h, int i, int j){
        return (j - i) * Math.min(h[i], h[j]);
    }
}