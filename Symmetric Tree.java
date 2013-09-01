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
        if(root == null)
            return true;
        return isSymmtric(root.left, root.right);
    }
    
    private boolean isSymmtric(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null)
            return true;
        else if(n1 == null || n2 == null)
            return false;
        else{
            return n1.val == n2.val && isSymmtric(n1.left, n2.right) & isSymmtric(n1.right, n2.left);
        }
    }
}