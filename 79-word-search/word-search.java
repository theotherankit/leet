class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0 ; i < r ; i++)
            for(int j = 0 ; j < c ; j++)
                if(dfs(board, word, 0, r, c, i, j))
                    return true;
        
        return false;
    }

    boolean dfs(char board[][], String word, int ind, int r, int c, int i, int j) {
        if(word.charAt(ind) == board[i][j] && ind == word.length() - 1)
            return true;

        if(board[i][j] != word.charAt(ind) || board[i][j] == '#')
            return false;

        char ch = board[i][j];
        
        board[i][j] = '#';
        boolean found = (i + 1 < r && dfs(board, word, ind + 1, r, c, i + 1, j)) ||
        (j + 1 < c && dfs(board, word, ind + 1, r, c, i, j + 1)) ||
        (i > 0 && dfs(board, word, ind + 1, r, c, i - 1, j)) ||
        (j > 0 && dfs(board, word, ind + 1, r, c, i, j - 1));

        board[i][j] = ch;

        return found;
    }
}