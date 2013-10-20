public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        List<Word> anas = new ArrayList<Word>();
        for (String s : strs) 
            anas.add(new Word(s));
        Collections.sort(anas);
        int lastIndex = 0;
        int i = 1;
        for (; i < anas.size(); i++) {
            if (anas.get(i).compareTo(anas.get(i - 1)) == 0) {
                continue;
            } else {
                if (i - lastIndex >= 2) 
                    for (int j = lastIndex; j < i; j++) 
                        res.add(anas.get(j).val);
                lastIndex = i;
            }
        }
        if (i - lastIndex >= 2) 
            for (int j = lastIndex; j < i; j++) 
                res.add(anas.get(j).val);
        return res;
    }

    class Word implements Comparable<Word> {
        String val;
        int[] features = new int[26];

        public Word(String v) {
            val = v;
            for (char c : val.toCharArray()) 
                features[c - 'a']++;
        }

        @Override
        public int compareTo(Word w) {
            for (int i = 0; i < 26; i++) 
                if (features[i] != w.features[i]) 
                    return features[i] - w.features[i];
            return 0;
        }
    }
}

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        List<StrFeature> strFeatures = new ArrayList<StrFeature>();
        for (String s : strs) 
            strFeatures.add(new StrFeature(s));
        Collections.sort(strFeatures);

        ArrayList<String> result = new ArrayList<String>();
        int lastI = 0;
        int i = 0;
        for (; i < strFeatures.size(); i++) {
            StrFeature cur = strFeatures.get(i);
            StrFeature last = strFeatures.get(lastI);
            if (cur.compareTo(last) != 0) {
                if (i - lastI > 1) 
                    for (int j = lastI; j < i; j++) 
                        result.add(strFeatures.get(j).str);
                lastI = i;
            }
        }
        if (i - lastI > 1) 
            for (int j = lastI; j < i; j++) 
                result.add(strFeatures.get(j).str);
        return result;
    }

    private class StrFeature implements Comparable<StrFeature> {
        private TreeMap<Character, Integer> feas;
        public String str;

        public StrFeature(String s) {
            str = s;
            feas = new TreeMap<Character, Integer>();
            for (char c : s.toCharArray()) {
                if (feas.containsKey(c)) {
                    feas.put(c, feas.get(c) + 1);
                } else {
                    feas.put(c, 1);
                }
            }
        }

        public int compareTo(StrFeature str) {
            if (str == null)
                return 1;
            TreeMap<Character, Integer> mapa = feas;
            TreeMap<Character, Integer> mapb = str.feas;
            if (mapa.size() != mapb.size()) 
                return mapa.size() - mapb.size();
            Iterator<Character> itera = mapa.keySet().iterator();
            Iterator<Character> iterb = mapb.keySet().iterator();
            while (itera.hasNext()) {
                char ca = itera.next();
                char cb = iterb.next();
                if (ca != cb) 
                    return ca - cb;
                int fa = mapa.get(ca);
                int fb = mapb.get(cb);
                if (fa != fb) 
                    return fa - fb;
            }
            return 0;
        }
    }
}