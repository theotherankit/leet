class Solution {
    int dirn[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        // use bfs to count the minutes starting every cell with a 2, so count and tell expanding for each bfs per cell
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length, c = grid[0].length, res = 0, cnt = 0;
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                else if(grid[i][j] == 1)
                    cnt++;
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            boolean found = false;

            for(int i = 0 ; i < size ; i++) {
                int x[] = q.poll();
                for(int dir[]: dirn) {
                    int px = x[0] + dir[0];
                    int py = x[1] + dir[1];
                    if(px >= 0 && px < r && py >= 0 && py < c && grid[px][py] == 1) {
                        grid[px][py] = 2;
                        q.offer(new int[]{px, py});
                        cnt--;
                        found = true;
                    }
                }
            }

            if(found)
                res++;
        }

        return cnt == 0 ? res : -1;
    }
}