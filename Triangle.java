public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int[] min = new int[n + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                min[j] = Math.min(min[j], min[j + 1]);
                min[j] += triangle.get(i).get(j);
            }
        }
        return min[0];
    }
}