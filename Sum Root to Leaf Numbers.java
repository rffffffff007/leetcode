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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int parentSum){
        if(root == null)
            return 0;
        int nodeSum = parentSum * 10 + root.val;
        if(root.left == null && root.right == null)
            return nodeSum;
        else{
            return sumNumbers(root.left, nodeSum) + sumNumbers(root.right, nodeSum);
        }
    }
    
}