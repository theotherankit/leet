class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, Comparator.<int[]>comparingInt(a -> a[1] - a[0])
                                .reversed());
        int cap = 0, used = 0, actual = 0, minimum = 0;
        for(int task[]: tasks) {
            actual = task[0];
            minimum = task[1];
            if(cap < minimum) {
                int t = minimum - cap;
                cap += t;
                used += t;
            }
            cap -= actual;
        }
        return used;
    }
}