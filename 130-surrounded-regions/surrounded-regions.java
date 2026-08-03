class Solution {
    void dfs(int i, int j, char board[][]) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if(board[i][j] != 'O')
            return;
        
        board[i][j] = 'T';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0 ; i < m ; i++) {
            dfs(i, 0, board);
            dfs(i, n - 1, board);
        }
        for(int j = 0 ; j < n ; j++) {
            dfs(0, j, board);
            dfs(m - 1, j, board);
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++)
                board[i][j] = (board[i][j] == 'T') ? 'O' : 'X';
        }
    }
}