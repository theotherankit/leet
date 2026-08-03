class Solution {
    int ind = 0;
    boolean cycle(int i, List<List<Integer>> graph, int state[], int res[]) {
        if(state[i] == 1) // visiting cycle detected
            return true;
        
        if(state[i] == 2)
            return false;

        state[i] = 1;
        for(int x: graph.get(i))
            if(cycle(x, graph, state, res))
                return true;

        state[i] = 2;
        res[ind++] = i;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++)
            graph.add(new ArrayList<>());
        for(int x[]: prerequisites)
            graph.get(x[0]).add(x[1]);

        int state[] = new int[numCourses];
        int res[] = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++)
            if(state[i] == 0)
                if(cycle(i, graph, state, res))
                    return new int[0];

        return res; 
    }
}