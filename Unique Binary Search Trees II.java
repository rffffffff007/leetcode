/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(n, 1);
    }
    
    public ArrayList<TreeNode> generateTrees(int n, int start) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(n == 0){
            result.add(null);
            return result;
        }
        for(int i = start; i < start + n; i++){
            List<TreeNode> left = generateTrees(i - start, start);
            List<TreeNode> right = generateTrees(n + start - i - 1, i + 1);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }
}