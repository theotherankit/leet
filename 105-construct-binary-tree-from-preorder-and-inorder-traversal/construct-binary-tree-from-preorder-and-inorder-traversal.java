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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        
        int x = preorder[0];
        int pl = preorder.length, il = inorder.length;
        TreeNode root = new TreeNode(x);
        int ind = -1;
        for(int i = 0 ; i < il ; i++)
            if(inorder[i] == x)
            ind = i;

        
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, ind + 1), Arrays.copyOfRange(inorder, 0, ind));
        root.right = buildTree(Arrays.copyOfRange(preorder, ind + 1, pl), Arrays.copyOfRange(inorder, ind + 1, il));

        return root;
    }
}