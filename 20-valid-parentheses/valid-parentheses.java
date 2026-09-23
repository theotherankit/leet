class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else {
                if(st.empty() || st.peek() != mp.get(c))
                    return false;
                st.pop();
            }
        }
        return st.empty() ? true : false;
    }
}