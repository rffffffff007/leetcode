public class Solution {
    public int minDistance(String word1, String word2) {
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int len1 = cs1.length;
        int len2 = cs2.length;
        int[][] minDis = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                int dis = Integer.MAX_VALUE;
                // Delete cs1[i]
                dis = Math.min(dis, dist(minDis, i - 1, j) + 1);
                // Insert cs2[j] to cs1[i + 1]
                dis = Math.min(dis, dist(minDis, i, j - 1) + 1);
                // Replace cs1[i] to cs2[j]
                dis = Math.min(dis, dist(minDis, i - 1, j - 1) + (cs1[i] == cs2[j] ? 0 : 1));
                minDis[i][j] = dis;
            }
        }
        return dist(minDis, len1 - 1, len2 - 1);
    }
    
    private int dist(int[][] min, int i, int j){
        if(i < 0)
            return j + 1;
        else if(j < 0)
            return i + 1;
        else
            return min[i][j];
    }
}