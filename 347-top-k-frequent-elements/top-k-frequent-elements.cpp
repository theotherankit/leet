class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> mp;
        for(int i:nums)
        mp[i]++;
        vector<int> res;
        while(k-->0) {
            int maxn=mp[0],temp=0;
            for(auto const& i:mp) {
                if(i.second>maxn) {
                    maxn=i.second;
                    temp=i.first;
                }
            }
            res.push_back(temp);
            mp.erase(temp);
        }
        return res;
    }
};