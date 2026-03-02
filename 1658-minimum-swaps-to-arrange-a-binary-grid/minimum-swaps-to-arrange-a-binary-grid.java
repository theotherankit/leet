class Solution {
    public int minSwaps(int[][] grid) {
        int len = grid.length, lenC = grid[0].length, i = 0 , j = 0, res = 0;

        int cnt0[] = new int[len];
        for(i = 0 ; i < len ; i++)
            for(j = lenC - 1 ; j >= 0 ; j--) {
                if(grid[i][j] != 0)
                    break;
                cnt0[i]++;
            }       

        for(i = 0 ; i < len ; i++) {
            j = i;
            while(j < len) {
                if(cnt0[j] >= lenC - i - 1) {
                    res += j - i;
                    for(int k = j ; k > i ; k--) {
                        int temp = cnt0[k];
                        cnt0[k] = cnt0[k - 1];
                        cnt0[k - 1] = temp;
                    }
                    break;
                }
                j++;
            }
            if(j == len)
                return -1;
        }
        return res;
    }
}