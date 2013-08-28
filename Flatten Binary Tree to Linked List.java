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

/**
 * @time: 2013-08-28
 */
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode tail = null;
        while (stack.size() > 0 || cur != null) {
            if(cur == null)
                cur = stack.pop();
            
            // visit cur
            if(tail == null)
                tail = cur;
            else{
                tail.right = cur;
                tail.left = null;
                tail = cur;
            }
            
            if(cur.right != null)
                stack.push(cur.right);
            cur = cur.left;
        }
    }
}

/**
 * @time: 2013-08-28
 */
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        getTailAndFlatten(root);
    }
    
    private TreeNode getTailAndFlatten(TreeNode root){
        if(root == null)
            return null;
        TreeNode tail = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        
        TreeNode leftTail = getTailAndFlatten(left);
        tail.right = left;
        if(leftTail != null)
            tail = leftTail;
        
        TreeNode rightTail = getTailAndFlatten(right);
        tail.right = right;
        if(rightTail != null)
            tail = rightTail;
        
        return tail;
        
    }
    
    
}