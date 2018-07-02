package WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        Set<Character> letters = new HashSet<>();
        int n = board.length;
        if(n == 0){
            return new ArrayList<>(result);
        }
        int m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!letters.contains(board[i][j]))
                    letters.add(board[i][j]);
            }
        }

        for(String word:words){
            char[] w = word.toCharArray();
            for(char c : w){
                if(!letters.contains(c)){
                    continue;
                }
            }

            for (int y=0; y<n; y++) {
                for (int x=0; x<m; x++) {
                    if (exist(board, y, x, w, 0))
                        result.add(word);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        Solution s = new Solution();
        System.out.println(s.findWords(board,words));
    }

}
