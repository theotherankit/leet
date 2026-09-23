class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0 ; i < len ; i++) {
            int x = target - nums[i];
            if(mp.containsKey(nums[i]))
                return new int[]{mp.get(nums[i]), i};
            mp.put(x, i);
        }
        return new int[]{0, 0};
    }
}