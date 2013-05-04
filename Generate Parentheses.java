import java.util.*;
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        List<Character> list = new ArrayList<Character>();
        Set<String> resultSet = new HashSet<String>();
        searchP(n, list, 0, 0, resultSet);
        ArrayList<String> res = new ArrayList<String>();
        res.addAll(resultSet);
        Collections.sort(res);
        return res;
    }

    private void searchP(int n, List<Character> list, int leftCount,
            int rightCount, Set<String> result) {
        if (list.size() == n * 2) {
            Character[] chars = list.toArray(new Character[] {});
            char[] chars2 = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                chars2[i] = chars[i];
            }
            result.add(new String(chars2));
            return;
        }
        if (leftCount < n) {
            list.add('(');
            searchP(n, list, leftCount + 1, rightCount, result);
            list.remove(list.size() - 1);
        }

        if (leftCount > rightCount) {
            list.add(')');
            searchP(n, list, leftCount, rightCount + 1, result);
            list.remove(list.size() - 1);
        }
    }
}