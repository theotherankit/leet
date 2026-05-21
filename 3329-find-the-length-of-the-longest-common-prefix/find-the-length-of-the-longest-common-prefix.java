class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        HashSet<Integer> mp = new HashSet<>();
        for(int x: arr1) {
            int div = 1;
            while(x / div > 9)
                div *= 10;

            while(div > 0) {
                mp.add(x / div);
                div /= 10;
            }
        }

        for(int x: arr2) {
            int div = 1;
            while(x / div > 9)
                div *= 10;

            while(div > 0) {
                int prefix = x / div;
                if(mp.contains(prefix))
                    ans = Math.max(ans, String.valueOf(prefix).length());
                div /= 10;
            }
        }

        return ans;
    }
}