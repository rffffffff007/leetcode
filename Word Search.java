public class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = n > 0 ? board[0].length : 0;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                if(searchWord(board, x, y, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    private static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    private boolean searchWord(char[][] board, int x, int y, String word, int wi){
        if(wi == word.length())
            return true;
        int n = board.length;
        int m = n > 0 ? board[0].length : 0;
        if(x < 0 || y < 0 || x >= n || y >= m)
            return false;
        if(board[x][y] != word.charAt(wi))
            return false;
        board[x][y] = 0;
        for(int[] dir : DIRS){
            if(searchWord(board, x + dir[0], y + dir[1], word, wi + 1))
                return true;
        }
        board[x][y] = word.charAt(wi);
        return false;
    }
}