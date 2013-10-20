public class Solution {
    static Map<Integer, String> romans = new HashMap<Integer, String>();
    static {
        romans.put(1, "I");
        romans.put(5, "V");
        romans.put(10, "X");
        romans.put(50, "L");
        romans.put(100, "C");
        romans.put(500, "D");
        romans.put(1000, "M");
    }

    public String intToRoman(int num) {
        List<Integer> keys = new ArrayList<Integer>(romans.keySet());
        Collections.sort(keys);
        for (int i = keys.size() - 1; i >= 0; i--) {
            int ki = keys.get(i);
            String si = romans.get(ki);
            if (num >= ki) 
                return si + intToRoman(num - ki);
            if (i > 0) {
                int kj = keys.get(i - 1 - ((i - 1) % 2));
                String sj = romans.get(kj);
                if (num >= ki - kj) 
                    return sj + si + intToRoman(num - (ki - kj));
            }
        }
        return "";
    }
}

public class Solution {
    private static final char[] ROMAN_CHAR = new char[] { 'I', 'V', 'X', 'L',
            'C', 'D', 'M' };
    private static final Map<Integer, String> ROMAN_MAP = new HashMap<Integer, String>();

    static {
        ROMAN_MAP.put(0, "");
        ROMAN_MAP.put(1, "I");
        ROMAN_MAP.put(2, "II");
        ROMAN_MAP.put(3, "III");
        ROMAN_MAP.put(4, "IV");
        ROMAN_MAP.put(5, "V");
        ROMAN_MAP.put(6, "VI");
        ROMAN_MAP.put(7, "VII");
        ROMAN_MAP.put(8, "VIII");
        ROMAN_MAP.put(9, "IX");
    }

    public String intToRoman(int num) {
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
        if (off2 + 2 < ROMAN_CHAR.length)
            digits = digits.replace('X', ROMAN_CHAR[off2 + 2]);
        if (off2 + 1 < ROMAN_CHAR.length)
            digits = digits.replace('V', ROMAN_CHAR[off2 + 1]);
        digits = digits.replace('I', ROMAN_CHAR[off2]);
        return digits;
    }
}