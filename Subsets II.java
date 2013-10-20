public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        Map<Integer, Integer> freqMap = new TreeMap<Integer, Integer>();
        for (int n : num) {
            if (freqMap.containsKey(n)) {
                freqMap.put(n, freqMap.get(n) + 1);
            } else {
                freqMap.put(n, 1);
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<Integer> freqKeys = new ArrayList<Integer>();
        freqKeys.addAll(freqMap.keySet());
        allSubsets(freqMap, freqKeys, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void allSubsets(Map<Integer, Integer> freqMap, List<Integer> keys,
            int k, List<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (k == keys.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        int num = keys.get(k);
        int freq = freqMap.get(num);
        for (int i = 0; i <= freq; i++) {
            if (i > 0)
                list.add(num);
            allSubsets(freqMap, keys, k + 1, list, result);
        }
        for (int i = 0; i < freq; i++) {
            list.remove(list.size() - 1);
        }
    }
}