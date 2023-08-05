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
    public List<TreeNode> generateTrees(int n) {
        return solve(1,n) ;
    }
    
    public List<TreeNode> solve(int left,int right){
        List<TreeNode> ans = new ArrayList<>() ;
        if(left > right){
            ans.add(null) ;
            return ans ;
        }
        for(int i = left ; i <= right ; i++){
            List<TreeNode> lft = solve(left,i-1) ;
            List<TreeNode> ryt = solve(i+1,right) ;
            for(TreeNode l : lft){
                for(TreeNode r : ryt){
                    ans.add(new TreeNode(i,l,r)) ;
                }
            }
        }
        return ans ;
    }
}
