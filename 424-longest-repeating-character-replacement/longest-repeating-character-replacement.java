class Solution {
    public int characterReplacement(String s, int k) {
        if(k >= s.length())
            return s.length();

        int l = 0, r = 0, maxfreq = 0, res = 0;
        int[] freq = new int[26];
        while(r < s.length()) {
            int c = s.charAt(r) - 'A';
            freq[c]++;
            maxfreq = Math.max(maxfreq, freq[c]);
            while((r - l + 1) - maxfreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}