/**
 * @time: 2013-08-28
 */
public class Solution {
    private static final char[] ROMAN_CHAR = new char[] { 'I', 'V', 'X', 'L',
            'C', 'D', 'M' };
    private static final Map<Integer, String> ROMAN_MAP = new HashMap<Integer, String>();

    static {
        ROMAN_MAP.put(0, "");
        ROMAN_MAP.put(1, "0");
        ROMAN_MAP.put(2, "00");
        ROMAN_MAP.put(3, "000");
        ROMAN_MAP.put(4, "01");
        ROMAN_MAP.put(5, "1");
        ROMAN_MAP.put(6, "10");
        ROMAN_MAP.put(7, "100");
        ROMAN_MAP.put(8, "1000");
        ROMAN_MAP.put(9, "02");
    }

    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuffer buf = new StringBuffer();

        int offset = 0;
        while (num != 0) {
            String roman = toRoman(num % 10, offset);
            buf.insert(0, roman);
            offset++;
            num /= 10;
        }
        return buf.toString();
    }

    private String toRoman(int num, int offset) {
        String digits = ROMAN_MAP.get(num);
        int off2 = offset * 2;
        digits = digits.replace('0', ROMAN_CHAR[off2]);
        if (off2 + 1 < ROMAN_CHAR.length)
            digits = digits.replace('1', ROMAN_CHAR[off2 + 1]);
        if (off2 + 2 < ROMAN_CHAR.length)
            digits = digits.replace('2', ROMAN_CHAR[off2 + 2]);
        return digits;
    }
}

public class Solution {
    static List<Pair> romans = new ArrayList<Pair>();
    static {
        romans.add(new Pair(1, 'I'));
        romans.add(new Pair(5, 'V'));
        romans.add(new Pair(10, 'X'));
        romans.add(new Pair(50, 'L'));
        romans.add(new Pair(100, 'C'));
        romans.add(new Pair(500, 'D'));
        romans.add(new Pair(1000, 'M'));
    }

    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == 0) {
            return "";
        }
        for (int i = romans.size() - 1; i >= 0; i--) {
            Pair p = romans.get(i);
            if (num >= p.a) {
                return "" + p.b + intToRoman(num - p.a);
            }
            if (i > 0) {
                Pair lastP = romans.get(i - 1 - ((i - 1) % 2));
                if (num >= p.a - lastP.a) {
                    return "" + lastP.b + p.b
                            + intToRoman(num - (p.a - lastP.a));
                }
            }
        }
        return "";
    }

    static class Pair {
        int a;
        char b;

        public Pair(int a, char b) {
            this.a = a;
            this.b = b;
        }
    }

}