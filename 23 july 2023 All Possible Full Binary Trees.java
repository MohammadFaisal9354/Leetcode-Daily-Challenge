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
    private  final Map<Integer, List<TreeNode>> memo = new HashMap<>();
    private final int DEFAULT_VALUE = 0;
    public List<TreeNode> allPossibleFBT(int n) {
        return dp(n);
    }

    private List<TreeNode> dp(int n) {
        if(n % 2 == 0) {
            memo.put(n, Collections.emptyList());
            return memo.get(n);
        }
        if(n == 1) {
            memo.put(n, List.of(new TreeNode(DEFAULT_VALUE, null, null)));
            return memo.get(n);
        }
        if(!memo.containsKey(n)) {
            List<TreeNode> trees = new ArrayList<>();
            for (int leftChildrenCount=0; leftChildrenCount < n-1; leftChildrenCount++) {
                int rightChildrenCount = n - 1 - leftChildrenCount;
                for (TreeNode leftChild: dp(leftChildrenCount)) {
                    for (TreeNode rightChild: dp(rightChildrenCount)) {
                        TreeNode newNode = new TreeNode(DEFAULT_VALUE, leftChild, rightChild);
                        trees.add(newNode);
                    }
                }
            }
            memo.put(n, trees);
            return memo.get(n);
        }
        return memo.get(n);
    }
}
