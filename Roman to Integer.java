public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Character, Integer> romans = new HashMap<Character, Integer>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        char[] cs = s.toCharArray();
        int num = 0;
        int val;
        for (int i = 0; i < cs.length; i++) {
            val = romans.get(cs[i]);
            if (i == cs.length - 1 || romans.get(cs[i + 1]) <= val) {
                num += val;
            } else {
                num -= val;
            }
        }
        return num;
    }
}