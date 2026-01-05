class Solution {
public:
    int maxArea(vector<int>& height) {
        int i=0,j=height.size()-1;
        int maxArea=(j-i)*min(height[i],height[j]),curr;
        while(i<j) {
            curr=(j-i)*min(height[i],height[j]);
            maxArea=max(maxArea,curr);
            if(height[i]<height[j])
            i++;
            else
            j--;
        }
        return maxArea;
    }
};