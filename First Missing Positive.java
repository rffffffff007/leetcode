public class Solution {
    public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int INVALID = n + 10;
		// remove the negative numbers and the numbers bigger than n.
		for (int i = 0; i < n; i++) {
			if (A[i] <= 0 || A[i] > n) {
				A[i] = INVALID;
			}
		}

		int m;
		// use A as a hash map to record occurrence.
		for (int i = 0; i < n; i++) {
			m = Math.abs(A[i]);
			if (m > 0 && m - 1 < n && A[m - 1] > 0) {
				A[m - 1] = -A[m - 1];
			}
		}

		// find the first missing number
		int first = 0;
		for (; first < n; first++) {
			if (A[first] > 0) {
				break;
			}
		}
		return first + 1;
	}
}