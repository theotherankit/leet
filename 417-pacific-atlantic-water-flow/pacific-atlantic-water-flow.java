class Solution {
    int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    void bfs(Queue<int[]> q, int flag, int state[][], int heights[][]) {
        while(!q.isEmpty()) {
            int x[] = q.poll();
            int px = x[0];
            int py = x[1];
            for(int dir[]: dirs) {
                int px1 = px + dir[0];
                int py1 = py + dir[1];
                if(px1 >= 0 && px1 < heights.length && py1 >= 0 && py1 < heights[0].length) {
                    if((state[px1][py1] & flag) != 0)
                        continue;
                    if(heights[px1][py1] < heights[px][py])
                        continue;
                    state[px1][py1] |= flag;
                    q.offer(new int[]{px1, py1});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        int state[][] = new int[m][n];
        
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();
        for(int i = 0 ; i < m ; i++) {
            state[i][0] |= 1;
            pacQ.offer(new int[]{i, 0});

            state[i][n - 1] |= 2;
            atlQ.offer(new int[]{i, n - 1});
        }

        for(int j = 0 ; j < n ; j++) {
            state[0][j] |= 1;
            pacQ.offer(new int[]{0, j});

            state[m - 1][j] |= 2;
            atlQ.offer(new int[]{m - 1, j});
        }

        bfs(pacQ, 1, state, heights);
        bfs(atlQ, 2, state, heights);

        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++)
                if(state[i][j] == 3)
                    res.add(Arrays.asList(i, j));

        return res;
    }
}