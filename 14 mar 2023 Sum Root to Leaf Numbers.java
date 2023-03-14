class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, root.val));

        int sum = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            TreeNode node = cur.getKey();
            int num = cur.getValue();

            if (node.left == null && node.right == null) {
                sum += num;
                continue;
            }

            if (node.left != null) {
                stack.push(new Pair<>(node.left, num * 10 + node.left.val));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, num * 10 + node.right.val));
            }
        }

        return sum;
    }
}
