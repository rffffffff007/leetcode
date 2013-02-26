public class Solution {
    public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = new int[2];
		res[0] = searchRange(A, target, 0, A.length, true);
		res[1] = searchRange(A, target, 0, A.length, false);
		return res;
	}

	private int searchRange(int[] a, int target, int s, int e, boolean leftMost) {
		if (e == s) {
			return -1;
		}
		int mid = (e + s) / 2;
		if (a[mid] > target) {
			return searchRange(a, target, s, mid, leftMost);
		} else if (a[mid] < target) {
			return searchRange(a, target, mid + 1, e, leftMost);
		} else {
			if (leftMost) {
				if (mid == 0 || a[mid] != a[mid - 1]) {
					return mid;
				} else {
					return searchRange(a, target, s, mid, leftMost);
				}
			} else {
				if (mid == a.length - 1 || a[mid] != a[mid + 1]) {
					return mid;
				} else {
					return searchRange(a, target, mid + 1, e, leftMost);
				}
			}
		}
	}
}