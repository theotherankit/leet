class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int x: nums) {
            if(mp.containsKey(x))
                return x;
            mp.put(x, 1);
        }
        return -1;
    }
}