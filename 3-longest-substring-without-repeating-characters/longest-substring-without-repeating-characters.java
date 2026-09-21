class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, len = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int r = 0 ; r < n ; r++) {
            char c = s.charAt(r);
            if(mp.containsKey(c) && mp.get(c) >= l)
                l = mp.get(c) + 1;

            mp.put(c, r);
            len = Math.max(len, r - l + 1);
        }

        return len;
    }
}