/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int res = 0;
    private void solveDFS(TreeNode root, Set<Integer> set) {
        if (root == null)
            return;
        if (set.contains(root.val)) 
            set.remove(root.val);
        else
            set.add(root.val);
        if (root.left == null && root.right == null) {
            if (set.size() <= 1)
                res++;
        }
        solveDFS(root.left, new HashSet(set));
        solveDFS(root.right, new HashSet(set));
    }
    public int pseudoPalindromicPaths(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        solveDFS(root, set);
        return res;
    }
}
