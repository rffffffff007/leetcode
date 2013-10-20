public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        int n = s.length();
        // Use dp to get all the palindrome
        ArrayList<ArrayList<Integer>> prevsList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> curPrevs = new ArrayList<Integer>();
            prevsList.add(curPrevs);
            curPrevs.add(i);
            if (i > 0) {
                if (s.charAt(i - 1) == s.charAt(i))
                    curPrevs.add(i - 1);
                for (int prev : prevsList.get(i - 1)) {
                    if (prev > 0 && s.charAt(prev - 1) == s.charAt(i))
                        curPrevs.add(prev - 1);
                }
            }
        }
        // Use backtracking to get the results.
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        searchResult(s, n - 1, prevsList, res, new ArrayList<String>());
        return res;
    }

    private void searchResult(String s, int curIndex,
            ArrayList<ArrayList<Integer>> prevsList,
            ArrayList<ArrayList<String>> res, ArrayList<String> list) {
        if (curIndex < 0) {
            ArrayList<String> curList = new ArrayList<String>();
            curList.addAll(list);
            Collections.reverse(curList);
            res.add(curList);
            return;
        }
        ArrayList<Integer> prevs = prevsList.get(curIndex);
        for (Integer prev : prevs) {
            list.add(s.substring(prev, curIndex + 1));
            searchResult(s, prev - 1, prevsList, res, list);
            list.remove(list.size() - 1);
        }
    }
}