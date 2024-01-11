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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);  
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) 
            return Math.abs(max - min);
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int leftDiff = dfs(root.left, min, max);
        int rightDiff = dfs(root.right, min, max);
        return Math.max(Math.max(leftDiff, rightDiff), Math.abs(max - root.val));
    }
}
