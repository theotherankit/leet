class Solution {
    public int findDuplicate(int[] nums) {
        boolean seen[] = new boolean[nums.length];
        for(int x: nums) {
            if(seen[x])
                return x;
            seen[x] = true;
        }
        return -1;
    }
}