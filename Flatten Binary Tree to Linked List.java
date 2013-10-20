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

public class Solution {
    public void flatten(TreeNode root) {
        getTailAndFlatten(root);
    }
    
    private TreeNode getTailAndFlatten(TreeNode tail){
        if(tail == null)
            return null;
        TreeNode right = tail.right;
        tail.right = tail.left;
        tail.left = null;
        if(tail.right != null)
            tail = getTailAndFlatten(tail.right);
        tail.right = right;
        if(tail.right != null)
            tail = getTailAndFlatten(tail.right);
        return tail;
    }
}
