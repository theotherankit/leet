class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), res, 0);
        return res;
    }

    void dfs(int nums[], List<Integer> temp, List<List<Integer>> res, int start) {
        res.add(new ArrayList<>(temp));
            
        for(int i = start ; i < nums.length ; i++) {
            if(i > start && nums[i] == nums[i - 1])
                continue;
            
            temp.add(nums[i]);
            dfs(nums, temp, res, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}