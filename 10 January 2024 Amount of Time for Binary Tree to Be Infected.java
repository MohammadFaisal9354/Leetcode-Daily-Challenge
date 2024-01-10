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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> hm=new HashMap<>();
        TreeNode startPtr=bfsToMapParents(root,start,hm);
        return findMinTimeToBurn(startPtr,hm);
    }
    public TreeNode bfsToMapParents(TreeNode root, int start, HashMap<TreeNode,TreeNode> hm){
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        TreeNode startPtr=null;
        while(!qu.isEmpty()){
            TreeNode curr=qu.poll();
            if(curr.val==start)
                startPtr=curr;
            if(curr.left!=null){
                hm.put(curr.left,curr);
                qu.add(curr.left);
            }
            if(curr.right!=null){
                hm.put(curr.right,curr);
                qu.add(curr.right);
            }
        }
        return startPtr;
    }
    public int findMinTimeToBurn(TreeNode startPtr,HashMap<TreeNode,TreeNode> hm){
        HashSet<TreeNode> vis=new HashSet<>();
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(startPtr);
        vis.add(startPtr);
        int time=0;
        while(!qu.isEmpty()){
            boolean flag=false;
            int size=qu.size();
            for(int i=0;i<size;i++){
                TreeNode curr=qu.poll();
                if(curr.left!=null && !vis.contains(curr.left)){
                    qu.add(curr.left);
                    vis.add(curr.left);
                    flag=true;
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    qu.add(curr.right);
                    vis.add(curr.right);
                    flag=true;
                }
                if(hm.containsKey(curr) && !vis.contains(hm.get(curr)) ){
                    qu.add(hm.get(curr));
                    vis.add(hm.get(curr));
                    flag=true;
                }
            }
            if(flag)
                time++;
        }
        return time;
    }
}
