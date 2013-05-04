public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = triangle.size();
        if(n == 0){
            return 0;
        }
        Integer[] rowMin1 = new Integer[n];
        Integer[] rowMin2 = new Integer[n];
        Integer[] lastRow = triangle.get(n - 1).toArray(new Integer[]{});
        System.arraycopy(lastRow, 0, rowMin2, 0, lastRow.length);
        for(int i = n - 2; i >= 0; i--){
            List<Integer> row = triangle.get(i);
            for(int j = 0; j <= i; j++){
                int min = Math.min(rowMin2[j], rowMin2[j + 1]);
                rowMin1[j] = min + row.get(j);
            }
            Integer[] tmp = rowMin2;
            rowMin2 = rowMin1;
            rowMin1 = tmp;
        }
        return rowMin2[0];
    }
}