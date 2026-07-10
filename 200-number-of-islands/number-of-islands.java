class Solution {
    record Pair(int first, int second) {}

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i = 0 ; i < grid.length ; i++)
            for(int j = 0 ; j < grid[0].length ; j++)
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    cnt++;
                }

        return cnt;
    }

    void bfs(char grid[][], int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        int dr[] = {1, -1, 0, 0};
        int dc[] = {0, 0, 1, -1};
        while(!q.isEmpty()) {
            Pair x = q.poll();
            int r = x.first();
            int c = x.second();
            grid[r][c] = 'X';
            for(int m = 0 ; m < 4; m++) {
                int newR = r + dr[m];
                int newC = c + dc[m];
                if(newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length || grid[newR][newC] != '1') 
                    continue;
                q.offer(new Pair(newR, newC));
                grid[newR][newC] = 'X';
            }
        }
    }
}