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
        sum = 0;
        sumNum(root, 0);
        return sum;
    }

    private int sum = 0;

    private void sumNum(TreeNode root, int num) {
        if (root == null)
            return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        sumNum(root.left, num);
        sumNum(root.right, num);
    }

}


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