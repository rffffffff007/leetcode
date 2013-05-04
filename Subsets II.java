import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(S);
        int n = S.length;
        if (n == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        int[] f = new int[n];
        do {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (f[i] == 1) {
                    list.add(S[i]);
                }
            }
            set.add(list);
        } while (plusOne(f));
        res.addAll(set);
        return res;
    }

    private boolean plusOne(int[] f) {
        f[0] += 1;
        int v;
        for (int i = 0; i < f.length; i++) {
            v = f[i] / 2;
            if (i < f.length - 1) {
                f[i + 1] += v;
            } else if (v == 1) {
                return false;
            }
            f[i] %= 2;
        }
        return true;
    }
}