/**
 * @time: 2013-08-31
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        // Use stack to perform a inorder traversal
        // Find one or two descending points.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node = null;
        TreeNode last = null;
        
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        while(!stack.isEmpty() || node != null){
            if(node != null) {
                node = node.left;
            } else {
                node = stack.pop();
                // visit node here.
                if(last == null)
                    last = node;
                else if (last.val > node.val){
                    if(leftNode == null){
                        leftNode = last;
                        rightNode = node;
                    } else {
                        rightNode = node;
                    }
                }
                node = node.right;
            }
        }
        
        if(leftNode != null){
            int tmp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = tmp;
        }
    }
}

public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode result = new TreeNode(0);
        inorder(root, null, result);
        if(result.left != null){
            int tmp = result.left.val;
            result.left.val = result.right.val;
            result.right.val = tmp;
        }
    }
    
    /**
     * Return the last node.
     * @param parentLast: the largest parent that is smaller than node.
     */
    private TreeNode inorder(TreeNode node, TreeNode parentLast, TreeNode result){
        if(node == null)
            return null;
        TreeNode last = inorder(node.left, parentLast, result);
        if(last == null)
            last = parentLast;
        if(last != null && last.val > node.val){
            if(result.left == null){
                result.left = last;
                result.right = node;
            } else {
                result.right = node;
            }
        }
        // here node is the largest parent node in its right child.
        TreeNode rightLast = inorder(node.right, node, result);
        return rightLast == null ? node : rightLast;
    }
}