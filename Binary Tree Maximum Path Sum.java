/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int maxSum;

	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		maxSum = Integer.MIN_VALUE;
		maxSinglePathSum(root);
		return maxSum;
	}

	public int maxSinglePathSum(TreeNode root) {
		if (root == null)
			return 0;
		int leftSum = maxSinglePathSum(root.left);
		int rightSum = maxSinglePathSum(root.right);
		int pathSum = root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0);
		maxSum = pathSum > maxSum ? pathSum : maxSum;
		return Math.max(Math.max(leftSum, rightSum), 0) + root.val;
	}
}