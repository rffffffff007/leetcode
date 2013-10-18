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
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int minD = Integer.MAX_VALUE;
        if(root.left != null)
            minD = Math.min(minD, minDepth(root.left) + 1);
        if(root.right != null)
            minD = Math.min(minD, minDepth(root.right) + 1);
        return minD;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
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