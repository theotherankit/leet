/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ind = 0;
    HashMap<Integer, Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length ; i++)
            mp.put(inorder[i], i);
        
        return dfs(preorder, 0, inorder.length - 1);
    }

    TreeNode dfs(int preorder[], int l, int r) {
        if(l > r)
            return null;
        
        int x = preorder[ind++];
        TreeNode root = new TreeNode(x);
        int pivot = mp.get(x);

        root.left = dfs(preorder, l, pivot - 1);
        root.right = dfs(preorder, pivot + 1, r);

        return root;
    }
}