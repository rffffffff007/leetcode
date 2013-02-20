public class Solution {
    public int trap(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int[] maxL = new int[n];
		int[] maxR = new int[n];
		for (int i = 0; i < n; i++) {
			maxL[i] = i == 0 ? A[i] : Math.max(maxL[i - 1], A[i]);
		}
		for (int i = n - 1; i >= 0; i--) {
			maxR[i] = i == n - 1 ? A[i] : Math.max(maxR[i + 1], A[i]);
		}

		int aSum = 0;
		for (int i = 0; i < n; i++) {
			aSum += A[i];
		}

		int waterSum = 0;
		for (int i = 0; i < n; i++) {
			waterSum += Math.min(maxL[i], maxR[i]);
		}
		return waterSum - aSum;
	}

}