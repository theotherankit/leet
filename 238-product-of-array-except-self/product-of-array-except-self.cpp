class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> pdt(nums.size(),1);
        pdt[0]=1;
        for(int i=1;i<nums.size();i++)
        pdt[i]=pdt[i-1]*nums[i-1];
        int suff=1;
        for(int i=pdt.size()-1;i>=0;i--) {
            pdt[i]*=suff;
            suff*=nums[i];
        }
        return pdt;
    }
};