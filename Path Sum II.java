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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        pathSum(root, sum, path, res);
        return res;
    }
    
    private void pathSum(TreeNode root, int sum, List<Integer> path, ArrayList<ArrayList<Integer>> res){
        if(root == null){
            return;
        } else if(root.left == null && root.right == null && root.val == sum){
            path.add(root.val);
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(path);
            res.add(list);
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        pathSum(root.left, sum - root.val, path, res);
        pathSum(root.right, sum - root.val, path, res);
        path.remove(path.size() - 1);
    }
}