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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return 0;
        }else{
            return depth(root);
        }
    }
    
    private int depth(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return Math.min(depth(root.left), depth(root.right)) + 1;
        }
    }
}