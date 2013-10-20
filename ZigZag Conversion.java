public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
        int lens = s.length();
        int blockSize = 2 * nRows - 2;
        int blockCount = (lens + blockSize - 1) / blockSize;
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < blockCount; j++) {
                int start = j * blockSize;
                int i1 = start + i;
                if (i1 < lens)
                    buf.append(s.charAt(i1));
                int i2 = start + blockSize - i;
                if (i2 < lens && i2 < start + blockSize && i2 > i1)
                    buf.append(s.charAt(i2));
            }
        }
        return buf.toString();
    }
}