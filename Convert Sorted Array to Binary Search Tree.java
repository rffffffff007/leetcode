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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(num, 0, num.length);
    }
    
    public TreeNode buildTree(int[] num, int start, int end){
        if(end <= start){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildTree(num, start, mid);
        node.right = buildTree(num, mid + 1, end);
        return node;
    }
}