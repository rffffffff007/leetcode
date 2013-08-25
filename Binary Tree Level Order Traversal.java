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
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
        if (root != null) {
            depthMap.put(root, 0);
            queue.offer(root);
        }
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            int depth = depthMap.get(node);
            ArrayList<Integer> list = null;
            if (depth < res.size()) {
                list = res.get(depth);
            } else {
                list = new ArrayList<Integer>();
                res.add(list);
            }
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                depthMap.put(node.left, depth + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                depthMap.put(node.right, depth + 1);
            }
        }
        return res;
    }
}


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
        // Start typing your Java solution below
        // DO NOT write main() function
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
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;
        ArrayList<Integer> row = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int nodesLeft = 1;
        while(!queue.isEmpty()){
            if(nodesLeft == 0){
                result.add(row);
                row = new ArrayList<Integer>();
                nodesLeft = queue.size();
            }
            TreeNode node = queue.poll();
            row.add(node.val);
            nodesLeft--;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        if(row != null){
            result.add(row);
        }
        return result;
    }
}