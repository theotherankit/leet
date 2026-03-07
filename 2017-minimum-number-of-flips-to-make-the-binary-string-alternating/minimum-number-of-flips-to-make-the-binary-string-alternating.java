class Solution {
    public int minFlips(String s) {
        int cnt1 = 0, cnt2 = 0, l = 0, n= s.length(), res = Integer.MAX_VALUE;
        String sRot = s + s;

        for(int r = 0 ; r < sRot.length() ; r++) {
            char c = sRot.charAt(r);
            if((r % 2 == 0 && c != '0') || (r % 2 != 0 && c != '1')) 
                cnt1++; 
            if((r % 2 == 0 && c != '1') || (r % 2 != 0 && c != '0')) 
                cnt2++;

            if(r - l + 1 > n) {
                char left = sRot.charAt(l);
                if((l % 2 == 0 && left != '0') || (l % 2 != 0 && left != '1')) 
                    cnt1--; 
                if((l % 2 == 0 && left != '1') || (l % 2 != 0 && left != '0')) 
                    cnt2--;
                l++;
            }
            
            if(r - l + 1 == n)
                res = Math.min(res, Math.min(cnt1, cnt2));
        }

        return res;
    }
}