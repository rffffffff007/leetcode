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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return 0;
        maxSum = Integer.MIN_VALUE;
        maxSinglePathSum(root);
        return maxSum;
    }

    public int maxSinglePathSum(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = maxSinglePathSum(root.left);
        int rightSum = maxSinglePathSum(root.right);
        int pathSum = root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0);
        maxSum = pathSum > maxSum ? pathSum : maxSum;
        return Math.max(Math.max(leftSum, rightSum), 0) + root.val;
    }
}

/**
 * @time: 2013-08-26
 */
public class Solution {
    
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        maxPathSum(root, result);
        return result[1];
    }
    
    private void maxPathSum(TreeNode root, int[] result){
        if(root == null){
            result[0] = 0;
            result[1] = Integer.MIN_VALUE;
            return;
        }
        maxPathSum(root.left, result);
        int leftOneWaySum = result[0];
        int leftPathSum = result[1];
        
        maxPathSum(root.right, result);
        int rightOneWaySum = result[0];
        int rightPathSum = result[1];
        
        int oneWaySum = max(leftOneWaySum, rightOneWaySum, 0) + root.val;
        int pathSum = Math.max(leftOneWaySum, 0) + Math.max(rightOneWaySum, 0) + root.val;
        result[0] = oneWaySum;
        result[1] = max(leftPathSum, rightPathSum, pathSum);
    }
    
    private int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
}