/**
 * @time: 2013-08-31
 * time complexity = O(n^2)
 * could calculate all C(n, k) to get the array, time complexity will be O(n)
 */
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int k = rowIndex;
        Integer[] rowa = new Integer[k + 1];
        Integer[] rowb = new Integer[k + 1];
        Integer[] tmp;
        for (int i = 0; i <= k; i++) {
            rowb[0] = rowb[i] = 1;
            for(int j = 1; j < i; j++){
                rowb[j] = rowa[j] + rowa[j - 1];
            }
            tmp = rowa;
            rowa = rowb;
            rowb = tmp;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.addAll(Arrays.asList(rowa));
        return res;
    }
}

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int k = rowIndex;
        int[] row = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            row[0] = row[i] = 1;
            for (int j = i - 1; j > 0; j--)
                row[j] = row[j] + row[j - 1];
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i : row)
            res.add(i);
        return res;
    }
}