class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length, res = 0;
        Queue<int[]> q = new LinkedList<>();
        int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    int cnt = 1;

                    while(!q.isEmpty()) {
                        int x[] = q.poll();
                        for(int d[]: dirs) {
                            int nx = x[0] + d[0];
                            int ny = x[1] + d[1];
                            if(nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] == 1) {
                                q.offer(new int[]{nx, ny});
                                grid[nx][ny] = 0;
                                cnt++;
                            }
                        }
                    }
                    res = Math.max(res, cnt);
                }
            }
        }
        return res;
    }
}