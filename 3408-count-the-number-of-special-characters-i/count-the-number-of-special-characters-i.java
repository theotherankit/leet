class Solution {
    public int numberOfSpecialChars(String word) {
        int cnt = 0;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char c: word.toCharArray()) {
            if(c >= 65 && c <= 90)
                freq1[c - 'A']++;
            else
                freq2[c - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++) {
            if(freq1[i] > 0 && freq2[i] > 0)
                cnt++;
        }

        return cnt;
    }
}