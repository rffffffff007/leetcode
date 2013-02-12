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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return false;
        } else if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        
        if(hasPathSum(root.left, sum - root.val)){
            return true;
        }
        if(hasPathSum(root.right, sum - root.val)){
            return true;
        }
        return false;
    }
    
}