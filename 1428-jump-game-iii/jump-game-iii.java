class Solution {
    static int flag = 0;
    public boolean travel(int arr[], int ind, boolean vis[]) {
        if(ind < 0 || ind >= arr.length)
            return false;
        
        if(vis[ind])
            return false;

        if(arr[ind] == 0)
            return true;

        vis[ind] = true;
        return travel(arr, ind - arr[ind], vis) || travel(arr, ind + arr[ind], vis);
    }

    public boolean canReach(int[] arr, int start) {
        boolean vis[] = new boolean[arr.length];
        return travel(arr, start, vis);
    }
}