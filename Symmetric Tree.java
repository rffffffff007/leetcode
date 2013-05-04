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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        } else {
            return isSameReverse(root.left, root.right);
        }
    }

    private boolean isSameReverse(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            return a.val == b.val && isSameReverse(a.left, b.right)
                    && isSameReverse(a.right, b.left);
        } else {
            return false;
        }
    }
}