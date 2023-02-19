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
    public List<List<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        List<List<Integer>> res = new ArrayList<>();
        if(A== null) return res;
        List<Integer> sub;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            sub = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode temp = queue.remove();
                sub.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            if(level%2!=0)Collections.reverse(sub);
            level++;
            res.add(sub);
        }
        return res;
    }
}
