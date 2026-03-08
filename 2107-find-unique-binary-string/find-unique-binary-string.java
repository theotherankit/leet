class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        String res = "";
        for(int i = 0 ; i < n ; i++) {
            res += (nums[i].charAt(i) == '0') ? '1' : '0';
        }
        return res;
    }
}