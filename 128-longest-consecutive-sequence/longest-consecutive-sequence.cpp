class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.empty())
        return 0;
        unordered_set<int> numSet(nums.begin(),nums.end());
        int maxlen=0,len,temp;
        for(int i:numSet) {
            if(numSet.count(i-1)==0) {
                temp=i;
                len=1;
                while(numSet.count(temp+1)) {
                    len++;
                    temp++;
                }
                maxlen=max(maxlen,len);
            }
        }
        return maxlen;
    }
};