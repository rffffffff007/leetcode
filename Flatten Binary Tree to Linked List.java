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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null)
            stack.push(root);
        while (stack.size() > 0) {
            TreeNode n = stack.pop();
            if (n.right != null)
                stack.push(n.right);
            if (n.left != null)
                stack.push(n.left);
            if (n != root) {
                root.right = n;
                root.left = null;
                root = root.right;
            }
        }
    }
}