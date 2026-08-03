class Solution {
    boolean cycle(int i, List<List<Integer>> graph, int state[]) {
        if(state[i] == 1) // visiting cycle found
            return true;
        
        if(state[i] == 2) // visited already
            return false;
        
        state[i] = 1; // visiting
        for(int x: graph.get(i))
            if(cycle(x, graph, state))
                return true;
        
        state[i] = 2; // visited no cycle found
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {                                                 
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++)
            graph.add(new ArrayList<>());
        for(int x[]: prerequisites)
            graph.get(x[0]).add(x[1]);

        int state[] = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++) {
            if(state[i] == 0)
                if(cycle(i, graph, state))
                    return false;
        }
        return true;
    }
}