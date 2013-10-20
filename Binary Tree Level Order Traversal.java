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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, res);
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
        list.add(root.val);
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}

/**
 * @time: 2013-08-25
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.offer(root);
        int leftCount = 0;
        while(!queue.isEmpty()){
            if(leftCount == 0){
                list = new ArrayList<Integer>();
                res.add(list);
                leftCount = queue.size();
            }
            TreeNode node = queue.poll();
            list.add(node.val);
            leftCount--;
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return res;
    }
}