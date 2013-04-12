public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        char[] row = new char[L];
        int wordsLen = 0;
        int wordLen = 0, newLen = 0;
        int startIndex = 0;
        for (int i = 0; i <= words.length; i++) {
            if (i < words.length) {
                wordLen = words[i].length();
                newLen = wordsLen + wordLen + i - startIndex;
            } else {
                newLen = 0;
            }

            if (newLen > L || (i == words.length)) {
                // make string.
                int[] spaces = assignSpace(i - startIndex, wordsLen, L,
                        i == words.length);
                int index = 0;
                for (int j = startIndex; j < i; j++) {
                    char[] ws = words[j].toCharArray();
                    System.arraycopy(ws, 0, row, index, ws.length);
                    index += ws.length;
                    Arrays.fill(row, index, index + spaces[j - startIndex], ' ');
                    index += spaces[j - startIndex];
                }
                res.add(new String(row));
                // start next row
                startIndex = i;
                wordsLen = wordLen;
            } else {
                wordsLen += wordLen;
            }
        }
        return res;
    }

    private int[] assignSpace(int wordCount, int wordsLen, int L,
            boolean alignLeft) {
        int[] spaces = new int[wordCount];
        if (wordCount == 1) {
            spaces[0] = L - wordsLen;
        } else {
            int leftSpace = L - wordsLen;

            int space = alignLeft ? 0 : leftSpace / (wordCount - 1);
            int unusedSpace = leftSpace - space * (wordCount - 1);
            int spaceSum = 0;
            for (int i = 0; i < wordCount - 1; i++) {
                spaces[i] = space + (i < unusedSpace ? 1 : 0);
                spaceSum += spaces[i];
            }
            spaces[wordCount - 1] += leftSpace - spaceSum;
        }
        return spaces;
    }
}