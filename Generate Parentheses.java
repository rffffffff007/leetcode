/**
 * @time: 2013-08-23
 */
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        generate(n, 0, 0, new char[2 * n], result);
        return result;
    }

    private void generate(int n, int left, int right, char[] array,
            ArrayList<String> result) {
        int k = left + right;
        if (k == n * 2) {
            result.add(new String(array));
            return;
        }
        if (left < n) {
            array[k] = '(';
            generate(n, left + 1, right, array, result);
        }

        if (right < left) {
            array[k] = ')';
            generate(n, left, right + 1, array, result);
        }

    }
}

/**
 * @time: 2013-09-13
 * It's a application of Catalan Number.
 */
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        ArrayList<String> empty = new ArrayList<String>();
        empty.add("");
        results.add(empty);
        for(int i = 1; i <= n; i++){
            ArrayList<String> next = new ArrayList<String>();
            results.add(next);
            for(int j = 0; j < i; j++){
                for(String left : results.get(j)){
                    for(String right : results.get(i - 1 - j)){
                        next.add('(' + left + ')' + right);
                    }
                }
            }
        }
        return results.get(n);
    }
}