class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    
    void dfs(String s, int start) {
        int n = s.length();
        if(start == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        int end;
        for(end = start ; end < n ; end++) {
            String t = s.substring(start, end + 1);
            if(check(t)) {
                temp.add(t);
                dfs(s, end + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}