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
    Map<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        searchInBST(root);
        int maxFreq = -1;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (maxFreq < freq) {
                maxFreq = freq;
                list.clear();
                list.add(key);
                continue;
            }
            if (maxFreq == freq) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void searchInBST(TreeNode node) {
        if (node == null) return;
        if (map.containsKey(node.val)) {
            map.put(node.val, map.get(node.val) + 1);
        } else 
            map.put(node.val, 1);
        searchInBST(node.left);
        searchInBST(node.right);
    }
}
