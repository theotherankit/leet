class Solution {
    public int maxProfit(int[] prices) {        
        // two temp variables to store min and max till now, and based on that store in dp to check
        // the max value till now
        int n = prices.length;
        if(n == 0)
            return 0;

        int min = prices[0], max = prices[0];
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i = 1 ; i < n ; i++) {
            if(prices[i] < min)
                min = prices[i];

            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }

        return dp[n - 1];
    }
}