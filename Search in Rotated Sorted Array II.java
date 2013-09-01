/**
 * @time: 2013-09-01
 */ 
public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int offset = searchOffset(A, 0, n);
        int res = bsearch(A, target, 0, n, offset);
        return res != -1;
    }

    private int searchOffset(int[] a, int s, int e) {
        int len = e - s;
        if (len <= 1 || a[s] < a[e - 1]) {
            return s;
        } else if (len == 2) {
            return s + (a[s] > a[e - 1] ? 1 : 0);
        }

        int mid = (s + e) / 2;
        if (a[s] > a[mid])
            return searchOffset(a, s, mid + 1);
        else if (a[s] < a[mid])
            return searchOffset(a, mid + 1, e);
        else {
            int res = searchOffset(a, s + 1, e);
            if (res == s + 1)
                res = s;
            return res;
        }
    }

    private int bsearch(int[] a, int target, int s, int e, int offset) {
        if (s == e) {
            return -1;
        }
        int n = a.length;
        int mid = (s + e) / 2;
        int midVal = a[(mid + offset) % n];
        if (midVal == target) {
            return mid;
        } else if (target > midVal) {
            return bsearch(a, target, mid + 1, e, offset);
        } else {
            return bsearch(a, target, s, mid, offset);
        }
    }
}