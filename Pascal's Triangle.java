public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numRows; i++){
            Integer[] row = new Integer[i + 1];
            row[0] = row[i] = 1;
            if(i > 0){
                ArrayList<Integer> last = res.get(i - 1);
                for(int j = 1; j < i; j++)
                    row[j] = last.get(j) + last.get(j - 1);
            }
            res.add(new ArrayList<Integer>(Arrays.asList(row)));
        }
        return res;
    }
}