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
    public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		sum = 0;
		sumNum(root, 0);
		return sum;
	}

	private int sum = 0;

	private void sumNum(TreeNode root, int num) {
		if (root == null)
			return;
		num = num * 10 + root.val;
		if (root.left == null && root.right == null) {
			sum += num;
			return;
		}
		sumNum(root.left, num);
		sumNum(root.right, num);
	}

}