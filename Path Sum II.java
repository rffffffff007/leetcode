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
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        pathSum(root, sum, res, new ArrayList<Integer>());
        return res;
    }
    
    private void pathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0)
            res.add(new ArrayList<Integer>(list));
        else{
            pathSum(root.left, sum, res, list);
            pathSum(root.right, sum, res, list);
        }
        list.remove(list.size() - 1);
    }
}