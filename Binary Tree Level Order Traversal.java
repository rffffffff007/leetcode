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