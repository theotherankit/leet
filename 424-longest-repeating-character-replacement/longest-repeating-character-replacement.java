class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, len = 0, temp = 0;
        int n = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int r = 0 ; r < n ; r++) {
            int curr = 1;
            char c = s.charAt(r);
            if(mp.containsKey(c))
                curr = mp.get(c) + 1;
            mp.put(c, curr);

            temp = Math.max(temp, curr);
            if(r - l + 1 - temp <= k)
                len = Math.max(len, r - l + 1);
            else {
                while(r - l + 1 - temp > k) {
                    char x = s.charAt(l);
                    l++;
                    mp.put(x, mp.get(x) - 1);
                }
            }
        }

        return len;
    }
}