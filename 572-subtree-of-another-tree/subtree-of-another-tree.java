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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null)
            return false;

        if(isSame(root, subRoot))
            return true;
        
        if(isSubtree(root.left, subRoot))
            return true;

        if(isSubtree(root.right, subRoot))
            return true;
        
        return false;
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if(p == q)
            return true;
        
        if((p == null && q != null) || (p != null && q == null) || p.val != q.val)
            return false;

        if(!isSame(p.left, q.left))
            return false;

        if(!isSame(p.right, q.right))
            return false;

        return true;
    }
}