public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return bsearch(A, 0, A.length, target);
    }

    public int bsearch(int[] a, int s, int e, int target) {
        if (target < a[s])
            return s;
        else if (target > a[e - 1]) {
            return e;
        }
        if (s + 1 == e) {
            if (a[s] == target) {
                return s;
            } else {
                return e;
            }
        }

        int mid = (s + e) / 2;
        if (target < a[mid]) {
            return bsearch(a, s, mid, target);
        } else if (target > a[mid]) {
            return bsearch(a, mid, e, target);
        } else {
            return mid;
        }
    }
}