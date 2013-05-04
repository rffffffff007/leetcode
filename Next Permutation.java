public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        int descI = n - 1;
        // find the top index of the last desc sub array .
        for (; descI > 0 && num[descI - 1] >= num[descI]; descI--)
            ;
        // find the min value in sub array which is bigger than num[descI - 1]
        // and swap them.
        if (descI > 0) {
            for (int i = n - 1; i >= descI; i--) {
                if (num[i] > num[descI - 1]) {
                    swap(num, i, descI - 1);
                    break;
                }
            }
        }

        // reverse the sub array.
        reverse(num, descI, n - 1);
    }

    private void reverse(int[] n, int a, int b) {
        while (a < b) {
            swap(n, a++, b--);
        }
    }

    private void swap(int[] n, int a, int b) {
        int tmp;
        tmp = n[b];
        n[b] = n[a];
        n[a] = tmp;
    }

}