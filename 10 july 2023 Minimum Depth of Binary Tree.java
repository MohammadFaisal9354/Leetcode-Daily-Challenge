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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftdepth=minDepth(root.left);
        int rightdepth=minDepth(root.right);
        if(root.left==null && root.right==null){
            return 1;
        }

        if(root.right==null){
            return 1+leftdepth;
        }
        if(root.left==null){
            return 1+rightdepth;
        }
         int min=Math.min(rightdepth,leftdepth)+1;
        return min;
    }
}
