class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        dfs(candidates, 0, sum, target, temp, res);
        return res;
    }
    void dfs(int arr[], int i, int sum, int tgt,List<Integer> temp,List<List<Integer>> res) {
        if(sum == tgt) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(sum > tgt || i >= arr.length)
            return;

        temp.add(arr[i]);
        sum += arr[i];
        dfs(arr, i, sum, tgt, temp, res);
        temp.remove(temp.size() - 1);
        sum -= arr[i];
        dfs(arr, i + 1, sum, tgt, temp, res);
    }
}