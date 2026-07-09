class Solution {
    HashMap<Integer, List<Character>> mp = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        mp.put(2, List.of('a', 'b', 'c'));
        mp.put(3, List.of('d', 'e', 'f'));
        mp.put(4, List.of('g', 'h', 'i'));
        mp.put(5, List.of('j', 'k', 'l'));
        mp.put(6, List.of('m', 'n', 'o'));
        mp.put(7, List.of('p', 'q', 'r', 's'));
        mp.put(8, List.of('t', 'u', 'v'));
        mp.put(9, List.of('w', 'x', 'y', 'z'));

        dfs(digits, "", 0);
        return res;
    }

    void dfs(String digits, String s, int start) {
        if(digits.length() == start) {
            res.add(s);
            return;
        }

        int x = digits.charAt(start) - '0';
        List<Character> letters = mp.get(x);
        for(char ch: letters)
            dfs(digits, s + ch, start + 1);
    }
}