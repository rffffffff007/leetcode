public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        List<Word> anas = new ArrayList<Word>();
        for (String s : strs) {
            anas.add(new Word(s));
        }
        Collections.sort(anas);
        int lastIndex = 0;
        int i = 1;
        for (; i < anas.size(); i++) {
            if (anas.get(i).compareTo(anas.get(i - 1)) == 0) {
                continue;
            } else {
                if (i - lastIndex >= 2) {
                    for (int j = lastIndex; j < i; j++) {
                        res.add(anas.get(j).val);
                    }
                }
                lastIndex = i;
            }
        }
        if (i - lastIndex >= 2) {
            for (int j = lastIndex; j < i; j++) {
                res.add(anas.get(j).val);
            }
        }
        return res;
    }

    class Word implements Comparable<Word> {
        String val;
        int[] features;

        public Word(String v) {
            val = v;
            features = new int[26];
            char[] chars = val.toCharArray();
            for (char c : chars) {
                features[c - 'a']++;
            }
        }

        @Override
        public int compareTo(Word w) {
            for (int i = 0; i < 26; i++) {
                if (features[i] != w.features[i]) {
                    return features[i] - w.features[i];
                }
            }
            return 0;
        }
    }
}