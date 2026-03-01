class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;

        int l = 0, r = 0, res = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        while(r < s.length()) {
            char c = s.charAt(r);
            if(!mp.containsKey(c))
                mp.put(c, 1);
            else {
                while(mp.get(c) > 0) {
                    char leftC = s.charAt(l);
                    mp.put(leftC, mp.get(leftC) - 1);
                    l++;
                }
                mp.put(c, 1);
            }

            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}