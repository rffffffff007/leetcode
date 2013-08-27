/**
 * @time: 2013-08-27
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combine(n, k, 0, new Integer[k], result);
        return result;
    }
    
    private void combine(int n, int k, int step, Integer[] choices, ArrayList<ArrayList<Integer>> result){
        if(k == step){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(Arrays.asList(choices));
            result.add(list);
            return;
        } 
        int start = 1;
        if(step > 0)
            start = choices[step - 1] + 1;
        for(int i = start; i <= n; i++){
            choices[step] = i;
            combine(n, k, step + 1, choices, result);
        }
    }
}

/**
 * Time complexity = O(C(n, k) * k)
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Integer[] a = new Integer[k];
        for (int i = 0; i < k; i++) {
            a[i] = i + 1;
        }
        do {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(Arrays.asList(a));
            res.add(list);
        } while (add(a, n));
        return res;
    }

    private boolean add(Integer[] a, int n) {
        int k = a.length;
        int i = k - 1;
        while (i >= 0 && a[i] == n - k + i + 1) {
            i--;
        }
        if (i < 0)
            return false;
        a[i]++;
        for (int j = i + 1; j < k; j++) {
            a[j] = a[i] + j - i;
        }
        return true;
    }
}