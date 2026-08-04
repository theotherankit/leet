class Solution {
    static boolean dfs(int u, int v, List<List<Integer>> graph, boolean vis[]) {
        if(u == v)
            return true;
        
        vis[u] = true;
        for(int x: graph.get(u)) {
            if(!vis[x] && dfs(x, v, graph, vis))
                return true;
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for(int x[]: edges)
            n = Math.max(n, Math.max(x[0], x[1]));
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++)
            graph.add(new ArrayList<>());
        
        for(int x[]: edges) {
            boolean vis[] = new boolean[n + 1];
            if(dfs(x[0], x[1], graph, vis))
                return x;
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }

        return new int[]{0, 0};
    }
}