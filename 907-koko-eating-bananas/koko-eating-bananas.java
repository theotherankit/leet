class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = piles[0];
        for(int pile: piles)
            r = Math.max(r, pile);
        
        int k = 1;
        while(l <= r) {
            long time = 0;
            k = (l + r) / 2;
            for(int pile: piles)
                time += (long)Math.ceil((double)pile / k);
            if(time <= h)
                r = k - 1;
            else 
                l = k + 1;
        }
        
        return l;
    }
}