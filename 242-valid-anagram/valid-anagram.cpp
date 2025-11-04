class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length()!=t.length())
        return false;
        vector<int> cnts(26,0);
        for(int i=0;i<s.length();i++) {
            cnts[s[i]-'a']++;
            cnts[t[i]-'a']--;
        }
        for(int i:cnts)
        if(i!=0)
        return false;
        return true;
    }
};