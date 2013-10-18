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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, postorder, 0, inorder.length);
    }
    
    private TreeNode buildTree(int[] in, int is, int[] post, int ps, int len){
        if(len == 0)
            return null;
        int val = post[ps + len - 1];
        int lenLeft = 0;
        for(;lenLeft < len; lenLeft++)
            if(in[is + lenLeft] == val)
                break;
        TreeNode node = new TreeNode(val);
        node.left = buildTree(in, is, post, ps, lenLeft);
        node.right = buildTree(in, is + lenLeft + 1, post, ps + lenLeft, len - 1 - lenLeft);
        return node;
    }
}