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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(inorder, 0, preorder, 0, inorder.length);
    }
    
    private TreeNode buildTree(int[] in, int is, int[] pre, int ps, int len){
        if(len == 0)
            return null;
        int val = pre[ps];
        int lenLeft = 0;
        for(;lenLeft < len; lenLeft++)
            if(in[is + lenLeft] == val)
                break;
        TreeNode node = new TreeNode(val);
        node.left = buildTree(in, is, pre, ps + 1, lenLeft);
        node.right = buildTree(in, is + lenLeft + 1, pre, ps + 1 + lenLeft, len - 1 - lenLeft);
        return node;
    }
}