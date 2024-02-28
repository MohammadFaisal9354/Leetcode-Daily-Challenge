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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> levelQue = new ArrayDeque<>();
        levelQue.offerLast(root);
        int leftNodeVal = root.val;
        while(!levelQue.isEmpty()){
            int currLevelSize = levelQue.size();
            int orgSize = currLevelSize;
            while(currLevelSize-->0){
                TreeNode currNode = levelQue.pollFirst();
                if(orgSize-1 == currLevelSize)
                    leftNodeVal = currNode.val;
                if(currNode.left != null)levelQue.offerLast(currNode.left);
                if(currNode.right != null)levelQue.offerLast(currNode.right);
            }
        }   
        return leftNodeVal;
    }
}
