/**
 * @time: 2013-09-02
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        allSubsets(S, 0, new LinkedList<Integer>(), result);
        return result;
    }
    
    private void allSubsets(int[] s, int k, LinkedList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(k == s.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        allSubsets(s, k + 1, list, result);
        list.addLast(s[k]);
        allSubsets(s, k + 1, list, result);
        list.removeLast();
    }
}