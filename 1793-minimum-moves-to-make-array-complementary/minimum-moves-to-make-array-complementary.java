class Solution {
    public int minMoves(int[] nums, int limit) {
        int diff[] = new int[2 * limit + 2];
        int n = nums.length;
        for(int i = 0 ; i < n / 2 ; i++) {
            int a = nums[i];
            int b = nums[n - i - 1];
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            diff[low] -= 1;
            diff[high + 1] += 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int ans = Integer.MAX_VALUE, curr = 0;
        for(int i = 2 ; i <= 2 * limit ; i++) {
            curr += diff[i];
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}