public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
        Integer[] n = new Integer[len];
        for (int i = 0; i < len; i++) {
            n[i] = i;
        }
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        do {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (Integer i : n) {
                list.add(num[i]);
            }
            set.add(list);
        } while (nextPermutation(n));
        res.addAll(set);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i) != b.get(i)) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            }
        });
        return res;
    }

    private boolean nextPermutation(Integer[] n) {
        int len = n.length;
        int i = len - 2;
        for (; i >= 0; i--) {
            if (n[i] < n[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            return false;
        }
        int minj = -1;
        for (int j = i + 1; j < len; j++) {
            if (n[j] > n[i] && (minj == -1 || n[j] < n[minj])) {
                minj = j;
            }
        }
        swap(n, i, minj);
        reverse(n, i + 1, len - 1);
        return true;
    }

    private void reverse(Integer[] n, int s, int e) {
        for (; s < e; s++, e--) {
            swap(n, s, e);
        }
    }

    private void swap(Integer[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }
}