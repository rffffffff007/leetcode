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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int lower, int upper){
        if(root == null){
            return true;
        } else if(root.val >= upper || root.val <= lower){
            return false;
        }
        
        if(!isValidBST(root.left, lower, root.val) || !isValidBST(root.right, root.val, upper)){
            return false;
        }
        
        return true;
    }
}