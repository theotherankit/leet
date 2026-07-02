class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int vis[] = new int[nums.length];
        dfs(nums, new ArrayList<>(), res, vis);
        return res;
    }

    void dfs(int nums[], List<Integer> temp, List<List<Integer>> res, int vis[]) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++) {
            if(vis[i] == 0) {
                temp.add(nums[i]);
                vis[i] = 1;
                dfs(nums, temp, res, vis);
                temp.remove(temp.size() - 1);
                vis[i] = 0;
            }
        }
    }
}