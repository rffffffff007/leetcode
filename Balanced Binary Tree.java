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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return balanceHeight(root) >= 0;
    }

    private int balanceHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = balanceHeight(root.left);
        if (left == -1)
            return -1;
        int right = balanceHeight(root.right);
        if (right == -1)
            return -1;
        if (Math.abs(right - left) <= 1) {
            return Math.max(right, left) + 1;
        } else
            return -1;
    }
}