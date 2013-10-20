public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        int lens = S.length();
        int lenl = L.length;
        ArrayList<Integer> subPos = new ArrayList<Integer>();
        if (lenl == 0)
            return subPos;
        int wordLen = L[0].length();
        int totalLen = wordLen * lenl;
        Map<String, Integer> lMap = new HashMap<String, Integer>();
        Map<String, Integer> sMap = new HashMap<String, Integer>();
        for (String l : L)
            addMap(lMap, l);
        for (int i = 0; i <= lens - totalLen; i++) {
            sMap.clear();
            int j = i;
            for (; j < i + totalLen; j += wordLen) {
                String sub = S.substring(j, j + wordLen);
                if (lMap.containsKey(sub)) {
                    addMap(sMap, sub);
                    if (sMap.get(sub) > lMap.get(sub))
                        break;
                } else 
                    break;
            }
            if (j == i + totalLen) 
                subPos.add(i);
        }
        return subPos;
    }

    private void addMap(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) 
            map.put(key, map.get(key) + 1);
        else 
            map.put(key, 1);
    }
}