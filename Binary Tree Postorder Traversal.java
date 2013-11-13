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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        TreeNode last = null;
        TreeNode node = null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null)
            stack.push(root);
        while(!stack.isEmpty()){
            node = stack.peek();
            if(last == null || last.left == node || last.right == node){
                if(node.left != null)
                    stack.push(node.left);
                else if(node.right != null)
                    stack.push(node.right);
            } else if(node.left == last){
                if(node.right != null)
                    stack.push(node.right);
            } else{
                node = stack.pop();
                list.add(node.val);
            }
            last = node;
        }
        return list;
    }
}