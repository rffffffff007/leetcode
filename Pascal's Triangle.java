public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = null;
        int left, right;
        for(int i = 1; i <= numRows; i++){
            row = new ArrayList<Integer>();
            List<Integer> lastRow = res.size() > 0 ? res.get(res.size() - 1) : null;
            for(int j = 0; j < i; j++){
                if(lastRow == null){
                    row.add(1);
                }else {
                    left = j < i - 1 ? lastRow.get(j) : 0;
                    right = j > 0 ? lastRow.get(j - 1) : 0;
                    row.add(left + right);
                }
            }
            res.add(row);
        }
        return res;
    }
}