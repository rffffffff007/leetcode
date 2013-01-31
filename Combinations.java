public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Integer[] a = new Integer[k];
		for (int i = 0; i < k; i++) {
			a[i] = i + 1;
		}
		do {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.addAll(Arrays.asList(a));
			res.add(list);
		} while (add(a, n));
		return res;
	}

	private boolean add(Integer[] a, int n) {
		int k = a.length;
		int i = k - 1;
		while (i >= 0 && a[i] == n - k + i + 1) {
			i--;
		}
		if (i < 0)
			return false;
		a[i]++;
		for (int j = i + 1; j < k; j++) {
			a[j] = a[i] + j - i;
		}
		return true;
	}
}

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		dfs(new ArrayList<Integer>(), n, k, res);
		return res;
	}

	private void dfs(List<Integer> a, int n, int k,
			ArrayList<ArrayList<Integer>> res) {
		if (a.size() == k) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.addAll(a);
			res.add(list);
			return;
		}
		int i = 1;
		if (a.size() > 0) {
			i = a.get(a.size() - 1) + 1;
		}
		for (; i <= n; i++) {
			a.add(i);
			dfs(a, n, k, res);
			a.remove(a.size() - 1);
		}
	}
}