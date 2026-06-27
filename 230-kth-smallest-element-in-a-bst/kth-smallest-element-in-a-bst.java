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
    int x, ans;
    public int kthSmallest(TreeNode root, int k) {
        x = k;
        inorder(root);
        return ans;
    }

    void inorder(TreeNode root) {
        if(root == null)
            return;

        inorder(root.left);
        if(--x == 0)
            ans = root.val;
        inorder(root.right);
    }
}