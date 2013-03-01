public class Solution {
    public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int offset = 0;
		for (offset = 1; offset < n; offset++) {
			if (A[offset] < A[offset - 1]) {
				break;
			}
		}
		return bsearch(A, target, 0, n, offset);
	}

	private int bsearch(int[] A, int target, int s, int e, int offset) {
		if (s == e) {
			return -1;
		}
		int n = A.length;
		int mid = (s + e) / 2;
		int midVal = A[(mid + offset) % n];
		if (midVal < target) {
			return bsearch(A, target, mid + 1, e, offset);
		} else if (midVal > target) {
			return bsearch(A, target, s, mid, offset);
		} else {
			return (mid + offset) % n;
		}
	}

}