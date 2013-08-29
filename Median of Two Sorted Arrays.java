/**
 * @time: 2013-08-29
 * O(log(m) + log(n)))
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if ((n + m) % 2 == 0) {
            return (getMedian(A, 0, m, B, 0, n, (m + n) / 2) + getMedian(A, 0,
                    m, B, 0, n, (m + n) / 2 + 1)) / 2.0;
        } else
            return getMedian(A, 0, m, B, 0, n, (m + n) / 2 + 1);
    }

    private int getMedian(int a[], int as, int ae, int b[], int bs, int be,
            int k) {
        int n = ae - as;
        int m = be - bs;
        if (n <= 0)
            return b[bs + k - 1];
        if (m <= 0)
            return a[as + k - 1];
        if (k <= 1)
            return Math.min(a[as], b[bs]);
        int n2 = n / 2;
        int m2 = m / 2;
        if (b[bs + m / 2] >= a[as + n / 2]) {
            if (n2 + m2 + 1 >= k)
                return getMedian(a, as, ae, b, bs, bs + m2, k);
            else
                return getMedian(a, as + n2 + 1, ae, b, bs, be, k - n2 - 1);
        } else {
            if (n2 + m2 + 1 >= k)
                return getMedian(a, as, as + n2, b, bs, be, k);
            else
                return getMedian(a, as, ae, b, bs + m2 + 1, be, k - m2 - 1);
        }
    }
}

/**
 * O(log(m + n))
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length;
        int n = B.length;
        int median1 = (m + n) / 2 + 1;
        int median2 = (m + n - 1) / 2 + 1;
        return (findKth(A, 0, m, B, 0, n, median1) + findKth(A, 0, m, B, 0, n,
                median2)) / 2f;
    }

    private int findKth(int a[], int as, int ae, int b[], int bs, int be, int k) {
        int m = ae - as;
        int n = be - bs;
        if (m == 0) {
            return b[bs + k - 1];
        } else if (n == 0) {
            return a[as + k - 1];
        }
        if (m == 1 && n == 1) {
            if (k == 1) {
                return Math.min(a[as], b[bs]);
            } else {
                return Math.max(a[as], b[bs]);
            }
        }
        if (k == m + n) {
            return Math.max(a[ae - 1], b[be - 1]);
        }
        float ratio = k * m * 1f / (m + n);
        int i = Math.round(m * ratio);
        i = fit(i, 0, m - 1);
        i = fit(i, k - 1 - n, k - 1);
        int j = k - 1 - i;
        if (a[as + i] > b[bs + j]) {
            return findKth(a, as, as + i, b, bs + j, be, k - j);
        } else {
            return findKth(a, as + i, ae, b, bs, bs + j, k - i);
        }
    }

    private int fit(int a, int lower, int upper) {
        if (a < lower)
            return lower;
        else if (a > upper)
            return upper;
        else
            return a;
    }
}