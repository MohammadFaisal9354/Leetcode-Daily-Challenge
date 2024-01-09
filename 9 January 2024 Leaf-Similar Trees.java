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
    List<Integer> al1 = new ArrayList();
    List<Integer> al2 = new ArrayList();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        traverse(root1, al1);
        traverse(root2, al2);
        if (al1.size() != al2.size()) 
            return false;
        for (int i = 0; i < al1.size(); i++) {
            if (al1.get(i) != al2.get(i)) 
                return false;
        }
        return true;
    }
    private void traverse(TreeNode root, List<Integer> al) {
        if (root == null) 
            return;
        if (root.left == null && root.right == null) 
            al.add(root.val);
        traverse(root.left, al);
        traverse(root.right, al);
    }
}
