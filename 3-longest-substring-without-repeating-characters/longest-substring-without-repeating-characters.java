class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0, len = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        while(r < n) {
            char c = s.charAt(r);
            while(mp.containsKey(c) && l <= r) {
                mp.remove(s.charAt(l));
                l++;
            }
            
            len = Math.max(len, r - l + 1);
            mp.put(c, 1);
            r++;
        }

        return len;
    }
}