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
    int LongestPath = 0;
    public int longestZigZag(TreeNode root) {
        int[] a = helper(root);
        return LongestPath;
    }
    
    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] answer = new int[]{left[1] + 1, right[0] + 1};
        LongestPath = Math.max(LongestPath, Math.max(answer[0], answer[1]));
        return answer;
    }
}
