package WordSearch;

public class Solution {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if (n <= 0) {
            return false;
        }
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (visit(board, visited, i, j, word, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean visit(char[][] board, boolean[][] visited, int i, int j, String word, int pos) {
        if(pos >= word.length()){
            return true;
        }
        if (i > 0 && board[i - 1][j] == word.charAt(pos) && !visited[i-1][j]) {
            visited[i - 1][j] = true;
            if (visit(board, visited, i - 1, j, word, pos + 1)) {
                return true;
            }
            visited[i - 1][j] = false;
        }
        if (j > 0 && board[i][j - 1] == word.charAt(pos) && !visited[i][j-1]) {
            visited[i][j - 1] = true;
            if (visit(board, visited, i, j-1, word, pos + 1)) {
                return true;
            }
            visited[i][j - 1] = false;
        }
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(pos) && !visited[i+1][j]) {
            visited[i + 1][j] = true;
            if (visit(board, visited, i + 1, j, word, pos + 1)) {
                return true;
            }
            visited[i + 1][j] = false;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(pos) && !visited[i][j+1]) {
            visited[i][j+1] = true;
            if (visit(board, visited, i, j + 1, word, pos + 1)) {
                return true;
            }
            visited[i][j+1] = false;
        }
        return false;
    }

    public static void main(String[] args) {

//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
//        String word2 = "SEE";
//        String word3 = "SEEDD";
        char[][] board = {{'a', 'a'}};
        String word = "aaa";
        Solution s = new Solution();
        System.out.println(s.exist(board,word));
    }

}
