class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int d = 0, div = 1;
        for(int x: nums) {
            div = 1;
            while(x / div > 9)
                div *= 10;
            while(div > 0) {
                ans.add(x / div);
                x %= div;
                div /= 10;
            }
        }

        int answer[] = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++)
            answer[i] = ans.get(i);
        return answer;
    }
}