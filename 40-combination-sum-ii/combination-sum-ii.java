class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    void dfs(int arr[], int i, int tgt, List<Integer> temp, List<List<Integer>> res) {
        if(tgt == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(tgt < 0 || i == arr.length)
            return;

        temp.add(arr[i]);
        dfs(arr, i + 1, tgt - arr[i], temp, res);
        temp.remove(temp.size()- 1);

        while((i < arr.length - 1) && arr[i] == arr[i + 1])
            i++;
    
        dfs(arr, i + 1, tgt, temp, res);
    }
} 