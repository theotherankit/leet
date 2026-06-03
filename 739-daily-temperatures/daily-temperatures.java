class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int n = temperatures.length;
        int curr[] = new int[n];
        
        for(int i = 1 ; i < n ; i++) {
            while(!st.empty() && temperatures[i] > temperatures[st.peek()])
                curr[st.peek()] = i - st.pop();
            st.push(i);
        }
        return curr;
    }
}