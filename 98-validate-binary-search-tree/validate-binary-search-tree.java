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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean dfs(TreeNode node, long x, long y) {
        if(node == null)
            return true;

        if(node.val <= x || node.val >= y)
            return false;

        if(node.left != null)
            if(!dfs(node.left, x, node.val))
                return false;

        if(node.right != null)
            if(!dfs(node.right, node.val, y))
                return false;

        return true;
    }
}