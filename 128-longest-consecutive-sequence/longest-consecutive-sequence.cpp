class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.empty())
        return 0;
        sort(nums.begin(),nums.end());
        int len=0;
        int maxlen=0;
        for(int i=0;i<nums.size()-1;i++) {
            if(nums[i]+1==nums[i+1]) {
                len++;
            }
            else if(nums[i]==nums[i+1])
            continue;
            else
            len=0;

            if(len>maxlen)
            maxlen=len;
        }
        return (maxlen+1);
    }
};