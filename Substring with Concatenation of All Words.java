public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        int wordsCount = L.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (wordsCount == 0) {
            return res;
        }
        HashMap<String, Integer> lMap = new HashMap<String, Integer>();
        HashMap<String, Integer> curMap = new HashMap<String, Integer>();
        for (String s : L) {
            addHashMap(lMap, s);
        }
        int wordLen = L[0].length();
        int totalLen = wordsCount * wordLen;
        int sLen = S.length();
        int j = 0;
        for (int i = 0; i <= sLen - totalLen; i++) {
            curMap.clear();
            for (j = 0; j < wordsCount; j++) {
                String str = S
                        .substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (lMap.containsKey(str)) {
                    addHashMap(curMap, str);
                } else {
                    break;
                }
                Integer curCount = curMap.get(str);
                Integer lCount = lMap.get(str);
                if (lCount == null || curCount > lCount) {
                    break;
                }
            }
            if (j == wordsCount) {
                // success
                res.add(i);
            }
        }
        return res;
    }

    private void addHashMap(Map<String, Integer> map, String s) {
        Integer count = map.get(s);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        map.put(s, count);
    }
}