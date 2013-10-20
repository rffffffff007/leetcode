/**
 * @time: 2013-09-01
 * O(log(n))
 */
public class Solution {
    public int search(int[] A, int target) {
        int n = A.length;
        int offset = searchOffset(A, 0, n);
        int res = bsearch(A, target, 0, n, offset);
        if(res != -1)
            res = (res + offset) % n;
        return res;
    }

    private int searchOffset(int[] a, int s, int e) {
        int len = e - s;
        if (len <= 1 || a[s] < a[e - 1]) 
            return s;

        int mid = (s + e - 1) / 2;
        if (a[s] > a[mid])
            return searchOffset(a, s, mid + 1);
        else
            // a[mid] >= a[e - 1]
            return searchOffset(a, mid + 1, e);
    }

    private int bsearch(int[] a, int target, int s, int e, int offset) {
        if (s == e) 
            return - 1;
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