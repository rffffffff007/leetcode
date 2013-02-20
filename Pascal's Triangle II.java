public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int k = rowIndex;
		Integer[] rowa = new Integer[k + 1];
		Integer[] rowb = new Integer[k + 1];
		Integer[] row1 = null, row2 = null;
		for (int i = 0; i <= k; i++) {
			if (i % 2 == 0) {
				row1 = rowa;
				row2 = rowb;
			} else {
				row1 = rowb;
				row2 = rowa;
			}
			row2[0] = row2[i] = 1;
			for (int j = 1; j < i; j++) {
				row2[j] = row1[j] + row1[j - 1];
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.addAll(Arrays.asList(row2));
		return res;
	}
}