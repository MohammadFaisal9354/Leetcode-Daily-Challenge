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
   	static int count = 0;

	public static int averageOfSubtree(TreeNode root) {
		count = 0;
		helper(root);
		return count;
	}

	public static int helper(TreeNode root) {
		if (root == null)
			return 0;

		int left = helper(root.left);
		int right = helper(root.right);

		int sum = root.val;
		if (root.left != null) {
			sum += root.left.val;
		}
		if (root.right != null) {
			sum += root.right.val;
		}
		if (sum / (left + right + 1) == root.val) {
			count++;
		}
		root.val = sum;
		return left + right + 1;
	}
}
