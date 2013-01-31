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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		if (root == null)
			return inorder;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (stack.size() > 0) {
			TreeNode node = stack.pop();
			if (node.right != null)
				stack.push(node.right);

			if (node.right == null && node.left == null) {
				inorder.add(node.val);
			} else {
				stack.push(new TreeNode(node.val));
			}

			if (node.left != null)
				stack.push(node.left);
		}
		return inorder;
	}

}