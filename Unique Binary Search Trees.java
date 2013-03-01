public class Solution {
    public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 1) {
			return 1;
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += numTrees(i - 1) * numTrees(n - i);
		}
		return sum;
	}
}