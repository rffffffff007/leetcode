public class Solution {
    static final int N = 9;

    public boolean isValidSudoku(char[][] board) {
        return validSudoku(board);
    }

    private boolean validSudoku(char[][] board) {
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        Set<Character> set3 = new HashSet<Character>();
        char c;
        int xi, yi;
        for (int i = 0; i < N; i++) {
            set1.clear();
            set2.clear();
            set3.clear();
            for (int j = 0; j < N; j++) {
                c = board[i][j];
                if (Character.isDigit(c)) 
                    if (!set1.contains(c)) 
                        set1.add(c);
                    else 
                        return false;

                c = board[j][i];
                if (Character.isDigit(c)) 
                    if (!set2.contains(c)) 
                        set2.add(c);
                    else
                        return false;

                xi = i / 3 * 3 + j / 3;
                yi = i % 3 * 3 + j % 3;
                c = board[xi][yi];
                if (Character.isDigit(c)) 
                    if (!set3.contains(c))
                        set3.add(c);
                    else
                        return false;
            }
        }
        return true;
    }
}