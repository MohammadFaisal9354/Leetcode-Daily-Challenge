class Solution {
    List<Integer> answer = new ArrayList<>();
    Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        depthFirst(target, k);
        return answer;
    }
    
    private void findParent(TreeNode node) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            childParentMap.put(node.left, node);
            findParent(node.left);
        }
        if(node.right != null) {
            childParentMap.put(node.right, node);
            findParent(node.right);
        }
    }
    
    private void depthFirst(TreeNode node, int k) {
        if(node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        if(k == 0) {
            answer.add(node.val);
            return;
        }
        depthFirst(node.left, k-1);
        depthFirst(node.right, k-1);
        depthFirst(childParentMap.get(node), k-1);
    }
}
