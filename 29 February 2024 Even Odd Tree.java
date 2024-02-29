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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return true;
        queue.add(root);
        int curr_level=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> arr=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
                if((curr_level%2)==(node.val%2))return false;
                arr.add(node.val);
            }
            if(curr_level%2==0){
                if(!CheckASC(arr))return false;
            }
            else{
                if(!CheckDSC(arr))return false;
            }
            curr_level+=1;
        }
        return true;
    }
    public boolean CheckASC(List<Integer> arr){
        int flag=0;
        for(int i=1;i<arr.size();i++){
            if(arr.get(i-1)<arr.get(i))continue;
            else flag=1;
        }
        return flag==0;
    }
    public boolean CheckDSC(List<Integer> arr){
        int flag=0;
        for(int i=1;i<arr.size();i++){
            if(arr.get(i-1)>arr.get(i))continue;
            else flag=1;
        }
        return flag==0;
    }
}
