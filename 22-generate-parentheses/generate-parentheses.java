class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, 0, 0);
        return res;
    }

    void dfs(List<String> res, String temp, int n, int open, int closed) {
        if(open == n && closed == n) {
            res.add(temp);
            return;
        }

        if(open <= n) {
            open++;
            dfs(res, temp + "(", n, open, closed);
            open--;
        }
        
        if(open > closed) {
            closed++;
            dfs(res, temp + ")", n, open, closed);
            closed--;
        }
    }
}