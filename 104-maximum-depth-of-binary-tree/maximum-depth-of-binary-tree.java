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
    int maxd = 0;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        // curr depth = 1 + max(leftd, rightd)
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}