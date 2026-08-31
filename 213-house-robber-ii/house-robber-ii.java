class Solution {
    static int robRange(int nums[], int st, int end) {
        if(st == end)
            return nums[st];
        
        int n = nums.length;
        int dp[] = new int[n];

        dp[st] = nums[st];
        dp[st + 1] = Math.max(nums[st], nums[st + 1]);
        for(int i = st + 2 ; i <= end ; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        
        return dp[end];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];

        int a = robRange(nums, 0, n - 2);
        int b = robRange(nums, 1, n - 1);

        return Math.max(a, b);
    }
}