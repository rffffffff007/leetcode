public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = triangle.size();
		int[] mina = new int[n];
		int[] minb = new int[n];
		int max = Integer.MAX_VALUE;
		int v1, v2, val;
		for (int i = 0; i < n; i++) {
			List<Integer> row = triangle.get(i);
			if (i % 2 == 0) {
				Arrays.fill(mina, max);
			} else {
				Arrays.fill(minb, max);
			}
			for (int j = 0; j <= i; j++) {
				if (i == 0) {
					mina[0] = row.get(0);
				} else if (i % 2 == 0) {
					v1 = j < i ? minb[j] : max;
					v2 = j > 0 ? minb[j - 1] : max;
					val = Math.min(v1, v2) + row.get(j);
					mina[j] = Math.min(val, mina[j]);
				} else {
					v1 = j < i ? mina[j] : max;
					v2 = j > 0 ? mina[j - 1] : max;
					val = Math.min(v1, v2) + row.get(j);
					minb[j] = Math.min(val, minb[j]);
				}
			}
		}
		int[] minc;
		if (n % 2 != 0) {
			minc = mina;
		} else {
			minc = minb;
		}
		int min = max;
		for (Integer m : minc) {
			min = Math.min(min, m);
		}
		return min;
	}
    
}