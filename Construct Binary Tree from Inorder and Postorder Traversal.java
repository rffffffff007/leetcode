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
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    
    private TreeNode buildTree(int [] in, int is, int ie, int[] post, int ps, int pe){
        if(is == ie){
            return null;
        }
        int val = post[pe - 1];
        TreeNode node = new TreeNode(val);
        int index = -1;
        for(int i = is; i < ie; i++){
            if(in[i] == val){
                index = i;
                break;
            }
        }
        int lenl = index - is;
        node.left = buildTree(in, is, index, post, ps, ps + lenl);
        node.right = buildTree(in, index + 1, ie, post, ps + lenl, pe - 1);
        return node;
    }
}