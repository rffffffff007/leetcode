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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    public void dfs(TreeNode root, int depth, ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;
        ArrayList<Integer> list = null;
        if (depth < res.size()) {
            list = res.get(depth);
        } else {
            list = new ArrayList<Integer>();
            res.add(list);
        }
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
        list.add(root.val);
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            if(count == 0){
                list = new ArrayList<Integer>();
                res.add(list);
                count = queue.size();
            }            
            TreeNode node = queue.poll();
            list.add(node.val);
            count--;
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}