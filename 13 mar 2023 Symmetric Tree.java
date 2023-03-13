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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return checkSymmetric(root.left,root.right);
    }
    public boolean checkSymmetric(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode == null ^ rightNode == null){
            return false;
        }
        if(leftNode.val != rightNode.val){
            return false;
        }
        return checkSymmetric(leftNode.left,rightNode.right) && checkSymmetric(leftNode.right,rightNode.left);

    }
}
