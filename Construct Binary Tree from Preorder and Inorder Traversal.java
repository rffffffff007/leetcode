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
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(inorder, 0, inorder.length, preorder, 0, preorder.length);
    }
    
    private TreeNode buildTree(int [] in, int is, int ie, int[] pre, int ps, int pe){
        if(is == ie){
            return null;
        }
        int val = pre[ps];
        TreeNode node = new TreeNode(val);
        int index = -1;
        for(int i = is; i < ie; i++){
            if(in[i] == val){
                index = i;
                break;
            }
        }
        int lenl = index - is;
        node.left = buildTree(in, is, index, pre, ps + 1, ps + lenl + 1);
        node.right = buildTree(in, index + 1, ie, pre, ps + lenl + 1, pe);
        return node;
    }
}