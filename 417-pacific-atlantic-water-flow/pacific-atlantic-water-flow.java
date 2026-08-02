class Solution {
    void dfs(int r, int c, int state[][], int flag, int heights[][], int prev) {
        if(r < 0 || r >= state.length || c < 0 || c >= state[0].length)
            return;
        if((state[r][c] & flag) != 0)
            return;
        if(heights[r][c] < prev)
            return;

        state[r][c] |= flag;
        dfs(r - 1, c, state, flag, heights, heights[r][c]);
        dfs(r + 1, c, state, flag, heights, heights[r][c]);
        dfs(r, c - 1, state, flag, heights, heights[r][c]);
        dfs(r, c + 1, state, flag, heights, heights[r][c]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        int state[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++) {
            dfs(i, 0, state, 1, heights, 0);
            dfs(i, n - 1, state, 2, heights, 0);
        }

        for(int j = 0 ; j < n ; j++) {
            dfs(0, j, state, 1, heights, 0);
            dfs(m - 1, j, state, 2, heights, 0);
        }

        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++)
                if(state[i][j] == 3)
                    res.add(Arrays.asList(i, j));

        return res;
    }
}