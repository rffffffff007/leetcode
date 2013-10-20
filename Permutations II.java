public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        do {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i : num)
                list.add(i);
            result.add(list);
        } while (nextPermutation(num));
        return result;
    }

    private boolean nextPermutation(int[] num) {
        int n = num.length;
        int descStart = 0;
        for (int i = n - 1; i > 0; i--) 
            if (num[i] > num[i - 1]) {
                descStart = i;
                break;
            }
        if (descStart == 0)
            return false;
        for (int i = n - 1; i >= descStart; i--) 
            if (num[i] > num[descStart - 1]){
                swap(num, i, descStart - 1);
                break;
            }
        reverse(num, descStart, n - 1);
        return true;
    }

    private void reverse(int[] n, int s, int e) {
        for (; s < e; s++, e--) 
            swap(n, s, e);
    }

    private void swap(int[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }
}