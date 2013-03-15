public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = s.length();
		ArrayList<ArrayList<Integer>> dpList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			dpList.add(list);
			for (int j = i; j >= 0; j--) {
				if (isPalindrome(s, j, i)) {
					list.add(j - 1);
				}
			}
		}
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		searchResult(s, n - 1, dpList, res, new ArrayList<String>());
		return res;
	}

	private void searchResult(String s, int curIndex,
			ArrayList<ArrayList<Integer>> dpList,
			ArrayList<ArrayList<String>> res, ArrayList<String> list) {
		if (curIndex < 0) {
			ArrayList<String> curList = new ArrayList<String>();
			curList.addAll(list);
			Collections.reverse(curList);
			res.add(curList);
			return;
		}
		ArrayList<Integer> prevIndexes = dpList.get(curIndex);
		for (Integer prevIndex : prevIndexes) {
			list.add(s.substring(prevIndex + 1, curIndex + 1));
			searchResult(s, prevIndex, dpList, res, list);
			list.remove(list.size() - 1);
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}